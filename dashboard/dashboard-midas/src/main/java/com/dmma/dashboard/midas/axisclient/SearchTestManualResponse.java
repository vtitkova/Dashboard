/**
 * SearchTestManualResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class SearchTestManualResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.SearchTestManualResponseSearchTestManualResult searchTestManualResult;

    public SearchTestManualResponse() {
    }

    public SearchTestManualResponse(
           com.dmma.dashboard.midas.axisclient.SearchTestManualResponseSearchTestManualResult searchTestManualResult) {
           this.searchTestManualResult = searchTestManualResult;
    }


    /**
     * Gets the searchTestManualResult value for this SearchTestManualResponse.
     * 
     * @return searchTestManualResult
     */
    public com.dmma.dashboard.midas.axisclient.SearchTestManualResponseSearchTestManualResult getSearchTestManualResult() {
        return searchTestManualResult;
    }


    /**
     * Sets the searchTestManualResult value for this SearchTestManualResponse.
     * 
     * @param searchTestManualResult
     */
    public void setSearchTestManualResult(com.dmma.dashboard.midas.axisclient.SearchTestManualResponseSearchTestManualResult searchTestManualResult) {
        this.searchTestManualResult = searchTestManualResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchTestManualResponse)) return false;
        SearchTestManualResponse other = (SearchTestManualResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchTestManualResult==null && other.getSearchTestManualResult()==null) || 
             (this.searchTestManualResult!=null &&
              this.searchTestManualResult.equals(other.getSearchTestManualResult())));
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
        if (getSearchTestManualResult() != null) {
            _hashCode += getSearchTestManualResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchTestManualResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">SearchTestManualResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchTestManualResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "SearchTestManualResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>SearchTestManualResponse>SearchTestManualResult"));
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
