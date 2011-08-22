/**
 * UserCellphoneControl_1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class UserCellphoneControl_1Response  implements java.io.Serializable {
    private boolean userCellphoneControl_1Result;

    public UserCellphoneControl_1Response() {
    }

    public UserCellphoneControl_1Response(
           boolean userCellphoneControl_1Result) {
           this.userCellphoneControl_1Result = userCellphoneControl_1Result;
    }


    /**
     * Gets the userCellphoneControl_1Result value for this UserCellphoneControl_1Response.
     * 
     * @return userCellphoneControl_1Result
     */
    public boolean isUserCellphoneControl_1Result() {
        return userCellphoneControl_1Result;
    }


    /**
     * Sets the userCellphoneControl_1Result value for this UserCellphoneControl_1Response.
     * 
     * @param userCellphoneControl_1Result
     */
    public void setUserCellphoneControl_1Result(boolean userCellphoneControl_1Result) {
        this.userCellphoneControl_1Result = userCellphoneControl_1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserCellphoneControl_1Response)) return false;
        UserCellphoneControl_1Response other = (UserCellphoneControl_1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.userCellphoneControl_1Result == other.isUserCellphoneControl_1Result();
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
        _hashCode += (isUserCellphoneControl_1Result() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserCellphoneControl_1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">UserCellphoneControl_1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCellphoneControl_1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "UserCellphoneControl_1Result"));
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
