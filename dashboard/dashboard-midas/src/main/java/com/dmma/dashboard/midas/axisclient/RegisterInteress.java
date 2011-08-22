/**
 * RegisterInteress.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class RegisterInteress  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sAccessKey;

    private long nProspectID;

    private java.lang.String sServiceName;

    private com.dmma.dashboard.midas.axisclient.ArrayOfStParam params;

    public RegisterInteress() {
    }

    public RegisterInteress(
           java.lang.String sIdentityKey,
           java.lang.String sAccessKey,
           long nProspectID,
           java.lang.String sServiceName,
           com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) {
           this.sIdentityKey = sIdentityKey;
           this.sAccessKey = sAccessKey;
           this.nProspectID = nProspectID;
           this.sServiceName = sServiceName;
           this.params = params;
    }


    /**
     * Gets the sIdentityKey value for this RegisterInteress.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this RegisterInteress.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sAccessKey value for this RegisterInteress.
     * 
     * @return sAccessKey
     */
    public java.lang.String getSAccessKey() {
        return sAccessKey;
    }


    /**
     * Sets the sAccessKey value for this RegisterInteress.
     * 
     * @param sAccessKey
     */
    public void setSAccessKey(java.lang.String sAccessKey) {
        this.sAccessKey = sAccessKey;
    }


    /**
     * Gets the nProspectID value for this RegisterInteress.
     * 
     * @return nProspectID
     */
    public long getNProspectID() {
        return nProspectID;
    }


    /**
     * Sets the nProspectID value for this RegisterInteress.
     * 
     * @param nProspectID
     */
    public void setNProspectID(long nProspectID) {
        this.nProspectID = nProspectID;
    }


    /**
     * Gets the sServiceName value for this RegisterInteress.
     * 
     * @return sServiceName
     */
    public java.lang.String getSServiceName() {
        return sServiceName;
    }


    /**
     * Sets the sServiceName value for this RegisterInteress.
     * 
     * @param sServiceName
     */
    public void setSServiceName(java.lang.String sServiceName) {
        this.sServiceName = sServiceName;
    }


    /**
     * Gets the params value for this RegisterInteress.
     * 
     * @return params
     */
    public com.dmma.dashboard.midas.axisclient.ArrayOfStParam getParams() {
        return params;
    }


    /**
     * Sets the params value for this RegisterInteress.
     * 
     * @param params
     */
    public void setParams(com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) {
        this.params = params;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegisterInteress)) return false;
        RegisterInteress other = (RegisterInteress) obj;
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
            this.nProspectID == other.getNProspectID() &&
            ((this.sServiceName==null && other.getSServiceName()==null) || 
             (this.sServiceName!=null &&
              this.sServiceName.equals(other.getSServiceName()))) &&
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
        if (getSAccessKey() != null) {
            _hashCode += getSAccessKey().hashCode();
        }
        _hashCode += new Long(getNProspectID()).hashCode();
        if (getSServiceName() != null) {
            _hashCode += getSServiceName().hashCode();
        }
        if (getParams() != null) {
            _hashCode += getParams().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegisterInteress.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">RegisterInteress"));
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
        elemField.setFieldName("NProspectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "nProspectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SServiceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sServiceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
