/**
 * AgentInteress.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class AgentInteress  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sAccessKey;

    private java.lang.String sUserKey;

    private int nProspectID;

    private int nLevel;

    public AgentInteress() {
    }

    public AgentInteress(
           java.lang.String sIdentityKey,
           java.lang.String sAccessKey,
           java.lang.String sUserKey,
           int nProspectID,
           int nLevel) {
           this.sIdentityKey = sIdentityKey;
           this.sAccessKey = sAccessKey;
           this.sUserKey = sUserKey;
           this.nProspectID = nProspectID;
           this.nLevel = nLevel;
    }


    /**
     * Gets the sIdentityKey value for this AgentInteress.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this AgentInteress.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sAccessKey value for this AgentInteress.
     * 
     * @return sAccessKey
     */
    public java.lang.String getSAccessKey() {
        return sAccessKey;
    }


    /**
     * Sets the sAccessKey value for this AgentInteress.
     * 
     * @param sAccessKey
     */
    public void setSAccessKey(java.lang.String sAccessKey) {
        this.sAccessKey = sAccessKey;
    }


    /**
     * Gets the sUserKey value for this AgentInteress.
     * 
     * @return sUserKey
     */
    public java.lang.String getSUserKey() {
        return sUserKey;
    }


    /**
     * Sets the sUserKey value for this AgentInteress.
     * 
     * @param sUserKey
     */
    public void setSUserKey(java.lang.String sUserKey) {
        this.sUserKey = sUserKey;
    }


    /**
     * Gets the nProspectID value for this AgentInteress.
     * 
     * @return nProspectID
     */
    public int getNProspectID() {
        return nProspectID;
    }


    /**
     * Sets the nProspectID value for this AgentInteress.
     * 
     * @param nProspectID
     */
    public void setNProspectID(int nProspectID) {
        this.nProspectID = nProspectID;
    }


    /**
     * Gets the nLevel value for this AgentInteress.
     * 
     * @return nLevel
     */
    public int getNLevel() {
        return nLevel;
    }


    /**
     * Sets the nLevel value for this AgentInteress.
     * 
     * @param nLevel
     */
    public void setNLevel(int nLevel) {
        this.nLevel = nLevel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgentInteress)) return false;
        AgentInteress other = (AgentInteress) obj;
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
            ((this.sUserKey==null && other.getSUserKey()==null) || 
             (this.sUserKey!=null &&
              this.sUserKey.equals(other.getSUserKey()))) &&
            this.nProspectID == other.getNProspectID() &&
            this.nLevel == other.getNLevel();
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
        if (getSUserKey() != null) {
            _hashCode += getSUserKey().hashCode();
        }
        _hashCode += getNProspectID();
        _hashCode += getNLevel();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgentInteress.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">AgentInteress"));
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
        elemField.setFieldName("SUserKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sUserKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NProspectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "nProspectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "nLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
