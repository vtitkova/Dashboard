/**
 * SaveSearch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class SaveSearch  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sUserKey;

    private java.lang.String sQueryName;

    private int bAlertMail;

    private int bAlertSMS;

    private com.dmma.dashboard.midas.axisclient.ArrayOfStParam params;

    public SaveSearch() {
    }

    public SaveSearch(
           java.lang.String sIdentityKey,
           java.lang.String sUserKey,
           java.lang.String sQueryName,
           int bAlertMail,
           int bAlertSMS,
           com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) {
           this.sIdentityKey = sIdentityKey;
           this.sUserKey = sUserKey;
           this.sQueryName = sQueryName;
           this.bAlertMail = bAlertMail;
           this.bAlertSMS = bAlertSMS;
           this.params = params;
    }


    /**
     * Gets the sIdentityKey value for this SaveSearch.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this SaveSearch.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sUserKey value for this SaveSearch.
     * 
     * @return sUserKey
     */
    public java.lang.String getSUserKey() {
        return sUserKey;
    }


    /**
     * Sets the sUserKey value for this SaveSearch.
     * 
     * @param sUserKey
     */
    public void setSUserKey(java.lang.String sUserKey) {
        this.sUserKey = sUserKey;
    }


    /**
     * Gets the sQueryName value for this SaveSearch.
     * 
     * @return sQueryName
     */
    public java.lang.String getSQueryName() {
        return sQueryName;
    }


    /**
     * Sets the sQueryName value for this SaveSearch.
     * 
     * @param sQueryName
     */
    public void setSQueryName(java.lang.String sQueryName) {
        this.sQueryName = sQueryName;
    }


    /**
     * Gets the bAlertMail value for this SaveSearch.
     * 
     * @return bAlertMail
     */
    public int getBAlertMail() {
        return bAlertMail;
    }


    /**
     * Sets the bAlertMail value for this SaveSearch.
     * 
     * @param bAlertMail
     */
    public void setBAlertMail(int bAlertMail) {
        this.bAlertMail = bAlertMail;
    }


    /**
     * Gets the bAlertSMS value for this SaveSearch.
     * 
     * @return bAlertSMS
     */
    public int getBAlertSMS() {
        return bAlertSMS;
    }


    /**
     * Sets the bAlertSMS value for this SaveSearch.
     * 
     * @param bAlertSMS
     */
    public void setBAlertSMS(int bAlertSMS) {
        this.bAlertSMS = bAlertSMS;
    }


    /**
     * Gets the params value for this SaveSearch.
     * 
     * @return params
     */
    public com.dmma.dashboard.midas.axisclient.ArrayOfStParam getParams() {
        return params;
    }


    /**
     * Sets the params value for this SaveSearch.
     * 
     * @param params
     */
    public void setParams(com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) {
        this.params = params;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveSearch)) return false;
        SaveSearch other = (SaveSearch) obj;
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
            ((this.sUserKey==null && other.getSUserKey()==null) || 
             (this.sUserKey!=null &&
              this.sUserKey.equals(other.getSUserKey()))) &&
            ((this.sQueryName==null && other.getSQueryName()==null) || 
             (this.sQueryName!=null &&
              this.sQueryName.equals(other.getSQueryName()))) &&
            this.bAlertMail == other.getBAlertMail() &&
            this.bAlertSMS == other.getBAlertSMS() &&
            ((this.params==null && other.getParams()==null) || 
             (this.params!=null &&
              this.params.equals(other.getParams())));
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
        if (getSUserKey() != null) {
            _hashCode += getSUserKey().hashCode();
        }
        if (getSQueryName() != null) {
            _hashCode += getSQueryName().hashCode();
        }
        _hashCode += getBAlertMail();
        _hashCode += getBAlertSMS();
        if (getParams() != null) {
            _hashCode += getParams().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveSearch.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">SaveSearch"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIdentityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sIdentityKey"));
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
        elemField.setFieldName("SQueryName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sQueryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAlertMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "bAlertMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAlertSMS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "bAlertSMS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("params");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "Params"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", "ArrayOfStParam"));
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
