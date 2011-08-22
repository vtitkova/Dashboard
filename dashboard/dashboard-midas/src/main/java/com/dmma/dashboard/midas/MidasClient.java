package com.dmma.dashboard.midas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.BrokerOffice;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.entities.dto.OfficeBrokerEstate;
import com.dmma.dashboard.core.types.EstateStatusType;
import com.dmma.dashboard.midas.dto.GetBrokerDTO;
import com.dmma.dashboard.midas.dto.GetChangedDTO;
import com.dmma.dashboard.midas.dto.GetOfficeDTO;
import com.dmma.dashboard.midas.dto.GetProspectXMLElement;
import com.dmma.dashboard.midas.errors.NoSuchBrokerFound;
import com.dmma.dashboard.midas.errors.NoSuchBrokerInOffice;
import com.dmma.dashboard.midas.errors.NoSuchEstate;
import com.dmma.dashboard.midas.errors.NoSuchOfficeFound;
import com.dmma.dashboard.midas.errors.ThatIsNotYourEstate;

public class MidasClient {
	MidasConnector connector;
	MidasDTOMapper dtoMapper;

	public MidasClient(){
		connector = new MidasConnector();
		dtoMapper = new MidasDTOMapper();
	}


	protected Broker getBroker(Long midasBrokerId) {

		String brokerXML = connector.getBrokerPXML(midasBrokerId.toString());
		GetBrokerDTO brokerDTO = dtoMapper.getBrokerDTO(brokerXML);
		if (brokerDTO == null) {
			return null;
		}
		Broker b = brokerDTO.toBroker();
		return b;
	}


	protected Set<Long> getMidasBrokerIDsByOffice(Long midasOfficeId) {
		//FIME usefull method
		String brokersXML = connector.getBrokerPByOfficeXML(midasOfficeId.toString());
		List<GetBrokerDTO> brokersDTO = dtoMapper.getBrokerDTOs(brokersXML);

		Set<Long> brokers = new HashSet<Long>();
		for (GetBrokerDTO brokerDTO : brokersDTO) {
			if (brokerDTO != null) {
				brokers.add(brokerDTO.id);
			}
		}
		return brokers;
	}

	protected BrokerOffice getOffice(Long midasOfficeId) {
		String officeXML = connector.getOfficeXML(midasOfficeId.intValue());
		GetOfficeDTO officeDTO = dtoMapper.getOfficeDTO(officeXML);
		if (officeDTO == null) {
			return null;
		}
		return officeDTO.toOffice();
	}


	protected List<GetChangedDTO> getChanged(int minutes) {
		String getChangedXML = connector.getChangedEstates(minutes);
		List<GetChangedDTO> changedDTOs = dtoMapper.getChangedDTOs(getChangedXML);
		return changedDTOs;
	}


	public Broker getBrokerWithOffice(Long midasBrokerId, Long midasOfficeId) throws NoSuchBrokerFound, NoSuchOfficeFound, NoSuchBrokerInOffice {
		Broker broker = getBroker(midasBrokerId);
		if(broker == null) throw new NoSuchBrokerFound();

		BrokerOffice brokerOffice = getOffice(midasOfficeId);
		if(brokerOffice == null) throw new NoSuchOfficeFound();

		if(!isSuchBrokerInOffice(midasBrokerId, midasOfficeId)) 
			throw new NoSuchBrokerInOffice();

		broker.setBrokerOffice(brokerOffice);
		return broker;
	}


	private boolean isSuchBrokerInOffice(Long midasBrokerId, Long midasOfficeId) {
		Set<Long> listOfId = getMidasBrokerIDsByOffice(midasOfficeId);
		for(Long l:listOfId){
			if(l.equals(midasBrokerId))
				return true;
		}
		return false;
	}


	public Estate getEstate(Long estateMidasId, Long brokerMidasId ) throws ThatIsNotYourEstate, NoSuchEstate {
		String prospectXML = connector.getProspectXML(estateMidasId);
		GetProspectXMLElement prospectXMLElement = dtoMapper.getProspectXMLElement(prospectXML);
		if(prospectXMLElement==null||prospectXMLElement.prospectMain==null||prospectXMLElement.prospectMain.estateid==null){

			throw new NoSuchEstate();
		} 
		Long brokerMidasIdFromService = new Long(prospectXMLElement.prospectMain.brokerid);
		if(!brokerMidasId.equals(brokerMidasIdFromService)){
			throw new ThatIsNotYourEstate();
		}
		return prospectXMLElement.toEstate();
	}


	public List<OfficeBrokerEstate> getLastOfficeBrokerEstates(Integer kakoetoIntZnachenie) throws NoSuchBrokerFound, NoSuchOfficeFound, NoSuchBrokerInOffice{
		List<OfficeBrokerEstate> retVal = getLastEstates(kakoetoIntZnachenie);
		HashMap<Integer, Broker> hashBrokers = new HashMap<Integer, Broker>();

		for(OfficeBrokerEstate element : retVal){
			Broker b =  hashBrokers.get(element.getBrokerId());
			if(b == null){
					b = getBrokerWithOffice(element.getBrokerId(), new Long(element.getOfficeId()));
				hashBrokers.put(b.getId(), b);
			} 
			element.setBrokerEmail(b.getEmail());
			element.setBrokerDisplayName(b.getName() + " " + b.getSurname());
			
			element.setOfficeName(b.getBrokerOffice().getName());
			
		}
		Collections.sort(retVal);
		return retVal;
	}

	private List<OfficeBrokerEstate> getLastEstates(Integer minutes){
		List<GetChangedDTO> changed = getChanged(minutes);
		List<GetProspectXMLElement> prospects = new ArrayList<GetProspectXMLElement>();
		for(GetChangedDTO change :  changed){
			String prospectXML = connector.getProspectXML(new Long(change.id));
			GetProspectXMLElement prospectXMLElement = dtoMapper.getProspectXMLElement(prospectXML);
			prospects.add(prospectXMLElement);
		}
		
		List<OfficeBrokerEstate> retVal = new ArrayList<OfficeBrokerEstate>();
		for(GetProspectXMLElement prospect: prospects){
			if(prospect.prospectMain.estateid != null){
				OfficeBrokerEstate element = new OfficeBrokerEstate();
				element.setEstateMidasId(new Long(prospect.prospectMain.estateid));
				element.setEstateStatus(prospect.prospectMain.status);
				element.setEstateStatusString(EstateStatusType.findById(prospect.prospectMain.status).getTitle());
				element.setEstateAddress(prospect.prospectMain.eiendomsnavn);
				element.setBrokerId(new Long(prospect.prospectMain.brokerid));
				element.setOfficeId(prospect.prospectMain.officeid);
				retVal.add(element);	
			}
		}
		return retVal;
	}

}
