package com.dmma.dashboard.midas;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;
import org.apache.axis.encoding.AnyContentType;

import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.midas.axisclient.GetBrokerPResponseGetBrokerPResult;
import com.dmma.dashboard.midas.axisclient.GetChainOfficesResponseGetChainOfficesResult;
import com.dmma.dashboard.midas.axisclient.GetChangedResponseGetChangedResult;
import com.dmma.dashboard.midas.axisclient.GetOfficeResponseGetOfficeResult;
import com.dmma.dashboard.midas.axisclient.GetProspectDataDSResponseGetProspectDataDSResult;
import com.dmma.dashboard.midas.axisclient.WsData01Locator;
import com.dmma.dashboard.midas.axisclient.WsData01Soap12Stub;
import com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType;

public class MidasConnector {

	private String identityKey;
	private URL    serviceUrl;

	public MidasConnector() {
		try {
			serviceUrl = new URL(AppProperties.midasWsUrl);
			identityKey = AppProperties.midasWsKey;
		} catch (MalformedURLException e) {
			//TODO
			e.printStackTrace();
		}
	}




	public String getBrokerPXML(String brokerId) {
		try {
			GetBrokerPResponseGetBrokerPResult result = getPort().getBrokerP(identityKey, null, brokerId, null);
			return result.get_any()[1].getAsString();
		} catch (Exception e) {
			if (e instanceof RemoteException || e instanceof ConnectException) {
			}
			throw new RuntimeException(e);
		}
	}

	public String getOfficeXML(int officeId) {
		try {
			GetOfficeResponseGetOfficeResult result = getPort().getOffice(identityKey, officeId);
			return result.get_any()[1].getAsString();
		} catch (Exception e) {
			if (e instanceof RemoteException || e instanceof ConnectException) {
			}
			throw new RuntimeException(e);
		}
	}


	public String getBrokerPByOfficeXML(String officeId) {
		try {
			GetBrokerPResponseGetBrokerPResult result = getPort().getBrokerP(identityKey, officeId, null, null);
			return result.get_any()[1].getAsString();
		} catch (Exception e) {
			if (e instanceof RemoteException || e instanceof ConnectException) {
				//logger.severe("Could not connect to web service when fetching Broker by Office. Exception = " + e);
			}
			throw new RuntimeException(e);
		}
	}


	public String getChainOfficesXML() {
		try {
			GetChainOfficesResponseGetChainOfficesResult result = getPort().getChainOffices(identityKey, "");
			return result.get_any()[1].getAsString();
		} catch (Exception e) {
			if (e instanceof RemoteException || e instanceof ConnectException) {
				//logger.severe("Could not connect to web service when fetching Chain Offices. Exception = " + e);
			}

			throw new RuntimeException(e);
		}
	}

	public String getProspectXML(Long id) {
		try {
			GetProspectDataDSResponseGetProspectDataDSResult result = getPort().getProspectDataDS(identityKey, "", id);
			return result.get_any()[1].getAsString();
		} catch (Exception e) {
			if (e instanceof RemoteException || e instanceof ConnectException) {
				//logger.severe("Could not connect to web service when fetching Prospect data. Exception = " + e);
			}
			throw new RuntimeException(e);
		}
	}

	private WsData01Soap_PortType getPort() {
		try {
			return new WsData01Soap12Stub(serviceUrl, new WsData01Locator());
		} catch (AxisFault e) {
			throw new RuntimeException(e);
		}
	}




	public String getChangedEstates(int minutes) {
		try {
			GetChangedResponseGetChangedResult result = getPort().getChanged(identityKey, minutes);
			return resultAsString(result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String resultAsString(AnyContentType result) {
		try {
			return result.get_any()[1].getAsString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
