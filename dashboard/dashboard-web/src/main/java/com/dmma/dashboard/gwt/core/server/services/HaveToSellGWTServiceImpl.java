package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.app.utils.BaseServerDateUtils;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.Client;
import com.dmma.dashboard.core.entities.HaveToSell;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.BrokerService;
import com.dmma.dashboard.core.services.ClientService;
import com.dmma.dashboard.core.services.HaveToSellService;
import com.dmma.dashboard.gwt.core.client.services.HaveToSellGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.HaveToSellMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.HtsSearchWrapper;

/**
 * The server side implementation of the RPC service.
 */
public class HaveToSellGWTServiceImpl extends BaseGWTServiceImpl implements HaveToSellGWTService{
	private static final long serialVersionUID = -7075650418182512549L;
	private HaveToSellService haveToSellService;
	private ClientService clientService;
	private BrokerService brokerService;
	
	
	@Override
	protected void initMe(WebApplicationContext context) {
		haveToSellService    = context.getBean("haveToSellService",   HaveToSellService.class);
		clientService =  context.getBean("clientService",   ClientService.class);
		brokerService = context.getBean("brokerService",   BrokerService.class);
	}

	
	@Override
	public HaveToSellDTO findById(Integer id) throws ObjectNotExistGError {
		HaveToSell entity = haveToSellService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return HaveToSellMapper.toDTO(entity);
	}
	
	@Override
	public ArrayList<HaveToSellDTO> findAll() throws MethodPermissionGError{
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<HaveToSell> entities = haveToSellService.findAll();
		return HaveToSellMapper.toDTOs(entities);
	}

	
	@Override
	public HaveToSellDTO findByClientId(Integer clientId) {
		List<HaveToSell> entities = haveToSellService.findByClientId(clientId);
		
		return null;
	}


	@Override
	public ArrayList<HaveToSellDTO> findByBrokerCreated(Integer brokerId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<HaveToSellDTO> findMyHTS() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Integer brokerId = getLoggedInBrokerId();
		List<HaveToSell> entities = haveToSellService.findHTSToBeProcessedForBroker(brokerId);
		return HaveToSellMapper.toDTOs(entities);
	}

	@Override
	public ArrayList<HaveToSellDTO> findPartnersHTS()	throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Integer brokerId = getLoggedInBrokerId();
		Integer brokerOfficeId = getLoggedInBrokerDTO().getBrokerOffice().getId();
		List<HaveToSell> entities = haveToSellService.findHTSToBeProcessedForPartnersOfBroker(brokerId, brokerOfficeId);
		return HaveToSellMapper.toDTOs(entities);
	}


	@Override
	public ArrayList<HaveToSellDTO> findHtsBySearchWrapperAsBroker(HtsSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		wrapper.setBrokerId(getLoggedInBrokerId());
		return findHtsBySearchWrapper(wrapper);
	}


	@Override
	public ArrayList<HaveToSellDTO> findHtsBySearchWrapperAsAdmin(HtsSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		return findHtsBySearchWrapper(wrapper);
	}

	private ArrayList<HaveToSellDTO> findHtsBySearchWrapper(HtsSearchWrapper wrapper){
		Date to = wrapper.getDateTo();
		if(to!=null){
			to = BaseServerDateUtils.addDays(to, 1);
		}

		List<HaveToSell> entities = 
			haveToSellService.findHtsByCreteria(
					wrapper.getBrokerId(),
					wrapper.getHtcStatusSearchTypeId(),
					wrapper.getWantsToSellSearchTypeId(),
					wrapper.getDateFrom(),
					to	);

		return HaveToSellMapper.toDTOs(entities);
	}


	@Override
	public HaveToSellDTO findByIdAsBroker(Integer id)throws MethodPermissionGError, ObjectNotExistGError,ObjectPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		HaveToSell entity = haveToSellService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		
		Integer brokerId = getLoggedInBrokerId();
		if(!brokerId.equals(entity.getDefaultBroker().getId())){
			if(entity.getProcessedBy() == null || !brokerId.equals(entity.getProcessedBy().getId())){
				Long time  = (new Date()).getTime() - (AppProperties.htsAvailableForPartnersAfterDays*24*60*60*1000);
				if(!entity.getActiveFrom().before(new Date(time))){
					throw new ObjectPermissionGError(); 
				}	
			}
			
		}
		HaveToSellDTO retVal = HaveToSellMapper.toDTO(entity);
		if(retVal.getProcessedBy() == null){
			retVal.setProcessedBy(getLoggedInBrokerDTO());
		}
		return retVal;
	}


	@Override
	public Integer saveOrUpdate(HaveToSellDTO entity) throws MethodPermissionGError, ObjectNotExistGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		if(entity.getProcessedBy()!=null && entity.getProcessedDate() == null)
			entity.setProcessedDate(new Date());
		
		HaveToSell haveToSell = null; 
		if(entity.getId()!=null)
			haveToSell = haveToSellService.findById(entity.getId());
		
		
		haveToSell = HaveToSellMapper.mapToEntity(entity, haveToSell);
		if(entity.getClient()!=null){
			Client client = clientService.findById(entity.getClient().getId());
			haveToSell.setClient(client);
		}
		if(entity.getDefaultBroker()!=null){
			Broker broker  = brokerService.findById(entity.getDefaultBroker().getId());
			haveToSell.setDefaultBroker(broker);
		}
		if(entity.getProcessedBy()!=null){
			Broker broker  = brokerService.findById(entity.getDefaultBroker().getId());
			haveToSell.setProcessedBy(broker);
		}
		
		
		haveToSellService.saveOrUpdate(haveToSell);
		return haveToSell.getId();
	}

}
