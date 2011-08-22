/**
 * AgentSaveUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class AgentSaveUser  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sAccessKey;

    private java.lang.String userID;

    private java.lang.String sFirstName;

    private java.lang.String sLastName;

    private java.lang.String sCellPhone;

    private java.lang.String sAdress;

    private java.lang.String sAdress2;

    private java.lang.String sZipCode;

    private java.lang.String sCity;

    private java.lang.String sPrivatePhone;

    private java.lang.String sJobPhone;

    private java.lang.String sFax;

    private boolean cellAlerts;

    public AgentSaveUser() {
    }

    public AgentSaveUser(
           java.lang.String sIdentityKey,
           java.lang.String sAccessKey,
           java.lang.String userID,
           java.lang.String sFirstName,
           java.lang.String sLastName,
           java.lang.String sCellPhone,
           java.lang.String sAdress,
           java.lang.String sAdress2,
           java.lang.String sZipCode,
           java.lang.String sCity,
           java.lang.String sPrivatePhone,
           java.lang.String sJobPhone,
           java.lang.String sFax,
           boolean cellAlerts) {
           this.sIdentityKey = sIdentityKey;
           this.sAccessKey = sAccessKey;
           this.userID = userID;
           this.sFirstName = sFirstName;
           this.sLastName = sLastName;
           this.sCellPhone = sCellPhone;
           this.sAdress = sAdress;
           this.sAdress2 = sAdress2;
           this.sZipCode = sZipCode;
           this.sCity = sCity;
           this.sPrivatePhone = sPrivatePhone;
           this.sJobPhone = sJobPhone;
           this.sFax = sFax;
           this.cellAlerts = cellAlerts;
    }


    /**
     * Gets the sIdentityKey value for this AgentSaveUser.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this AgentSaveUser.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sAccessKey value for this AgentSaveUser.
     * 
     * @return sAccessKey
     */
    public java.lang.String getSAccessKey() {
        return sAccessKey;
    }


    /**
     * Sets the sAccessKey value for this AgentSaveUser.
     * 
     * @param sAccessKey
     */
    public void setSAccessKey(java.lang.String sAccessKey) {
        this.sAccessKey = sAccessKey;
    }


    /**
     * Gets the userID value for this AgentSaveUser.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this AgentSaveUser.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }


    /**
     * Gets the sFirstName value for this AgentSaveUser.
     * 
     * @return sFirstName
     */
    public java.lang.String getSFirstName() {
        return sFirstName;
    }


    /**
     * Sets the sFirstName value for this AgentSaveUser.
     * 
     * @param sFirstName
     */
    public void setSFirstName(java.lang.String sFirstName) {
        this.sFirstName = sFirstName;
    }


    /**
     * Gets the sLastName value for this AgentSaveUser.
     * 
     * @return sLastName
     */
    public java.lang.String getSLastName() {
        return sLastName;
    }


    /**
     * Sets the sLastName value for this AgentSaveUser.
     * 
     * @param sLastName
     */
    public void setSLastName(java.lang.String sLastName) {
        this.sLastName = sLastName;
    }


    /**
     * Gets the sCellPhone value for this AgentSaveUser.
     * 
     * @return sCellPhone
     */
    public java.lang.String getSCellPhone() {
        return sCellPhone;
    }


    /**
     * Sets the sCellPhone value for this AgentSaveUser.
     * 
     * @param sCellPhone
     */
    public void setSCellPhone(java.lang.String sCellPhone) {
        this.sCellPhone = sCellPhone;
    }


    /**
     * Gets the sAdress value for this AgentSaveUser.
     * 
     * @return sAdress
     */
    public java.lang.String getSAdress() {
        return sAdress;
    }


    /**
     * Sets the sAdress value for this AgentSaveUser.
     * 
     * @param sAdress
     */
    public void setSAdress(java.lang.String sAdress) {
        this.sAdress = sAdress;
    }


    /**
     * Gets the sAdress2 value for this AgentSaveUser.
     * 
     * @return sAdress2
     */
    public java.lang.String getSAdress2() {
        return sAdress2;
    }


    /**
     * Sets the sAdress2 value for this AgentSaveUser.
     * 
     * @param sAdress2
     */
    public void setSAdress2(java.lang.String sAdress2) {
        this.sAdress2 = sAdress2;
    }


    /**
     * Gets the sZipCode value for this AgentSaveUser.
     * 
     * @return sZipCode
     */
    public java.lang.String getSZipCode() {
        return sZipCode;
    }


    /**
     * Sets the sZipCode value for this AgentSaveUser.
     * 
     * @param sZipCode
     */
    public void setSZipCode(java.lang.String sZipCode) {
        this.sZipCode = sZipCode;
    }


    /**
     * Gets the sCity value for this AgentSaveUser.
     * 
     * @return sCity
     */
    public java.lang.String getSCity() {
        return sCity;
    }


    /**
     * Sets the sCity value for this AgentSaveUser.
     * 
     * @param sCity
     */
    public void setSCity(java.lang.String sCity) {
        this.sCity = sCity;
    }


    /**
     * Gets the sPrivatePhone value for this AgentSaveUser.
     * 
     * @return sPrivatePhone
     */
    public java.lang.String getSPrivatePhone() {
        return sPrivatePhone;
    }


    /**
     * Sets the sPrivatePhone value for this AgentSaveUser.
     * 
     * @param sPrivatePhone
     */
    public void setSPrivatePhone(java.lang.String sPrivatePhone) {
        this.sPrivatePhone = sPrivatePhone;
    }


    /**
     * Gets the sJobPhone value for this AgentSaveUser.
     * 
     * @return sJobPhone
     */
    public java.lang.String getSJobPhone() {
        return sJobPhone;
    }


    /**
     * Sets the sJobPhone value for this AgentSaveUser.
     * 
     * @param sJobPhone
     */
    public void setSJobPhone(java.lang.String sJobPhone) {
        this.sJobPhone = sJobPhone;
    }


    /**
     * Gets the sFax value for this AgentSaveUser.
     * 
     * @return sFax
     */
    public java.lang.String getSFax() {
        return sFax;
    }


    /**
     * Sets the sFax value for this AgentSaveUser.
     * 
     * @param sFax
     */
    public void setSFax(java.lang.String sFax) {
        this.sFax = sFax;
    }


    /**
     * Gets the cellAlerts value for this AgentSaveUser.
     * 
     * @return cellAlerts
     */
    public boolean isCellAlerts() {
        return cellAlerts;
    }


    /**
     * Sets the cellAlerts value for this AgentSaveUser.
     * 
     * @param cellAlerts
     */
    public void setCellAlerts(boolean cellAlerts) {
        this.cellAlerts = cellAlerts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgentSaveUser)) return false;
        AgentSaveUser other = (AgentSaveUser) obj;
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
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID()))) &&
            ((this.sFirstName==null && other.getSFirstName()==null) || 
             (this.sFirstName!=null &&
              this.sFirstName.equals(other.getSFirstName()))) &&
            ((this.sLastName==null && other.getSLastName()==null) || 
             (this.sLastName!=null &&
              this.sLastName.equals(other.getSLastName()))) &&
            ((this.sCellPhone==null && other.getSCellPhone()==null) || 
             (this.sCellPhone!=null &&
              this.sCellPhone.equals(other.getSCellPhone()))) &&
            ((this.sAdress==null && other.getSAdress()==null) || 
             (this.sAdress!=null &&
              this.sAdress.equals(other.getSAdress()))) &&
            ((this.sAdress2==null && other.getSAdress2()==null) || 
             (this.sAdress2!=null &&
              this.sAdress2.equals(other.getSAdress2()))) &&
            ((this.sZipCode==null && other.getSZipCode()==null) || 
             (this.sZipCode!=null &&
              this.sZipCode.equals(other.getSZipCode()))) &&
            ((this.sCity==null && other.getSCity()==null) || 
             (this.sCity!=null &&
              this.sCity.equals(other.getSCity()))) &&
            ((this.sPrivatePhone==null && other.getSPrivatePhone()==null) || 
             (this.sPrivatePhone!=null &&
              this.sPrivatePhone.equals(other.getSPrivatePhone()))) &&
            ((this.sJobPhone==null && other.getSJobPhone()==null) || 
             (this.sJobPhone!=null &&
              this.sJobPhone.equals(other.getSJobPhone()))) &&
            ((this.sFax==null && other.getSFax()==null) || 
             (this.sFax!=null &&
              this.sFax.equals(other.getSFax()))) &&
            this.cellAlerts == other.isCellAlerts();
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
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        if (getSFirstName() != null) {
            _hashCode += getSFirstName().hashCode();
        }
        if (getSLastName() != null) {
            _hashCode += getSLastName().hashCode();
        }
        if (getSCellPhone() != null) {
            _hashCode += getSCellPhone().hashCode();
        }
        if (getSAdress() != null) {
            _hashCode += getSAdress().hashCode();
        }
        if (getSAdress2() != null) {
            _hashCode += getSAdress2().hashCode();
        }
        if (getSZipCode() != null) {
            _hashCode += getSZipCode().hashCode();
        }
        if (getSCity() != null) {
            _hashCode += getSCity().hashCode();
        }
        if (getSPrivatePhone() != null) {
            _hashCode += getSPrivatePhone().hashCode();
        }
        if (getSJobPhone() != null) {
            _hashCode += getSJobPhone().hashCode();
        }
        if (getSFax() != null) {
            _hashCode += getSFax().hashCode();
        }
        _hashCode += (isCellAlerts() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgentSaveUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">AgentSaveUser"));
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
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "UserID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SFirstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sFirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sLastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sCellPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAdress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sAdress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAdress2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sAdress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SZipCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sZipCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPrivatePhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sPrivatePhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SJobPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sJobPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SFax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sFax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cellAlerts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "CellAlerts"));
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
