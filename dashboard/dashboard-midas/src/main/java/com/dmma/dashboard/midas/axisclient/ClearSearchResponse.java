/**
 * ClearSearchResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class ClearSearchResponse  implements java.io.Serializable {
    private boolean clearSearchResult;

    public ClearSearchResponse() {
    }

    public ClearSearchResponse(
           boolean clearSearchResult) {
           this.clearSearchResult = clearSearchResult;
    }


    /**
     * Gets the clearSearchResult value for this ClearSearchResponse.
     * 
     * @return clearSearchResult
     */
    public boolean isClearSearchResult() {
        return clearSearchResult;
    }


    /**
     * Sets the clearSearchResult value for this ClearSearchResponse.
     * 
     * @param clearSearchResult
     */
    public void setClearSearchResult(boolean clearSearchResult) {
        this.clearSearchResult = clearSearchResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClearSearchResponse)) return false;
        ClearSearchResponse other = (ClearSearchResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.clearSearchResult == other.isClearSearchResult();
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
        _hashCode += (isClearSearchResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClearSearchResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">ClearSearchResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clearSearchResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "ClearSearchResult"));
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
