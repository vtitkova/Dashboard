/**
 * AgentGetQueryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class AgentGetQueryResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.AgentGetQueryResponseAgentGetQueryResult agentGetQueryResult;

    public AgentGetQueryResponse() {
    }

    public AgentGetQueryResponse(
           com.dmma.dashboard.midas.axisclient.AgentGetQueryResponseAgentGetQueryResult agentGetQueryResult) {
           this.agentGetQueryResult = agentGetQueryResult;
    }


    /**
     * Gets the agentGetQueryResult value for this AgentGetQueryResponse.
     * 
     * @return agentGetQueryResult
     */
    public com.dmma.dashboard.midas.axisclient.AgentGetQueryResponseAgentGetQueryResult getAgentGetQueryResult() {
        return agentGetQueryResult;
    }


    /**
     * Sets the agentGetQueryResult value for this AgentGetQueryResponse.
     * 
     * @param agentGetQueryResult
     */
    public void setAgentGetQueryResult(com.dmma.dashboard.midas.axisclient.AgentGetQueryResponseAgentGetQueryResult agentGetQueryResult) {
        this.agentGetQueryResult = agentGetQueryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgentGetQueryResponse)) return false;
        AgentGetQueryResponse other = (AgentGetQueryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agentGetQueryResult==null && other.getAgentGetQueryResult()==null) || 
             (this.agentGetQueryResult!=null &&
              this.agentGetQueryResult.equals(other.getAgentGetQueryResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAgentGetQueryResult() != null) {
            _hashCode += getAgentGetQueryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgentGetQueryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">AgentGetQueryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentGetQueryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "AgentGetQueryResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>AgentGetQueryResponse>AgentGetQueryResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
