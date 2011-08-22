/**
 * GetSiteSettingsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetSiteSettingsResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetSiteSettingsResponseGetSiteSettingsResult getSiteSettingsResult;

    public GetSiteSettingsResponse() {
    }

    public GetSiteSettingsResponse(
           com.dmma.dashboard.midas.axisclient.GetSiteSettingsResponseGetSiteSettingsResult getSiteSettingsResult) {
           this.getSiteSettingsResult = getSiteSettingsResult;
    }


    /**
     * Gets the getSiteSettingsResult value for this GetSiteSettingsResponse.
     * 
     * @return getSiteSettingsResult
     */
    public com.dmma.dashboard.midas.axisclient.GetSiteSettingsResponseGetSiteSettingsResult getGetSiteSettingsResult() {
        return getSiteSettingsResult;
    }


    /**
     * Sets the getSiteSettingsResult value for this GetSiteSettingsResponse.
     * 
     * @param getSiteSettingsResult
     */
    public void setGetSiteSettingsResult(com.dmma.dashboard.midas.axisclient.GetSiteSettingsResponseGetSiteSettingsResult getSiteSettingsResult) {
        this.getSiteSettingsResult = getSiteSettingsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSiteSettingsResponse)) return false;
        GetSiteSettingsResponse other = (GetSiteSettingsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSiteSettingsResult==null && other.getGetSiteSettingsResult()==null) || 
             (this.getSiteSettingsResult!=null &&
              this.getSiteSettingsResult.equals(other.getGetSiteSettingsResult())));
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
        if (getGetSiteSettingsResult() != null) {
            _hashCode += getGetSiteSettingsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSiteSettingsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetSiteSettingsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSiteSettingsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "GetSiteSettingsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>GetSiteSettingsResponse>GetSiteSettingsResult"));
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
