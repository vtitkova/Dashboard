/**
 * UserGetDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class UserGetDataResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.UserGetDataResponseUserGetDataResult userGetDataResult;

    public UserGetDataResponse() {
    }

    public UserGetDataResponse(
           com.dmma.dashboard.midas.axisclient.UserGetDataResponseUserGetDataResult userGetDataResult) {
           this.userGetDataResult = userGetDataResult;
    }


    /**
     * Gets the userGetDataResult value for this UserGetDataResponse.
     * 
     * @return userGetDataResult
     */
    public com.dmma.dashboard.midas.axisclient.UserGetDataResponseUserGetDataResult getUserGetDataResult() {
        return userGetDataResult;
    }


    /**
     * Sets the userGetDataResult value for this UserGetDataResponse.
     * 
     * @param userGetDataResult
     */
    public void setUserGetDataResult(com.dmma.dashboard.midas.axisclient.UserGetDataResponseUserGetDataResult userGetDataResult) {
        this.userGetDataResult = userGetDataResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserGetDataResponse)) return false;
        UserGetDataResponse other = (UserGetDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userGetDataResult==null && other.getUserGetDataResult()==null) || 
             (this.userGetDataResult!=null &&
              this.userGetDataResult.equals(other.getUserGetDataResult())));
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
        if (getUserGetDataResult() != null) {
            _hashCode += getUserGetDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserGetDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">UserGetDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGetDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "UserGetDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>UserGetDataResponse>UserGetDataResult"));
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
