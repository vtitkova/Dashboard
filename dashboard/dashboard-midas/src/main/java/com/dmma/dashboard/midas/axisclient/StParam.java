/**
 * StParam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class StParam  implements java.io.Serializable {
    private java.lang.String pName;

    private java.lang.String pValue;

    public StParam() {
    }

    public StParam(
           java.lang.String pName,
           java.lang.String pValue) {
           this.pName = pName;
           this.pValue = pValue;
    }


    /**
     * Gets the pName value for this StParam.
     * 
     * @return pName
     */
    public java.lang.String getPName() {
        return pName;
    }


    /**
     * Sets the pName value for this StParam.
     * 
     * @param pName
     */
    public void setPName(java.lang.String pName) {
        this.pName = pName;
    }


    /**
     * Gets the pValue value for this StParam.
     * 
     * @return pValue
     */
    public java.lang.String getPValue() {
        return pValue;
    }


    /**
     * Sets the pValue value for this StParam.
     * 
     * @param pValue
     */
    public void setPValue(java.lang.String pValue) {
        this.pValue = pValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StParam)) return false;
        StParam other = (StParam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pName==null && other.getPName()==null) || 
             (this.pName!=null &&
              this.pName.equals(other.getPName()))) &&
            ((this.pValue==null && other.getPValue()==null) || 
             (this.pValue!=null &&
              this.pValue.equals(other.getPValue())));
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
        if (getPName() != null) {
            _hashCode += getPName().hashCode();
        }
        if (getPValue() != null) {
            _hashCode += getPValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StParam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", "stParam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "pName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "pValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
