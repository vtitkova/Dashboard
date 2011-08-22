/**
 * GetPicturesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetPicturesResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetPicturesResponseGetPicturesResult getPicturesResult;

    public GetPicturesResponse() {
    }

    public GetPicturesResponse(
           com.dmma.dashboard.midas.axisclient.GetPicturesResponseGetPicturesResult getPicturesResult) {
           this.getPicturesResult = getPicturesResult;
    }


    /**
     * Gets the getPicturesResult value for this GetPicturesResponse.
     * 
     * @return getPicturesResult
     */
    public com.dmma.dashboard.midas.axisclient.GetPicturesResponseGetPicturesResult getGetPicturesResult() {
        return getPicturesResult;
    }


    /**
     * Sets the getPicturesResult value for this GetPicturesResponse.
     * 
     * @param getPicturesResult
     */
    public void setGetPicturesResult(com.dmma.dashboard.midas.axisclient.GetPicturesResponseGetPicturesResult getPicturesResult) {
        this.getPicturesResult = getPicturesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPicturesResponse)) return false;
        GetPicturesResponse other = (GetPicturesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getPicturesResult==null && other.getGetPicturesResult()==null) || 
             (this.getPicturesResult!=null &&
              this.getPicturesResult.equals(other.getGetPicturesResult())));
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
        if (getGetPicturesResult() != null) {
            _hashCode += getGetPicturesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPicturesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">getPicturesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getPicturesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "getPicturesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>getPicturesResponse>getPicturesResult"));
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
