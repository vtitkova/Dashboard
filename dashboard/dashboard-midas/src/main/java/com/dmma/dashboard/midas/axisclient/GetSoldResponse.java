/**
 * GetSoldResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetSoldResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetSoldResponseGetSoldResult getSoldResult;

    public GetSoldResponse() {
    }

    public GetSoldResponse(
           com.dmma.dashboard.midas.axisclient.GetSoldResponseGetSoldResult getSoldResult) {
           this.getSoldResult = getSoldResult;
    }


    /**
     * Gets the getSoldResult value for this GetSoldResponse.
     * 
     * @return getSoldResult
     */
    public com.dmma.dashboard.midas.axisclient.GetSoldResponseGetSoldResult getGetSoldResult() {
        return getSoldResult;
    }


    /**
     * Sets the getSoldResult value for this GetSoldResponse.
     * 
     * @param getSoldResult
     */
    public void setGetSoldResult(com.dmma.dashboard.midas.axisclient.GetSoldResponseGetSoldResult getSoldResult) {
        this.getSoldResult = getSoldResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSoldResponse)) return false;
        GetSoldResponse other = (GetSoldResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSoldResult==null && other.getGetSoldResult()==null) || 
             (this.getSoldResult!=null &&
              this.getSoldResult.equals(other.getGetSoldResult())));
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
        if (getGetSoldResult() != null) {
            _hashCode += getGetSoldResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSoldResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetSoldResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSoldResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "GetSoldResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>GetSoldResponse>GetSoldResult"));
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
