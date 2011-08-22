/**
 * GetBrokerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetBrokerResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetBrokerResponseGetBrokerResult getBrokerResult;

    public GetBrokerResponse() {
    }

    public GetBrokerResponse(
           com.dmma.dashboard.midas.axisclient.GetBrokerResponseGetBrokerResult getBrokerResult) {
           this.getBrokerResult = getBrokerResult;
    }


    /**
     * Gets the getBrokerResult value for this GetBrokerResponse.
     * 
     * @return getBrokerResult
     */
    public com.dmma.dashboard.midas.axisclient.GetBrokerResponseGetBrokerResult getGetBrokerResult() {
        return getBrokerResult;
    }


    /**
     * Sets the getBrokerResult value for this GetBrokerResponse.
     * 
     * @param getBrokerResult
     */
    public void setGetBrokerResult(com.dmma.dashboard.midas.axisclient.GetBrokerResponseGetBrokerResult getBrokerResult) {
        this.getBrokerResult = getBrokerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBrokerResponse)) return false;
        GetBrokerResponse other = (GetBrokerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getBrokerResult==null && other.getGetBrokerResult()==null) || 
             (this.getBrokerResult!=null &&
              this.getBrokerResult.equals(other.getGetBrokerResult())));
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
        if (getGetBrokerResult() != null) {
            _hashCode += getGetBrokerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetBrokerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetBrokerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getBrokerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "GetBrokerResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>GetBrokerResponse>GetBrokerResult"));
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
