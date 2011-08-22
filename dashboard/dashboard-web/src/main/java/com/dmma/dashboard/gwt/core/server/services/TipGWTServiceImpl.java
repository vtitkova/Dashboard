package com.dmma.dashboard.gwt.core.server.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.core.entities.Banker;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.Client;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.entities.Tip;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.ClientService;
import com.dmma.dashboard.core.services.EstateService;
import com.dmma.dashboard.core.services.TipService;
import com.dmma.dashboard.core.types.TipDirectionType;
import com.dmma.dashboard.core.types.TipStatusType;
import com.dmma.dashboard.core.types.TipType;
import com.dmma.dashboard.gwt.core.client.services.TipGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.TipMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;

/**
 * The server side implementation of the RPC service.
 */
public class TipGWTServiceImpl extends BaseGWTServiceImpl implements TipGWTService {
	private static final long serialVersionUID = 7492925876500885960L;

	private EstateService estateService;
	private ClientService clientService;
	private TipService tipService;

	@Override
	protected void initMe(WebApplicationContext context) {
		tipService    = context.getBean("tipService",    TipService.class);
		clientService = context.getBean("clientService", ClientService.class);
		estateService = context.getBean("estateService", EstateService.class);
	}

	@Override
	public TipDTO findByIdAsBanker(Integer id) throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BANKER);
		
		Tip entity = tipService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		
		Integer bankerId = entity.getBanker().getId();
		if( !bankerId.equals(getLoggedInBankerId()) ){
			throw new ObjectPermissionGError(); 
		}
		return TipMapper.toDTO(entity);
	}
	@Override
	public TipDTO findByIdAsBroker(Integer id) throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Tip entity = tipService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		
		Integer brokerId = entity.getBroker().getId();
		if( !brokerId.equals(getLoggedInBrokerId())){
			throw new ObjectPermissionGError(); 
		}
		return TipMapper.toDTO(entity);
	}
	
	@Override
	public TipDTO findByIdAsAdmin(Integer id) throws MethodPermissionGError, ObjectNotExistGError{
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		Tip entity = tipService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return TipMapper.toDTO(entity);
	}

	@Override
	public ArrayList<TipDTO> findTipsBySearchWrapperAsBroker(TipSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		wrapper.setBrokerId(getLoggedInBrokerId());
		return findTipsByWrapper(wrapper);
	}

	@Override
	public ArrayList<TipDTO> findTipsBySearchWrapperAsBanker(TipSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BANKER);
		wrapper.setBankerId(getLoggedInBankerId());
		return findTipsByWrapper(wrapper);
	}

	@Override
	public ArrayList<TipDTO> findTipsBySearchWrapperAsAdmin(TipSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		return findTipsByWrapper(wrapper);
	}
	
	private ArrayList<TipDTO> findTipsByWrapper(TipSearchWrapper wrapper){
		TipDirectionType tipDirectionType = TipDirectionType.findById(wrapper.getTipDirectionSearchTypeId());
		TipType          tipType          = TipType.findById(wrapper.getTipTypeSearchTypeId());
		TipStatusType    tipStatusType    = TipStatusType.findById(wrapper.getTipStatusSearchTypeId());
		Integer bankOfficeId = wrapper.getBankOfficeId(); 
		Integer bankerId     = wrapper.getBankerId();
		Integer brokerOfficeId = wrapper.getBrokerOfficeId();
		Integer brokerId       = wrapper.getBrokerId(); 
		Date dateFrom = wrapper.getDateFrom();
		Date dateTo   = wrapper.getDateTo();
		
		List<Tip> etities = tipService.findBySearchCreteria(tipDirectionType, tipType, tipStatusType, bankOfficeId, bankerId, brokerOfficeId, brokerId, dateFrom, dateTo);
		return TipMapper.toDTOs(etities);
	}

	@Override
	public Integer saveOrUpdateForAll(TipDTO entity){
		return saveOrUpdateTip(entity);
	}
	@Override
	public Integer saveOrUpdate(TipDTO entity) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		return saveOrUpdateTip(entity);
	}

	private Integer saveOrUpdateTip(TipDTO entity){
		Tip existingTip = null;
		if(entity.getId() != null)
			existingTip = tipService.findById(entity.getId());
		
		existingTip = TipMapper.mapToEntity(entity, existingTip);
		
		Broker broker = brokerService.findById(entity.getBroker().getId());
		existingTip.setBroker(broker);
		Banker banker = bankerService.findById(entity.getBanker().getId());
		existingTip.setBanker(banker);
		Client client = clientService.findById(entity.getClient().getId());
		existingTip.setClient(client);
		if(entity.getEstate()!=null){
			Estate estate = estateService.findById(entity.getEstate().getId());
			existingTip.setEstate(estate);
		}
		tipService.saveOrUpdate(existingTip);
		return existingTip.getId();
		
	}

	@Override
	public ArrayList<TipDTO> findTipsTodoAsBroker() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		List<Tip> etities = tipService.findTipsTodoForBroker(super.getLoggedInBrokerId());
		return TipMapper.toDTOs(etities);
	}

	@Override
	public ArrayList<TipDTO> findTipsTodoAsBanker() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BANKER);
		List<Tip> etities = tipService.findTipsTodoForBanker(super.getLoggedInBankerId());
		return TipMapper.toDTOs(etities);
	}
}
