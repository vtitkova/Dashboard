/**
 * SearchTestResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class SearchTestResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.SearchTestResponseSearchTestResult searchTestResult;

    public SearchTestResponse() {
    }

    public SearchTestResponse(
           com.dmma.dashboard.midas.axisclient.SearchTestResponseSearchTestResult searchTestResult) {
           this.searchTestResult = searchTestResult;
    }


    /**
     * Gets the searchTestResult value for this SearchTestResponse.
     * 
     * @return searchTestResult
     */
    public com.dmma.dashboard.midas.axisclient.SearchTestResponseSearchTestResult getSearchTestResult() {
        return searchTestResult;
    }


    /**
     * Sets the searchTestResult value for this SearchTestResponse.
     * 
     * @param searchTestResult
     */
    public void setSearchTestResult(com.dmma.dashboard.midas.axisclient.SearchTestResponseSearchTestResult searchTestResult) {
        this.searchTestResult = searchTestResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchTestResponse)) return false;
        SearchTestResponse other = (SearchTestResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchTestResult==null && other.getSearchTestResult()==null) || 
             (this.searchTestResult!=null &&
              this.searchTestResult.equals(other.getSearchTestResult())));
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
        if (getSearchTestResult() != null) {
            _hashCode += getSearchTestResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchTestResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">SearchTestResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchTestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "SearchTestResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>SearchTestResponse>SearchTestResult"));
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
