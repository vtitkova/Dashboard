/**
 * TempLinkID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class TempLinkID  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String sBaseIdent;

    private java.lang.String sPropertyNo;

    public TempLinkID() {
    }

    public TempLinkID(
           java.lang.String sIdentityKey,
           java.lang.String sBaseIdent,
           java.lang.String sPropertyNo) {
           this.sIdentityKey = sIdentityKey;
           this.sBaseIdent = sBaseIdent;
           this.sPropertyNo = sPropertyNo;
    }


    /**
     * Gets the sIdentityKey value for this TempLinkID.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this TempLinkID.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the sBaseIdent value for this TempLinkID.
     * 
     * @return sBaseIdent
     */
    public java.lang.String getSBaseIdent() {
        return sBaseIdent;
    }


    /**
     * Sets the sBaseIdent value for this TempLinkID.
     * 
     * @param sBaseIdent
     */
    public void setSBaseIdent(java.lang.String sBaseIdent) {
        this.sBaseIdent = sBaseIdent;
    }


    /**
     * Gets the sPropertyNo value for this TempLinkID.
     * 
     * @return sPropertyNo
     */
    public java.lang.String getSPropertyNo() {
        return sPropertyNo;
    }


    /**
     * Sets the sPropertyNo value for this TempLinkID.
     * 
     * @param sPropertyNo
     */
    public void setSPropertyNo(java.lang.String sPropertyNo) {
        this.sPropertyNo = sPropertyNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TempLinkID)) return false;
        TempLinkID other = (TempLinkID) obj;
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
            ((this.sBaseIdent==null && other.getSBaseIdent()==null) || 
             (this.sBaseIdent!=null &&
              this.sBaseIdent.equals(other.getSBaseIdent()))) &&
            ((this.sPropertyNo==null && other.getSPropertyNo()==null) || 
             (this.sPropertyNo!=null &&
              this.sPropertyNo.equals(other.getSPropertyNo())));
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
        if (getSBaseIdent() != null) {
            _hashCode += getSBaseIdent().hashCode();
        }
        if (getSPropertyNo() != null) {
            _hashCode += getSPropertyNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TempLinkID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">TempLinkID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIdentityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sIdentityKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBaseIdent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sBaseIdent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPropertyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sPropertyNo"));
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
