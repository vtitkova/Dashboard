package com.dmma.dashboard.midas;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.midas.dto.GetBrokerDTO;
import com.dmma.dashboard.midas.dto.GetChangedDTO;
import com.dmma.dashboard.midas.dto.GetOfficeDTO;
import com.dmma.dashboard.midas.dto.GetProspectXMLElement;
import com.dmma.dashboard.midas.dto.RootXMLElement;

public class MidasDTOMapper {

	private String castorMappingPath;

	//@Inject
	//Logger logger;

	public MidasDTOMapper() {
		castorMappingPath = AppProperties.midasCastormappingPath;
	}

	public GetBrokerDTO getBrokerDTO(String brokerXML) {
		try {
			RootXMLElement root = unmarshallXML("GetBrokerMapping.xml", brokerXML);
			if (root.getBrokerResult == null) {
				return null;
			}
			return root.getBrokerResult.result;
		} catch (Exception e) {
			//TODO
			e.printStackTrace();
			//logger.warning(e.getMessage());
		}
		return null;
	}

	public GetOfficeDTO getOfficeDTO(String officeXML) {
		try {
			RootXMLElement root = unmarshallXML("GetOfficeMapping.xml", officeXML);
			if (root.getOfficeResult == null) {
				return null;
			}
			return root.getOfficeResult.result;
		} catch (Exception e) {
			//TODO
			e.printStackTrace();
			//logger.warning(e.getMessage());
		}
		return null;
	}
	
	public List<GetBrokerDTO> getBrokerDTOs(String brokersXML) {
		try {
			RootXMLElement root = unmarshallXML("GetBrokersMapping.xml", brokersXML);
			if (root.getBrokersResult == null) {
				return new ArrayList<GetBrokerDTO>();
			}
			return root.getBrokersResult.result;
		} catch (Exception e) {
			//TODO
			e.printStackTrace();
			//logger.warning(e.getMessage());
		}

		return new ArrayList<GetBrokerDTO>();
	}

	

	
	private RootXMLElement unmarshallXML(String mappingFileName, String xml) {
		try {
			Unmarshaller unmarshaller = getUnmarshaller(mappingFileName);
			StringReader reader = new StringReader(xml);
			return (RootXMLElement) unmarshaller.unmarshal(reader);
		} catch (MarshalException e) {
			throw new RuntimeException(e);
		} catch (ValidationException e) {
			throw new RuntimeException(e);
		}
	}

	private Unmarshaller getUnmarshaller(String mappingFileName) {
		try {
			Unmarshaller unmarshaller = new Unmarshaller(getMapping(mappingFileName));
			unmarshaller.setIgnoreExtraElements(true);
			return unmarshaller;
		} catch (MappingException e) {
			throw new RuntimeException(e);
		}
	}

	private Mapping getMapping(String mappingFileName) {
		InputSource inputSource = new InputSource(this.getClass().getClassLoader().getResourceAsStream(
				castorMappingPath + mappingFileName));
		Mapping mapping = new Mapping();
		mapping.loadMapping(inputSource);
		return mapping;
	}
	
	public GetProspectXMLElement getProspectXMLElement(String prospectXML) {
        try {
            RootXMLElement root = unmarshallXML("GetProspectMapping.xml", prospectXML);
            return root.getProspectResult;
        } catch (Exception e) {
        	e.printStackTrace();
            //logger.warning(e.getMessage());
        }
        return null;
    }

	 public List<GetChangedDTO> getChangedDTOs(String getChangedXML) {
        try {
            RootXMLElement root = unmarshallXML("GetChangedMapping.xml", getChangedXML);
            return root.getChangedResult.result;
        } catch (Exception e) {
        }
        return new ArrayList<GetChangedDTO>();
    }

}
