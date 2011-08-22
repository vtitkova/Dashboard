/**
 * GetControlsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetControlsResponse  implements java.io.Serializable {
    private com.dmma.dashboard.midas.axisclient.GetControlsResponseGetControlsResult getControlsResult;

    public GetControlsResponse() {
    }

    public GetControlsResponse(
           com.dmma.dashboard.midas.axisclient.GetControlsResponseGetControlsResult getControlsResult) {
           this.getControlsResult = getControlsResult;
    }


    /**
     * Gets the getControlsResult value for this GetControlsResponse.
     * 
     * @return getControlsResult
     */
    public com.dmma.dashboard.midas.axisclient.GetControlsResponseGetControlsResult getGetControlsResult() {
        return getControlsResult;
    }


    /**
     * Sets the getControlsResult value for this GetControlsResponse.
     * 
     * @param getControlsResult
     */
    public void setGetControlsResult(com.dmma.dashboard.midas.axisclient.GetControlsResponseGetControlsResult getControlsResult) {
        this.getControlsResult = getControlsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetControlsResponse)) return false;
        GetControlsResponse other = (GetControlsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getControlsResult==null && other.getGetControlsResult()==null) || 
             (this.getControlsResult!=null &&
              this.getControlsResult.equals(other.getGetControlsResult())));
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
        if (getGetControlsResult() != null) {
            _hashCode += getGetControlsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetControlsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetControlsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getControlsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "GetControlsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>GetControlsResponse>GetControlsResult"));
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
