/**
 * NewsRandomResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class NewsRandomResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.NewsRandomResponseNewsRandomResult newsRandomResult;

    public NewsRandomResponse() {
    }

    public NewsRandomResponse(
           com.dmma.dashboard.midas.axisclient.NewsRandomResponseNewsRandomResult newsRandomResult) {
           this.newsRandomResult = newsRandomResult;
    }


    /**
     * Gets the newsRandomResult value for this NewsRandomResponse.
     * 
     * @return newsRandomResult
     */
    public com.dmma.dashboard.midas.axisclient.NewsRandomResponseNewsRandomResult getNewsRandomResult() {
        return newsRandomResult;
    }


    /**
     * Sets the newsRandomResult value for this NewsRandomResponse.
     * 
     * @param newsRandomResult
     */
    public void setNewsRandomResult(com.dmma.dashboard.midas.axisclient.NewsRandomResponseNewsRandomResult newsRandomResult) {
        this.newsRandomResult = newsRandomResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NewsRandomResponse)) return false;
        NewsRandomResponse other = (NewsRandomResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.newsRandomResult==null && other.getNewsRandomResult()==null) || 
             (this.newsRandomResult!=null &&
              this.newsRandomResult.equals(other.getNewsRandomResult())));
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
        if (getNewsRandomResult() != null) {
            _hashCode += getNewsRandomResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NewsRandomResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">NewsRandomResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newsRandomResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "NewsRandomResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>NewsRandomResponse>NewsRandomResult"));
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
