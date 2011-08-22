package com.dmma.dashboard.gwt.core.server.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.core.entities.ClientVisit;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.entities.EstateViewing;
import com.dmma.dashboard.core.entities.HaveToSell;
import com.dmma.dashboard.core.entities.report.UnfinalyzedViewing;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.ClientService;
import com.dmma.dashboard.core.services.ClientVisitService;
import com.dmma.dashboard.core.services.EstateService;
import com.dmma.dashboard.core.services.EstateViewingService;
import com.dmma.dashboard.core.services.HaveToSellService;
import com.dmma.dashboard.core.types.ClientVisitStatusType;
import com.dmma.dashboard.gwt.core.client.services.ClientVisitGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.ClientVisitMapper;
import com.dmma.dashboard.gwt.core.server.mapper.EstateMapper;
import com.dmma.dashboard.gwt.core.server.mapper.EstateViewingMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitPlanDTOW;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ViewingAndVisitsDTOW;

/**
 * The server side implementation of the RPC service.
 */
public class ClientVisitGWTServiceImpl extends BaseGWTServiceImpl implements ClientVisitGWTService{
	private static final long serialVersionUID = -7075650418182512549L;
	private ClientVisitService clientVisitService;
	private ClientService clientService;
	private EstateViewingService estateViewingService;
	private EstateService estateService;
	private HaveToSellService haveToSellService;
	
	@Override
	protected void initMe(WebApplicationContext context) {
		clientVisitService    = context.getBean("clientVisitService",   ClientVisitService.class);
		clientService         = context.getBean("clientService",   ClientService.class);
		estateViewingService  = context.getBean("estateViewingService", EstateViewingService.class);
		estateService         = context.getBean("estateService", EstateService.class);
		haveToSellService     = context.getBean("haveToSellService",   HaveToSellService.class);
	}

	
	@Override
	public ClientVisitDTO findById(Integer id) throws MethodPermissionGError, ObjectPermissionGError, ObjectNotExistGError{
		super.thisMethodIsOnlyFor(new MySecurityUserroleType[]{MySecurityUserroleType.ROLE_ADMIN, MySecurityUserroleType.ROLE_BROKER});
		ClientVisit entity = clientVisitService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return ClientVisitMapper.toDTO(entity);
	}


	@Override
	public ArrayList<ViewingAndVisitsDTOW> findFutureViewingAndVisits(Integer estateId) {
		return findViewingAndVisits(estateId, true);
	}


	@Override
	public ArrayList<ViewingAndVisitsDTOW> findPastViewingAndVisits(Integer estateId) {
		return findViewingAndVisits(estateId, false);
	}

	private ArrayList<ViewingAndVisitsDTOW> findViewingAndVisits(Integer estateId, boolean ifForFuture) {
		List<EstateViewing> viewings = estateViewingService.findByEstateId(estateId, ifForFuture);
		if(viewings==null || viewings.isEmpty()) return null;
		
		ArrayList<ViewingAndVisitsDTOW> retVal = new ArrayList<ViewingAndVisitsDTOW>(viewings.size());
		for(EstateViewing viewing:viewings){
			ViewingAndVisitsDTOW vv = new ViewingAndVisitsDTOW();
			vv.setEstateViewing(EstateViewingMapper.toDTO(viewing));
			
			List<ClientVisit> clientVisits =  clientVisitService.findByEstateViewingId(viewing.getId());
			vv.setClientVisits(ClientVisitMapper.toDTOSs(clientVisits));
			
			retVal.add(vv);
		}
		return retVal;
	}
	
	
	@Override
	public ClientVisitPlanDTOW getClientVisitPlanAsAdmin(Integer viewingId) throws MethodPermissionGError, ObjectNotExistGError {
		super.thisMethodIsOnlyForADMIN();
		return getClientVisitPlan(viewingId);
	}


	@Override
	public ClientVisitPlanDTOW getClientVisitPlanAsBroker(Integer viewingId) throws MethodPermissionGError, ObjectPermissionGError, ObjectNotExistGError {
		super.thisMethodIsOnlyForBROKER();
		ClientVisitPlanDTOW retVal = getClientVisitPlan(viewingId);
		Integer myBrokerId = super.getLoggedInBrokerId();
		if(!myBrokerId.equals(retVal.getEstate().getBroker().getId()))
			throw new ObjectPermissionGError();
		return retVal;
	}

	private ClientVisitPlanDTOW getClientVisitPlan(Integer viewingId) throws ObjectNotExistGError {
		EstateViewing viewing = estateViewingService.findById(viewingId);
		if(viewing == null ) throw new ObjectNotExistGError();
		
		ClientVisitPlanDTOW retVal = new ClientVisitPlanDTOW();
		retVal.setEstateViewing(EstateViewingMapper.toDTO(viewing));
		
		Estate estate = estateService.findById(viewing.getEstateId());
		retVal.setEstate(EstateMapper.toDTO(estate));
		
		Date now = new Date();
		retVal.setIsFuture(now.before(viewing.getDateFrom()));
		
		List<ClientVisit> visits = clientVisitService.findByEstateViewingId(viewing.getId());
		retVal.setClientVisits(ClientVisitMapper.toDTOSs(visits));
		
		return retVal;
	}
	

	@Override
	public Integer saveOrUpdate(ClientVisitDTO entity) throws MethodPermissionGError, ObjectNotExistGError {
		super.thisMethodIsOnlyFor(new MySecurityUserroleType[]{MySecurityUserroleType.ROLE_ADMIN, MySecurityUserroleType.ROLE_BROKER});

		
		
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ClientVisitDTOS saveOrUpdateDTOS(ClientVisitDTOS entityDTO) throws MethodPermissionGError{
		super.thisMethodIsOnlyFor(new MySecurityUserroleType[]{MySecurityUserroleType.ROLE_ADMIN, MySecurityUserroleType.ROLE_BROKER});
		if(entityDTO == null) return null;
		if(entityDTO.getEstateId()==null){
			log.error("entityDTO.getEstateId()==null - required field");
			return null;
		} 
		if(entityDTO.getClient()==null || entityDTO.getClient().getId() == null){
			log.error("entityDTO.getClient()==null - required field");
			return null;
		} 
		if(entityDTO.getEstateViewingId() == null ){
			log.error("entityDTO.getEstateViewingId()==null - required field");
			return null;
		} 
		
		ClientVisit entity = null;
		if(entityDTO.getId()!=null){
			entity = clientVisitService.findById(entityDTO.getId());
		}else{
			entity = new ClientVisit();
			entity.setCreated(new Date());
		}
		//simple mappings
		// setCreated - not editable 
		entity.setComments(entityDTO.getComments());
		entity.setStatus(entityDTO.getStatus());
			
		//Client
		if(entity.getClient()==null || !entityDTO.getClient().getId().equals(entity.getClient().getId())){
			entity.setClient(clientService.findById(entityDTO.getClient().getId()));	
		}
		
		//Estate
		if(entity.getEstate() == null || !entityDTO.getEstateId().equals(entity.getEstate().getId())){
			entity.setEstate(estateService.findById(entityDTO.getEstateId()));	
		}
		//Estate
		if(entity.getEstateViewing() == null || !entityDTO.getEstateViewingId().equals(entity.getEstateViewing().getId())){
			entity.setEstateViewing(estateViewingService.findById(entityDTO.getEstateViewingId()));
		}
		
		clientVisitService.saveOrUpdate(entity);
		
		if(ClientVisitStatusType.isWasOnViewing.getId().equals(entity.getStatus()))
				tryToRegisterHTS(entity.getId(),entity.getClient().getId(), entity.getEstate().getBroker().getId());
		
		return ClientVisitMapper.toDTOS(entity);
	}


	//TODO make it as separate thread
	private void tryToRegisterHTS(Integer clientVisitId, Integer clientId, Integer defaultBrokerId ) {
		if(haveToSellService.doWeNeedToCreateHTS(clientId)){
			HaveToSell hts = new HaveToSell();
			hts.setCreated(new Date());
			hts.setActiveFrom(hts.getCreated());
			hts.setClientVisitId(clientVisitId);
			hts.setClient(clientService.findById(clientId));
			hts.setDefaultBroker(brokerService.findById(defaultBrokerId));
			
			haveToSellService.saveOrUpdate(hts);
			
			
		}
	}


	@Override
	public ArrayList<UnfinalyzedViewingDTOW> findUnfinalyzedViewings() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		return findUnfinalyzedViewings(super.getLoggedInBrokerId());
	}


	@Override
	public ArrayList<UnfinalyzedViewingDTOW> findUnfinalyzedViewingsAsAdmin (Integer brokerId) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		return findUnfinalyzedViewings(brokerId);
	}
	
	
	public ArrayList<UnfinalyzedViewingDTOW> findUnfinalyzedViewings(Integer brokerId){
		List<UnfinalyzedViewing> list = clientVisitService.findUnfinalyzedViewings(brokerId);
		if(list==null||list.isEmpty()) return null;
		
		ArrayList<UnfinalyzedViewingDTOW> retVal = new ArrayList<UnfinalyzedViewingDTOW>(list.size()); 
		for(UnfinalyzedViewing viewing : list){
			UnfinalyzedViewingDTOW wDTO = new UnfinalyzedViewingDTOW();
			
			EstateViewing estateViewing = estateViewingService.findById(viewing.getEstateViewingId());
			wDTO.setEstateViewing(EstateViewingMapper.toDTO(estateViewing));
			
			Estate estate = estateService.findById(estateViewing.getEstateId());
			wDTO.setEstate(EstateMapper.toDTO(estate));
			
			wDTO.setUnknownStatusAmount(viewing.getUnknownStatusAmount());
			retVal.add(wDTO);
		}
		return retVal;
	}
	

	
}
