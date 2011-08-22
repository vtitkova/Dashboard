/**
 * SaveSearchTestResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class SaveSearchTestResponse  implements java.io.Serializable {
    private boolean saveSearchTestResult;

    public SaveSearchTestResponse() {
    }

    public SaveSearchTestResponse(
           boolean saveSearchTestResult) {
           this.saveSearchTestResult = saveSearchTestResult;
    }


    /**
     * Gets the saveSearchTestResult value for this SaveSearchTestResponse.
     * 
     * @return saveSearchTestResult
     */
    public boolean isSaveSearchTestResult() {
        return saveSearchTestResult;
    }


    /**
     * Sets the saveSearchTestResult value for this SaveSearchTestResponse.
     * 
     * @param saveSearchTestResult
     */
    public void setSaveSearchTestResult(boolean saveSearchTestResult) {
        this.saveSearchTestResult = saveSearchTestResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveSearchTestResponse)) return false;
        SaveSearchTestResponse other = (SaveSearchTestResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.saveSearchTestResult == other.isSaveSearchTestResult();
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
        _hashCode += (isSaveSearchTestResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveSearchTestResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">SaveSearchTestResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saveSearchTestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "SaveSearchTestResult"));
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
