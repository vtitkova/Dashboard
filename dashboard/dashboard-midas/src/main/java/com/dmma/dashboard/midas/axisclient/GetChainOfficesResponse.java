/**
 * GetChainOfficesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetChainOfficesResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetChainOfficesResponseGetChainOfficesResult getChainOfficesResult;

    public GetChainOfficesResponse() {
    }

    public GetChainOfficesResponse(
           com.dmma.dashboard.midas.axisclient.GetChainOfficesResponseGetChainOfficesResult getChainOfficesResult) {
           this.getChainOfficesResult = getChainOfficesResult;
    }


    /**
     * Gets the getChainOfficesResult value for this GetChainOfficesResponse.
     * 
     * @return getChainOfficesResult
     */
    public com.dmma.dashboard.midas.axisclient.GetChainOfficesResponseGetChainOfficesResult getGetChainOfficesResult() {
        return getChainOfficesResult;
    }


    /**
     * Sets the getChainOfficesResult value for this GetChainOfficesResponse.
     * 
     * @param getChainOfficesResult
     */
    public void setGetChainOfficesResult(com.dmma.dashboard.midas.axisclient.GetChainOfficesResponseGetChainOfficesResult getChainOfficesResult) {
        this.getChainOfficesResult = getChainOfficesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetChainOfficesResponse)) return false;
        GetChainOfficesResponse other = (GetChainOfficesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getChainOfficesResult==null && other.getGetChainOfficesResult()==null) || 
             (this.getChainOfficesResult!=null &&
              this.getChainOfficesResult.equals(other.getGetChainOfficesResult())));
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
        if (getGetChainOfficesResult() != null) {
            _hashCode += getGetChainOfficesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetChainOfficesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetChainOfficesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getChainOfficesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "GetChainOfficesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>GetChainOfficesResponse>GetChainOfficesResult"));
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
