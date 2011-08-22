/**
 * GetActiveBidResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetActiveBidResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetActiveBidResponseGetActiveBidResult getActiveBidResult;

    public GetActiveBidResponse() {
    }

    public GetActiveBidResponse(
           com.dmma.dashboard.midas.axisclient.GetActiveBidResponseGetActiveBidResult getActiveBidResult) {
           this.getActiveBidResult = getActiveBidResult;
    }


    /**
     * Gets the getActiveBidResult value for this GetActiveBidResponse.
     * 
     * @return getActiveBidResult
     */
    public com.dmma.dashboard.midas.axisclient.GetActiveBidResponseGetActiveBidResult getGetActiveBidResult() {
        return getActiveBidResult;
    }


    /**
     * Sets the getActiveBidResult value for this GetActiveBidResponse.
     * 
     * @param getActiveBidResult
     */
    public void setGetActiveBidResult(com.dmma.dashboard.midas.axisclient.GetActiveBidResponseGetActiveBidResult getActiveBidResult) {
        this.getActiveBidResult = getActiveBidResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetActiveBidResponse)) return false;
        GetActiveBidResponse other = (GetActiveBidResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getActiveBidResult==null && other.getGetActiveBidResult()==null) || 
             (this.getActiveBidResult!=null &&
              this.getActiveBidResult.equals(other.getGetActiveBidResult())));
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
        if (getGetActiveBidResult() != null) {
            _hashCode += getGetActiveBidResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetActiveBidResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetActiveBidResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getActiveBidResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "GetActiveBidResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>GetActiveBidResponse>GetActiveBidResult"));
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
