/**
 * GetBroker.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class GetBroker  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String officeID;

    private java.lang.String brokerID;

    public GetBroker() {
    }

    public GetBroker(
           java.lang.String sIdentityKey,
           java.lang.String officeID,
           java.lang.String brokerID) {
           this.sIdentityKey = sIdentityKey;
           this.officeID = officeID;
           this.brokerID = brokerID;
    }


    /**
     * Gets the sIdentityKey value for this GetBroker.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this GetBroker.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the officeID value for this GetBroker.
     * 
     * @return officeID
     */
    public java.lang.String getOfficeID() {
        return officeID;
    }


    /**
     * Sets the officeID value for this GetBroker.
     * 
     * @param officeID
     */
    public void setOfficeID(java.lang.String officeID) {
        this.officeID = officeID;
    }


    /**
     * Gets the brokerID value for this GetBroker.
     * 
     * @return brokerID
     */
    public java.lang.String getBrokerID() {
        return brokerID;
    }


    /**
     * Sets the brokerID value for this GetBroker.
     * 
     * @param brokerID
     */
    public void setBrokerID(java.lang.String brokerID) {
        this.brokerID = brokerID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBroker)) return false;
        GetBroker other = (GetBroker) obj;
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
            ((this.officeID==null && other.getOfficeID()==null) || 
             (this.officeID!=null &&
              this.officeID.equals(other.getOfficeID()))) &&
            ((this.brokerID==null && other.getBrokerID()==null) || 
             (this.brokerID!=null &&
              this.brokerID.equals(other.getBrokerID())));
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
        if (getOfficeID() != null) {
            _hashCode += getOfficeID().hashCode();
        }
        if (getBrokerID() != null) {
            _hashCode += getBrokerID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetBroker.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">GetBroker"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIdentityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sIdentityKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("officeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "OfficeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brokerID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "BrokerID"));
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
