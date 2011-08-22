package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.core.entities.BankOffice;
import com.dmma.dashboard.core.entities.Banker;
import com.dmma.dashboard.core.entities.User;
import com.dmma.dashboard.core.entities.UserRole;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.BankOfficeService;
import com.dmma.dashboard.core.services.UserRoleService;
import com.dmma.dashboard.gwt.core.client.services.BankerGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.BankerMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisUserGError;

/**
 * The server side implementation of the RPC service.
 */
public class BankerGWTServiceImpl extends BaseGWTServiceImpl implements BankerGWTService {
	private static final long serialVersionUID = 3333153923994886123L;
	protected BankOfficeService   bankOfficeService;
	private   UserRoleService     userRoleService;
	
	@Override
	protected void initMe(WebApplicationContext context) {
		bankOfficeService = context.getBean("bankOfficeService", BankOfficeService.class);
		userRoleService   = context.getBean("userRoleService",   UserRoleService.class);
	}

	@Override
	public BankerDTO getMyInfo() {
		return getLoggedInBankerDTO();
	}


	@Override
	public BankerDTO findById(Integer id) throws ObjectNotExistGError {
		Banker entity = bankerService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return BankerMapper.toDTO(entity);
	}

	@Override
	public ArrayList<BankerDTO> findAll() {
		//if sec. needed : super.thisServiceIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<Banker> entities = bankerService.findAll();
		return BankerMapper.toDTOs(entities);
	}


	@Override
	public Integer saveOrUpdate(BankerDTO entity, String password) throws MethodPermissionGError, ExternalOrMidasIdIsInUseGError, SomeoneElseHaveThisUserGError, EmailIsNotUniqueGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		if(entity.getId()==null && entity.getUserId()==null){
			// new user & banker
			return createBankerAndUser(entity, password);
		}else if(entity.getId()==null){
			// new banker with existing user
			return addBankerToUser(entity);
		}else{
			// update banker profile
			return updateBankerProfile(entity);
		}
	}

	@Override
	public BankerDTO findByExternalId(Long externalId) {
		Banker entity = bankerService.findByExternalId(externalId);
		return BankerMapper.toDTO(entity);
	}


	@Override
	public ArrayList<BankerDTO> findByBankOfficeId(Integer bankOfficeId) {
		List<Banker> entities = bankerService.findByBankOfficeId(bankOfficeId);
		return BankerMapper.toDTOs(entities);
	}

	@Override
	public BankerDTO findByUserId(Integer userId) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		Banker entity = bankerService.findByUserId(userId);
		return BankerMapper.toDTO(entity);
	}





	
	
	
	
	
	private Integer createBankerAndUser(BankerDTO entity, String password) throws ExternalOrMidasIdIsInUseGError, EmailIsNotUniqueGError {
		if(entity.getExternalId()!=null) checkExtIdIsUnique(entity.getExternalId());
		checkEmailIsUniqueLogin(entity.getEmail());
		// Create user
		User user = new User();
		user.setBankerExternalId(entity.getExternalId());
		user.setEmail(entity.getEmail());
		user.setEnabled(true);
		user.setPassword(password);
		user.setTitle(entity.getName());
		userService.saveOrUpdate(user);
		Integer userId = user.getId();
		if(userId==null) return null;
		// SetRole to User
		UserRole bankerRole = new UserRole();
		bankerRole.setUserId(userId);
		bankerRole.setRole(MySecurityUserroleType.ROLE_BANKER.name());
		userRoleService.saveOrUpdate(bankerRole);
		// Create broker
		Banker banker = BankerMapper.mapToEntity(entity, null);
		banker.setUserId(userId);
		BankOffice bankOffice = bankOfficeService.findById(entity.getBankOffice().getId());
		banker.setBankOffice(bankOffice);
		bankerService.saveOrUpdate(banker);
		return banker.getId();
	}


	private Integer addBankerToUser(BankerDTO entity) throws SomeoneElseHaveThisUserGError, ExternalOrMidasIdIsInUseGError {
		checkIfSomeoneElseHaveThisUser(entity.getUserId());
		if(entity.getExternalId()!=null)
			checkExtIdIsUnique(entity.getExternalId());
		
		Banker banker = BankerMapper.mapToEntity(entity, null);
		BankOffice bankOffice = bankOfficeService.findById(entity.getBankOffice().getId());
		banker.setBankOffice(bankOffice);
		bankerService.saveOrUpdate(banker);
		if(banker.getId()==null) return null;
		UserRole bankerRole = new UserRole();
		bankerRole.setUserId(entity.getUserId());
		bankerRole.setRole(MySecurityUserroleType.ROLE_BANKER.name());
		userRoleService.saveOrUpdate(bankerRole);
		User hisUser = userService.findById(entity.getUserId());
		hisUser.setBankerExternalId(banker.getExternalId());
		userService.saveOrUpdate(hisUser);
		
		return banker.getId();
	}


	private Integer updateBankerProfile(BankerDTO entity) throws ExternalOrMidasIdIsInUseGError {
		Banker existing = bankerService.findById(entity.getId());
		if(entity.getExternalId()!=null && !entity.getExternalId().equals(existing.getExternalId()))
			checkExtIdIsUnique(entity.getExternalId());
		
		existing = BankerMapper.mapToEntity(entity, existing);
		if(existing.getBankOffice().getId()!=entity.getBankOffice().getId()){
			BankOffice newOffice = bankOfficeService.findById(entity.getBankOffice().getId());
			existing.setBankOffice(newOffice);
		}
		bankerService.saveOrUpdate(existing);
		User hisUser = userService.findById(existing.getUserId());
		hisUser.setBankerExternalId(existing.getExternalId());
		userService.saveOrUpdate(hisUser);
		return existing.getId();
	}

	private void checkExtIdIsUnique(Long externalId) throws ExternalOrMidasIdIsInUseGError {
		Banker existing = bankerService.findByExternalId(externalId);
		if(existing!=null)
			throw new ExternalOrMidasIdIsInUseGError();
	}


	private void checkIfSomeoneElseHaveThisUser(Integer userId) throws SomeoneElseHaveThisUserGError {
		Banker existing = bankerService.findByUserId(userId);
		if(existing!=null)
			throw new SomeoneElseHaveThisUserGError();
	}


	private void checkEmailIsUniqueLogin(String email) throws EmailIsNotUniqueGError {
		if(userService.findByEmail(email)!=null)
			throw new EmailIsNotUniqueGError();
	}

	@Override
	public ArrayList<ListBoxDTO> findByBankOfficeIdShort(Integer bankOfficeId) {
		List<Banker> entities = bankerService.findByBankOfficeId(bankOfficeId);
		return BankerMapper.toShortDTOs(entities);
	}

	@Override
	public ArrayList<ListBoxDTO> findAllShort() {
		List<Banker> entities = bankerService.findAll();
		return BankerMapper.toShortDTOs(entities);
	}

	@Override
	public ArrayList<BankerDTO> findMyRecentBankerList() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Integer brokerId = super.getLoggedInBrokerId();
		List<Banker> entities = bankerService.findBrokersRecentBankerList(brokerId);
		return BankerMapper.toDTOs(entities);
	}



}
