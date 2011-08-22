package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.BrokerOffice;
import com.dmma.dashboard.core.entities.User;
import com.dmma.dashboard.core.entities.UserRole;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.BrokerOfficeService;
import com.dmma.dashboard.core.services.UserRoleService;
import com.dmma.dashboard.gwt.core.client.services.BrokerGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.BrokerMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisUserGError;

/**
 * The server side implementation of the RPC service.
 */
public class BrokerGWTServiceImpl extends BaseGWTServiceImpl implements BrokerGWTService {
	private static final long serialVersionUID = 3333153923994886123L;
	protected BrokerOfficeService   brokerOfficeService;
	private   UserRoleService       userRoleService;
	

	@Override
	protected void initMe(WebApplicationContext context) {
		//brokerService is alredy in BaseGWTServiceImpl
		brokerOfficeService = context.getBean("brokerOfficeService", BrokerOfficeService.class);
		userRoleService   = context.getBean("userRoleService",   UserRoleService.class);
	}


	@Override
	public BrokerDTO getMyInfo() {
		return getLoggedInBrokerDTO();
	}


	@Override
	public BrokerDTO findById(Integer id) throws ObjectNotExistGError {
		Broker entity = brokerService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return BrokerMapper.toDTO(entity);
	}

	@Override
	public ArrayList<BrokerDTO> findAll() {
		//if sec. needed : super.thisServiceIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<Broker> entities = brokerService.findAll();
		return BrokerMapper.toDTOs(entities);
	}


	@Override
	public Integer saveOrUpdate(BrokerDTO entity, String password) throws ExternalOrMidasIdIsInUseGError, SomeoneElseHaveThisUserGError, EmailIsNotUniqueGError {
		if(entity.getId()==null && entity.getUserId()==null){
			// new user & banker
			return createBrokerAndUser(entity, password);
		}else if(entity.getId()==null){
			// new banker with existing user
			return addBrokerToUser(entity);
		}else{
			// update banker profile
			return updateBrokerProfile(entity);
		}
	}
	
	@Override
	public BrokerDTO findByMidasId(Long madasId) {
		Broker entity = brokerService.findByMidasId(madasId);
		return BrokerMapper.toDTO(entity);
	}
	
	@Override
	public ArrayList<BrokerDTO> findByBrokerOfficeId(Integer brokerOfficeId) {
		List<Broker> entities = brokerService.findByBrokerOfficeId(brokerOfficeId);
		return BrokerMapper.toDTOs(entities);
	}


	@Override
	public BrokerDTO findByUserId(Integer userId) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		Broker entity = brokerService.findByUserId(userId);
		return BrokerMapper.toDTO(entity);
	}

	
	
	private Integer createBrokerAndUser(BrokerDTO entity, String password) throws ExternalOrMidasIdIsInUseGError, EmailIsNotUniqueGError {
		if(entity.getMidasId()!=null) checkMidasIdIsUnique(entity.getMidasId());
		checkEmailIsUniqueLogin(entity.getEmail());
		// Create user
		User user = new User();
		user.setBrokerMidasId(entity.getMidasId());
		user.setEmail(entity.getEmail());
		user.setEnabled(true);
		user.setPassword(password);
		user.setTitle(entity.getName());
		userService.saveOrUpdate(user);
		Integer userId = user.getId();
		if(userId==null) return null;
		// SetRole to User
		UserRole brokerRole = new UserRole();
		brokerRole.setUserId(userId);
		brokerRole.setRole(MySecurityUserroleType.ROLE_BROKER.name());
		userRoleService.saveOrUpdate(brokerRole);
		// Create broker
		Broker broker = BrokerMapper.mapToEntity(entity, null);
		broker.setUserId(userId);
		BrokerOffice brokerOffice = brokerOfficeService.findById(entity.getBrokerOffice().getId());
		broker.setBrokerOffice(brokerOffice);
		brokerService.saveOrUpdate(broker);
		return broker.getId();
	}


	private Integer addBrokerToUser(BrokerDTO entity) throws SomeoneElseHaveThisUserGError, ExternalOrMidasIdIsInUseGError {
		checkIfSomeoneElseHaveThisUser(entity.getUserId());
		if(entity.getMidasId()!=null)
			checkMidasIdIsUnique(entity.getMidasId());
		
		Broker broker = BrokerMapper.mapToEntity(entity, null);
		BrokerOffice brokerOffice = brokerOfficeService.findById(entity.getBrokerOffice().getId());
		broker.setBrokerOffice(brokerOffice);
		brokerService.saveOrUpdate(broker);
		if(broker.getId()==null) return null;
		UserRole brokerRole = new UserRole();
		brokerRole.setUserId(entity.getUserId());
		brokerRole.setRole(MySecurityUserroleType.ROLE_BROKER.name());
		userRoleService.saveOrUpdate(brokerRole);
		User hisUser = userService.findById(entity.getUserId());
		hisUser.setBrokerMidasId(broker.getMidasId());
		userService.saveOrUpdate(hisUser);
		return broker.getId();
	}


	private Integer updateBrokerProfile(BrokerDTO entity) throws ExternalOrMidasIdIsInUseGError {
		Broker existing = brokerService.findById(entity.getId());
		if(entity.getMidasId()!=null && !entity.getMidasId().equals(existing.getMidasId()))
			checkMidasIdIsUnique(entity.getMidasId());
		
		existing = BrokerMapper.mapToEntity(entity, existing);
		if(existing.getBrokerOffice().getId()!=entity.getBrokerOffice().getId()){
			BrokerOffice newOffice = brokerOfficeService.findById(entity.getBrokerOffice().getId());
			existing.setBrokerOffice(newOffice);
		}
		brokerService.saveOrUpdate(existing);
		User hisUser = userService.findById(existing.getUserId());
		hisUser.setBrokerMidasId(existing.getMidasId());
		userService.saveOrUpdate(hisUser);
		return existing.getId();
	}
	
	private void checkMidasIdIsUnique(Long midasId) throws ExternalOrMidasIdIsInUseGError {
		Broker existing = brokerService.findByMidasId(midasId);
		if(existing!=null)
			throw new ExternalOrMidasIdIsInUseGError();
	}


	private void checkIfSomeoneElseHaveThisUser(Integer userId) throws SomeoneElseHaveThisUserGError {
		Broker existing = brokerService.findByUserId(userId);
		if(existing!=null)
			throw new SomeoneElseHaveThisUserGError();
	}


	private void checkEmailIsUniqueLogin(String email) throws EmailIsNotUniqueGError {
		if(userService.findByEmail(email)!=null)
			throw new EmailIsNotUniqueGError();
	}

	@Override
	public ArrayList<ListBoxDTO> findAllShort() {
		List<Broker> entities = brokerService.findAll();
		return BrokerMapper.toShortDTOs(entities);
	}

	@Override
	public ArrayList<ListBoxDTO> findByBrokerOfficeIdShort(Integer brokerOfficeId) {
		List<Broker> entities = brokerService.findByBrokerOfficeId(brokerOfficeId);
		return BrokerMapper.toShortDTOs(entities);
	}
		
	@Override
	public ArrayList<BrokerDTO> findMyRecentBrokerList() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BANKER);
		Integer bankerId = super.getLoggedInBankerId();
		List<Broker> entities = brokerService.findBankersRecentBrokerList(bankerId);
		return BrokerMapper.toDTOs(entities);
	}

	
}
