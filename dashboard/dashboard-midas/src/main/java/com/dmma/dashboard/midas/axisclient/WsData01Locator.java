/**
 * WsData01Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class WsData01Locator extends org.apache.axis.client.Service implements com.dmma.dashboard.midas.axisclient.WsData01 {

    public WsData01Locator() {
    }


    public WsData01Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsData01Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wsData01Soap
    private java.lang.String wsData01Soap_address = "http://data.emprof.no/wsData01.asmx";

    public java.lang.String getwsData01SoapAddress() {
        return wsData01Soap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsData01SoapWSDDServiceName = "wsData01Soap";

    public java.lang.String getwsData01SoapWSDDServiceName() {
        return wsData01SoapWSDDServiceName;
    }

    public void setwsData01SoapWSDDServiceName(java.lang.String name) {
        wsData01SoapWSDDServiceName = name;
    }

    public com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType getwsData01Soap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsData01Soap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsData01Soap(endpoint);
    }

    public com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType getwsData01Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dmma.dashboard.midas.axisclient.WsData01Soap_BindingStub _stub = new com.dmma.dashboard.midas.axisclient.WsData01Soap_BindingStub(portAddress, this);
            _stub.setPortName(getwsData01SoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsData01SoapEndpointAddress(java.lang.String address) {
        wsData01Soap_address = address;
    }


    // Use to get a proxy class for wsData01Soap12
    private java.lang.String wsData01Soap12_address = "http://data.emprof.no/wsData01.asmx";

    public java.lang.String getwsData01Soap12Address() {
        return wsData01Soap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsData01Soap12WSDDServiceName = "wsData01Soap12";

    public java.lang.String getwsData01Soap12WSDDServiceName() {
        return wsData01Soap12WSDDServiceName;
    }

    public void setwsData01Soap12WSDDServiceName(java.lang.String name) {
        wsData01Soap12WSDDServiceName = name;
    }

    public com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType getwsData01Soap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsData01Soap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsData01Soap12(endpoint);
    }

    public com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType getwsData01Soap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dmma.dashboard.midas.axisclient.WsData01Soap12Stub _stub = new com.dmma.dashboard.midas.axisclient.WsData01Soap12Stub(portAddress, this);
            _stub.setPortName(getwsData01Soap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsData01Soap12EndpointAddress(java.lang.String address) {
        wsData01Soap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dmma.dashboard.midas.axisclient.WsData01Soap_BindingStub _stub = new com.dmma.dashboard.midas.axisclient.WsData01Soap_BindingStub(new java.net.URL(wsData01Soap_address), this);
                _stub.setPortName(getwsData01SoapWSDDServiceName());
                return _stub;
            }
            if (com.dmma.dashboard.midas.axisclient.WsData01Soap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dmma.dashboard.midas.axisclient.WsData01Soap12Stub _stub = new com.dmma.dashboard.midas.axisclient.WsData01Soap12Stub(new java.net.URL(wsData01Soap12_address), this);
                _stub.setPortName(getwsData01Soap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("wsData01Soap".equals(inputPortName)) {
            return getwsData01Soap();
        }
        else if ("wsData01Soap12".equals(inputPortName)) {
            return getwsData01Soap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://emprof.no/", "wsData01");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://emprof.no/", "wsData01Soap"));
            ports.add(new javax.xml.namespace.QName("http://emprof.no/", "wsData01Soap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wsData01Soap".equals(portName)) {
            setwsData01SoapEndpointAddress(address);
        }
        else 
if ("wsData01Soap12".equals(portName)) {
            setwsData01Soap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
