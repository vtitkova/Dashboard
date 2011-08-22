/**
 * NewsTypeDaysResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class NewsTypeDaysResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.NewsTypeDaysResponseNewsTypeDaysResult newsTypeDaysResult;

    public NewsTypeDaysResponse() {
    }

    public NewsTypeDaysResponse(
           com.dmma.dashboard.midas.axisclient.NewsTypeDaysResponseNewsTypeDaysResult newsTypeDaysResult) {
           this.newsTypeDaysResult = newsTypeDaysResult;
    }


    /**
     * Gets the newsTypeDaysResult value for this NewsTypeDaysResponse.
     * 
     * @return newsTypeDaysResult
     */
    public com.dmma.dashboard.midas.axisclient.NewsTypeDaysResponseNewsTypeDaysResult getNewsTypeDaysResult() {
        return newsTypeDaysResult;
    }


    /**
     * Sets the newsTypeDaysResult value for this NewsTypeDaysResponse.
     * 
     * @param newsTypeDaysResult
     */
    public void setNewsTypeDaysResult(com.dmma.dashboard.midas.axisclient.NewsTypeDaysResponseNewsTypeDaysResult newsTypeDaysResult) {
        this.newsTypeDaysResult = newsTypeDaysResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NewsTypeDaysResponse)) return false;
        NewsTypeDaysResponse other = (NewsTypeDaysResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.newsTypeDaysResult==null && other.getNewsTypeDaysResult()==null) || 
             (this.newsTypeDaysResult!=null &&
              this.newsTypeDaysResult.equals(other.getNewsTypeDaysResult())));
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
        if (getNewsTypeDaysResult() != null) {
            _hashCode += getNewsTypeDaysResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NewsTypeDaysResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">NewsTypeDaysResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newsTypeDaysResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "NewsTypeDaysResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>NewsTypeDaysResponse>NewsTypeDaysResult"));
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
