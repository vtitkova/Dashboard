/**
 * UserCellphoneControl_2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class UserCellphoneControl_2Response  implements java.io.Serializable {
    private boolean userCellphoneControl_2Result;

    public UserCellphoneControl_2Response() {
    }

    public UserCellphoneControl_2Response(
           boolean userCellphoneControl_2Result) {
           this.userCellphoneControl_2Result = userCellphoneControl_2Result;
    }


    /**
     * Gets the userCellphoneControl_2Result value for this UserCellphoneControl_2Response.
     * 
     * @return userCellphoneControl_2Result
     */
    public boolean isUserCellphoneControl_2Result() {
        return userCellphoneControl_2Result;
    }


    /**
     * Sets the userCellphoneControl_2Result value for this UserCellphoneControl_2Response.
     * 
     * @param userCellphoneControl_2Result
     */
    public void setUserCellphoneControl_2Result(boolean userCellphoneControl_2Result) {
        this.userCellphoneControl_2Result = userCellphoneControl_2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserCellphoneControl_2Response)) return false;
        UserCellphoneControl_2Response other = (UserCellphoneControl_2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.userCellphoneControl_2Result == other.isUserCellphoneControl_2Result();
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
        _hashCode += (isUserCellphoneControl_2Result() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserCellphoneControl_2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">UserCellphoneControl_2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCellphoneControl_2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "UserCellphoneControl_2Result"));
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
