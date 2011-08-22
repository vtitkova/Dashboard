/**
 * GetProspectDataXMLResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetProspectDataXMLResponse  implements java.io.Serializable {
    private java.lang.String getProspectDataXMLResult;

    public GetProspectDataXMLResponse() {
    }

    public GetProspectDataXMLResponse(
           java.lang.String getProspectDataXMLResult) {
           this.getProspectDataXMLResult = getProspectDataXMLResult;
    }


    /**
     * Gets the getProspectDataXMLResult value for this GetProspectDataXMLResponse.
     * 
     * @return getProspectDataXMLResult
     */
    public java.lang.String getGetProspectDataXMLResult() {
        return getProspectDataXMLResult;
    }


    /**
     * Sets the getProspectDataXMLResult value for this GetProspectDataXMLResponse.
     * 
     * @param getProspectDataXMLResult
     */
    public void setGetProspectDataXMLResult(java.lang.String getProspectDataXMLResult) {
        this.getProspectDataXMLResult = getProspectDataXMLResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetProspectDataXMLResponse)) return false;
        GetProspectDataXMLResponse other = (GetProspectDataXMLResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getProspectDataXMLResult==null && other.getGetProspectDataXMLResult()==null) || 
             (this.getProspectDataXMLResult!=null &&
              this.getProspectDataXMLResult.equals(other.getGetProspectDataXMLResult())));
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
        if (getGetProspectDataXMLResult() != null) {
            _hashCode += getGetProspectDataXMLResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetProspectDataXMLResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">getProspectDataXMLResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getProspectDataXMLResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "getProspectDataXMLResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
