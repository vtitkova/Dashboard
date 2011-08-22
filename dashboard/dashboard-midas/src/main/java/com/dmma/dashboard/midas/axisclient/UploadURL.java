/**
 * UploadURL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class UploadURL  implements java.io.Serializable {
    private int iRef;

    private java.lang.String sOppdrag;

    private java.lang.String sURL;

    public UploadURL() {
    }

    public UploadURL(
           int iRef,
           java.lang.String sOppdrag,
           java.lang.String sURL) {
           this.iRef = iRef;
           this.sOppdrag = sOppdrag;
           this.sURL = sURL;
    }


    /**
     * Gets the iRef value for this UploadURL.
     * 
     * @return iRef
     */
    public int getIRef() {
        return iRef;
    }


    /**
     * Sets the iRef value for this UploadURL.
     * 
     * @param iRef
     */
    public void setIRef(int iRef) {
        this.iRef = iRef;
    }


    /**
     * Gets the sOppdrag value for this UploadURL.
     * 
     * @return sOppdrag
     */
    public java.lang.String getSOppdrag() {
        return sOppdrag;
    }


    /**
     * Sets the sOppdrag value for this UploadURL.
     * 
     * @param sOppdrag
     */
    public void setSOppdrag(java.lang.String sOppdrag) {
        this.sOppdrag = sOppdrag;
    }


    /**
     * Gets the sURL value for this UploadURL.
     * 
     * @return sURL
     */
    public java.lang.String getSURL() {
        return sURL;
    }


    /**
     * Sets the sURL value for this UploadURL.
     * 
     * @param sURL
     */
    public void setSURL(java.lang.String sURL) {
        this.sURL = sURL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UploadURL)) return false;
        UploadURL other = (UploadURL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.iRef == other.getIRef() &&
            ((this.sOppdrag==null && other.getSOppdrag()==null) || 
             (this.sOppdrag!=null &&
              this.sOppdrag.equals(other.getSOppdrag()))) &&
            ((this.sURL==null && other.getSURL()==null) || 
             (this.sURL!=null &&
              this.sURL.equals(other.getSURL())));
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
        _hashCode += getIRef();
        if (getSOppdrag() != null) {
            _hashCode += getSOppdrag().hashCode();
        }
        if (getSURL() != null) {
            _hashCode += getSURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UploadURL.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">UploadURL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "iRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOppdrag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sOppdrag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sURL"));
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
