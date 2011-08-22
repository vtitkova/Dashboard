/**
 * AgentQueryUpdate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class AgentQueryUpdate  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sAccessKey;

    private java.lang.String sUserKey;

    private int iQueryID;

    private java.lang.String sQueryName;

    private boolean bAlertSMS;

    private boolean bAlertMail;

    public AgentQueryUpdate() {
    }

    public AgentQueryUpdate(
           java.lang.String sIdentityKey,
           java.lang.String sAccessKey,
           java.lang.String sUserKey,
           int iQueryID,
           java.lang.String sQueryName,
           boolean bAlertSMS,
           boolean bAlertMail) {
           this.sIdentityKey = sIdentityKey;
           this.sAccessKey = sAccessKey;
           this.sUserKey = sUserKey;
           this.iQueryID = iQueryID;
           this.sQueryName = sQueryName;
           this.bAlertSMS = bAlertSMS;
           this.bAlertMail = bAlertMail;
    }


    /**
     * Gets the sIdentityKey value for this AgentQueryUpdate.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this AgentQueryUpdate.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sAccessKey value for this AgentQueryUpdate.
     * 
     * @return sAccessKey
     */
    public java.lang.String getSAccessKey() {
        return sAccessKey;
    }


    /**
     * Sets the sAccessKey value for this AgentQueryUpdate.
     * 
     * @param sAccessKey
     */
    public void setSAccessKey(java.lang.String sAccessKey) {
        this.sAccessKey = sAccessKey;
    }


    /**
     * Gets the sUserKey value for this AgentQueryUpdate.
     * 
     * @return sUserKey
     */
    public java.lang.String getSUserKey() {
        return sUserKey;
    }


    /**
     * Sets the sUserKey value for this AgentQueryUpdate.
     * 
     * @param sUserKey
     */
    public void setSUserKey(java.lang.String sUserKey) {
        this.sUserKey = sUserKey;
    }


    /**
     * Gets the iQueryID value for this AgentQueryUpdate.
     * 
     * @return iQueryID
     */
    public int getIQueryID() {
        return iQueryID;
    }


    /**
     * Sets the iQueryID value for this AgentQueryUpdate.
     * 
     * @param iQueryID
     */
    public void setIQueryID(int iQueryID) {
        this.iQueryID = iQueryID;
    }


    /**
     * Gets the sQueryName value for this AgentQueryUpdate.
     * 
     * @return sQueryName
     */
    public java.lang.String getSQueryName() {
        return sQueryName;
    }


    /**
     * Sets the sQueryName value for this AgentQueryUpdate.
     * 
     * @param sQueryName
     */
    public void setSQueryName(java.lang.String sQueryName) {
        this.sQueryName = sQueryName;
    }


    /**
     * Gets the bAlertSMS value for this AgentQueryUpdate.
     * 
     * @return bAlertSMS
     */
    public boolean isBAlertSMS() {
        return bAlertSMS;
    }


    /**
     * Sets the bAlertSMS value for this AgentQueryUpdate.
     * 
     * @param bAlertSMS
     */
    public void setBAlertSMS(boolean bAlertSMS) {
        this.bAlertSMS = bAlertSMS;
    }


    /**
     * Gets the bAlertMail value for this AgentQueryUpdate.
     * 
     * @return bAlertMail
     */
    public boolean isBAlertMail() {
        return bAlertMail;
    }


    /**
     * Sets the bAlertMail value for this AgentQueryUpdate.
     * 
     * @param bAlertMail
     */
    public void setBAlertMail(boolean bAlertMail) {
        this.bAlertMail = bAlertMail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgentQueryUpdate)) return false;
        AgentQueryUpdate other = (AgentQueryUpdate) obj;
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
            this.iQueryID == other.getIQueryID() &&
            ((this.sQueryName==null && other.getSQueryName()==null) || 
             (this.sQueryName!=null &&
              this.sQueryName.equals(other.getSQueryName()))) &&
            this.bAlertSMS == other.isBAlertSMS() &&
            this.bAlertMail == other.isBAlertMail();
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
        _hashCode += getIQueryID();
        if (getSQueryName() != null) {
            _hashCode += getSQueryName().hashCode();
        }
        _hashCode += (isBAlertSMS() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isBAlertMail() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgentQueryUpdate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">AgentQueryUpdate"));
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
        elemField.setFieldName("IQueryID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "iQueryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SQueryName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sQueryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAlertSMS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "bAlertSMS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAlertMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "bAlertMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
