/**
 * AgentInteress_v2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class AgentInteress_v2Response  implements java.io.Serializable {
    private boolean agentInteress_v2Result;

    public AgentInteress_v2Response() {
    }

    public AgentInteress_v2Response(
           boolean agentInteress_v2Result) {
           this.agentInteress_v2Result = agentInteress_v2Result;
    }


    /**
     * Gets the agentInteress_v2Result value for this AgentInteress_v2Response.
     * 
     * @return agentInteress_v2Result
     */
    public boolean isAgentInteress_v2Result() {
        return agentInteress_v2Result;
    }


    /**
     * Sets the agentInteress_v2Result value for this AgentInteress_v2Response.
     * 
     * @param agentInteress_v2Result
     */
    public void setAgentInteress_v2Result(boolean agentInteress_v2Result) {
        this.agentInteress_v2Result = agentInteress_v2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgentInteress_v2Response)) return false;
        AgentInteress_v2Response other = (AgentInteress_v2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.agentInteress_v2Result == other.isAgentInteress_v2Result();
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
        _hashCode += (isAgentInteress_v2Result() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgentInteress_v2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">AgentInteress_v2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentInteress_v2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "AgentInteress_v2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
