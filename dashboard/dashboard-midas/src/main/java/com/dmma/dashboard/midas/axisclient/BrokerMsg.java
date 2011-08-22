/**
 * BrokerMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class BrokerMsg  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sAccessKey;

    private com.dmma.dashboard.midas.axisclient.BrokerMsgDsInfo dsInfo;

    public BrokerMsg() {
    }

    public BrokerMsg(
           java.lang.String sIdentityKey,
           java.lang.String sAccessKey,
           com.dmma.dashboard.midas.axisclient.BrokerMsgDsInfo dsInfo) {
           this.sIdentityKey = sIdentityKey;
           this.sAccessKey = sAccessKey;
           this.dsInfo = dsInfo;
    }


    /**
     * Gets the sIdentityKey value for this BrokerMsg.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this BrokerMsg.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sAccessKey value for this BrokerMsg.
     * 
     * @return sAccessKey
     */
    public java.lang.String getSAccessKey() {
        return sAccessKey;
    }


    /**
     * Sets the sAccessKey value for this BrokerMsg.
     * 
     * @param sAccessKey
     */
    public void setSAccessKey(java.lang.String sAccessKey) {
        this.sAccessKey = sAccessKey;
    }


    /**
     * Gets the dsInfo value for this BrokerMsg.
     * 
     * @return dsInfo
     */
    public com.dmma.dashboard.midas.axisclient.BrokerMsgDsInfo getDsInfo() {
        return dsInfo;
    }


    /**
     * Sets the dsInfo value for this BrokerMsg.
     * 
     * @param dsInfo
     */
    public void setDsInfo(com.dmma.dashboard.midas.axisclient.BrokerMsgDsInfo dsInfo) {
        this.dsInfo = dsInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BrokerMsg)) return false;
        BrokerMsg other = (BrokerMsg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sIdentityKey==null && other.getSIdentityKey()==null) || 
             (this.sIdentityKey!=null &&
              this.sIdentityKey.equals(other.getSIdentityKey()))) &&
            ((this.sAccessKey==null && other.getSAccessKey()==null) || 
             (this.sAccessKey!=null &&
              this.sAccessKey.equals(other.getSAccessKey()))) &&
            ((this.dsInfo==null && other.getDsInfo()==null) || 
             (this.dsInfo!=null &&
              this.dsInfo.equals(other.getDsInfo())));
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
        if (getSIdentityKey() != null) {
            _hashCode += getSIdentityKey().hashCode();
        }
        if (getSAccessKey() != null) {
            _hashCode += getSAccessKey().hashCode();
        }
        if (getDsInfo() != null) {
            _hashCode += getDsInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BrokerMsg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">BrokerMsg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIdentityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sIdentityKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAccessKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sAccessKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "dsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">>BrokerMsg>dsInfo"));
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
