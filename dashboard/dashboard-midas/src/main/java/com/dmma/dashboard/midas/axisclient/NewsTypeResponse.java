/**
 * NewsTypeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class NewsTypeResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.NewsTypeResponseNewsTypeResult newsTypeResult;

    public NewsTypeResponse() {
    }

    public NewsTypeResponse(
           com.dmma.dashboard.midas.axisclient.NewsTypeResponseNewsTypeResult newsTypeResult) {
           this.newsTypeResult = newsTypeResult;
    }


    /**
     * Gets the newsTypeResult value for this NewsTypeResponse.
     * 
     * @return newsTypeResult
     */
    public com.dmma.dashboard.midas.axisclient.NewsTypeResponseNewsTypeResult getNewsTypeResult() {
        return newsTypeResult;
    }


    /**
     * Sets the newsTypeResult value for this NewsTypeResponse.
     * 
     * @param newsTypeResult
     */
    public void setNewsTypeResult(com.dmma.dashboard.midas.axisclient.NewsTypeResponseNewsTypeResult newsTypeResult) {
        this.newsTypeResult = newsTypeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NewsTypeResponse)) return false;
        NewsTypeResponse other = (NewsTypeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.newsTypeResult==null && other.getNewsTypeResult()==null) || 
             (this.newsTypeResult!=null &&
              this.newsTypeResult.equals(other.getNewsTypeResult())));
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
        if (getNewsTypeResult() != null) {
            _hashCode += getNewsTypeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NewsTypeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">NewsTypeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newsTypeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "NewsTypeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>NewsTypeResponse>NewsTypeResult"));
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
