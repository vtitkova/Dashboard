package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.entities.EstateViewing;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.EstateService;
import com.dmma.dashboard.gwt.core.client.services.EstateGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.EstateMapper;
import com.dmma.dashboard.gwt.core.server.mapper.EstateViewingMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.errors.SynhronizationGError;
import com.dmma.dashboard.gwt.core.shared.errors.ThatIsNotBrokersEstateGError;
import com.dmma.dashboard.gwt.core.shared.errors.ThisEstateisRegisteredGError;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.dmma.dashboard.midas.MidasClient;
import com.dmma.dashboard.midas.errors.NoSuchEstate;
import com.dmma.dashboard.midas.errors.ThatIsNotYourEstate;

/**
 * The server side implementation of the RPC service.
 */
public class EstateGWTServiceImpl extends BaseGWTServiceImpl implements EstateGWTService {
	private static final long serialVersionUID = 7492925876500885960L;

	private EstateService estateService;
	private MidasClient midasClient;

	@Override
	protected void initMe(WebApplicationContext context) {
		estateService = context.getBean("estateService",    EstateService.class);
		midasClient   = context.getBean("midasClient",    MidasClient.class);
	}


	@Override
	public ArrayList<EstateDTO> getMyEstates() throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Integer brokerId = getLoggedInBrokerId();
		List<Estate> etities = estateService.findByBrokerId(brokerId);
		return EstateMapper.toDTOs(etities);
	}

	@Override
	public EstateDTO findByIdAsBroker(Integer id) throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError{
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Estate entity = estateService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		Integer brokerId = getLoggedInBrokerId();
		if(brokerId==null||!brokerId.equals(entity.getBroker().getId())){
			throw new ObjectPermissionGError(); 
		}
		
		return EstateMapper.toDTO(entity);
	}
	
	public EstateDTO findByIdAsAdmin(Integer id) throws MethodPermissionGError, ObjectNotExistGError{
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		Estate entity = estateService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return EstateMapper.toDTO(entity);
	}
	

	@Override
	public EstateDTO getBrokersEstateFromMidas(Long estateMidasId, Long brokerMidasId) throws ThatIsNotBrokersEstateGError, MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		EstateDTO estateDTO = getEstateFromMidas(estateMidasId, brokerMidasId);
		return estateDTO;
	}

	@Override
	public EstateDTO getMyEstateFromMidas(Long estateMidasId) throws ThatIsNotBrokersEstateGError, MethodPermissionGError, ThisEstateisRegisteredGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		checkEstateIsExisting(estateMidasId);
		Long myBrokerMidasId = getLoggedInBrokerMidasId();
		EstateDTO estateDTO = getEstateFromMidas(estateMidasId, myBrokerMidasId);
		return estateDTO;
		
	}
	
	

	private EstateDTO getEstateFromMidas(Long estateMidasId, Long brokerMidasId) throws ThatIsNotBrokersEstateGError{
		Estate estate = null;
		try {
			estate = midasClient.getEstate(estateMidasId, brokerMidasId);
		} catch (ThatIsNotYourEstate e) {
			log.error("EstateGWTServiceImpl->getEstateFromMidas("+estateMidasId+","+brokerMidasId+") - ThatIsNotYourEstate");
			throw new ThatIsNotBrokersEstateGError();
		} catch (NoSuchEstate e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ThatIsNotBrokersEstateGError();
		}
		return EstateMapper.toDTO(estate);
	}


	@Override
	public Integer saveMyEstateFromMidas(EstateDTO estateDTO)	throws MethodPermissionGError, ThisEstateisRegisteredGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		checkEstateIsExisting(estateDTO.getMidasId());
		Integer myId = getLoggedInBrokerId();
		Broker broker = brokerService.findById(myId);
		
		Estate estateToSave = EstateMapper.mapToEntity(estateDTO, null);
		estateToSave.setBroker(broker);
		List<EstateViewing> estateViewings = EstateViewingMapper.mapToNewEntities(estateDTO.getEstateViewings());
		estateToSave.setEstateViewings(estateViewings);
		
		estateService.saveOrUpdate(estateToSave);
		return estateToSave.getId();
	}
	
	private void checkEstateIsExisting(Long midasId) throws ThisEstateisRegisteredGError {
		if(estateService.findByMidasId(midasId)!=null)
			throw new ThisEstateisRegisteredGError();
	}


	@Override
	public ArrayList<EstateDTO> findEstateBySearchWrapper(EstateSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		return findBySearchWrapper(wrapper);
	}
	@Override
	public ArrayList<EstateDTO> findEstateBySearchWrapperForAll(EstateSearchWrapper wrapper){
		return findBySearchWrapper(wrapper);
	}
	
	public ArrayList<EstateDTO> findMyEstateBySearchWrapper(EstateSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
		Integer brokerId = getLoggedInBrokerId();
		wrapper.setBrokerId(brokerId);
		return findBySearchWrapper(wrapper);
	}
	
	@Override
	public ArrayList<ListBoxDTO> findEstateBySearchWrapperShort(EstateSearchWrapper wrapper) throws MethodPermissionGError {
		super.thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
		List<Estate> etities = estateService.findBySearchCreteria(
				wrapper.getStatusSearchTypeId(),
				wrapper.getOfficeId(),
				wrapper.getBrokerId());
		return EstateMapper.toShortDTOs(etities);
	}
	
	
	
	private ArrayList<EstateDTO> findBySearchWrapper(EstateSearchWrapper wrapper){
		List<Estate> etities = estateService.findBySearchCreteria(
				wrapper.getStatusSearchTypeId(),
				wrapper.getOfficeId(),
				wrapper.getBrokerId());
		return EstateMapper.toDTOs(etities);
		
	}


	@Override
	public EstateDTO synhronizeEstateById(Integer id) throws MethodPermissionGError, ObjectNotExistGError, SynhronizationGError {
		super.thisMethodIsOnlyFor(new MySecurityUserroleType[]{MySecurityUserroleType.ROLE_ADMIN, MySecurityUserroleType.ROLE_BROKER});
		Estate entity = estateService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();

		Estate estateFromMidas;
		try {
			estateFromMidas = midasClient.getEstate(entity.getMidasId(), entity.getBroker().getMidasId());
		} catch (ThatIsNotYourEstate e) {
			throw new SynhronizationGError();
		}catch (NoSuchEstate e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SynhronizationGError();
		}
		if(estateFromMidas==null)
			throw new SynhronizationGError();
		
		Estate estateToSave = EstateMapper.mapToEntity(estateFromMidas, entity);
		//We don't change broker
		//Update Viewings: add new - extend existing list
		List<EstateViewing> estateViewings = EstateViewingMapper.extendExistingViewings(entity.getEstateViewings(), estateFromMidas.getEstateViewings());
		estateToSave.setEstateViewings(estateViewings);
		
		estateService.saveOrUpdate(estateToSave);

	
		return EstateMapper.toDTO(estateToSave);
	}
	
	
	
	
}
