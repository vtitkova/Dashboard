/**
 * SearchTestManual.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class SearchTestManual  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String n1;

    private java.lang.String v1;

    private java.lang.String n2;

    private java.lang.String v2;

    private java.lang.String n3;

    private java.lang.String v3;

    public SearchTestManual() {
    }

    public SearchTestManual(
           java.lang.String sIdentityKey,
           java.lang.String n1,
           java.lang.String v1,
           java.lang.String n2,
           java.lang.String v2,
           java.lang.String n3,
           java.lang.String v3) {
           this.sIdentityKey = sIdentityKey;
           this.n1 = n1;
           this.v1 = v1;
           this.n2 = n2;
           this.v2 = v2;
           this.n3 = n3;
           this.v3 = v3;
    }


    /**
     * Gets the sIdentityKey value for this SearchTestManual.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this SearchTestManual.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the n1 value for this SearchTestManual.
     * 
     * @return n1
     */
    public java.lang.String getN1() {
        return n1;
    }


    /**
     * Sets the n1 value for this SearchTestManual.
     * 
     * @param n1
     */
    public void setN1(java.lang.String n1) {
        this.n1 = n1;
    }


    /**
     * Gets the v1 value for this SearchTestManual.
     * 
     * @return v1
     */
    public java.lang.String getV1() {
        return v1;
    }


    /**
     * Sets the v1 value for this SearchTestManual.
     * 
     * @param v1
     */
    public void setV1(java.lang.String v1) {
        this.v1 = v1;
    }


    /**
     * Gets the n2 value for this SearchTestManual.
     * 
     * @return n2
     */
    public java.lang.String getN2() {
        return n2;
    }


    /**
     * Sets the n2 value for this SearchTestManual.
     * 
     * @param n2
     */
    public void setN2(java.lang.String n2) {
        this.n2 = n2;
    }


    /**
     * Gets the v2 value for this SearchTestManual.
     * 
     * @return v2
     */
    public java.lang.String getV2() {
        return v2;
    }


    /**
     * Sets the v2 value for this SearchTestManual.
     * 
     * @param v2
     */
    public void setV2(java.lang.String v2) {
        this.v2 = v2;
    }


    /**
     * Gets the n3 value for this SearchTestManual.
     * 
     * @return n3
     */
    public java.lang.String getN3() {
        return n3;
    }


    /**
     * Sets the n3 value for this SearchTestManual.
     * 
     * @param n3
     */
    public void setN3(java.lang.String n3) {
        this.n3 = n3;
    }


    /**
     * Gets the v3 value for this SearchTestManual.
     * 
     * @return v3
     */
    public java.lang.String getV3() {
        return v3;
    }


    /**
     * Sets the v3 value for this SearchTestManual.
     * 
     * @param v3
     */
    public void setV3(java.lang.String v3) {
        this.v3 = v3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchTestManual)) return false;
        SearchTestManual other = (SearchTestManual) obj;
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
            ((this.n1==null && other.getN1()==null) || 
             (this.n1!=null &&
              this.n1.equals(other.getN1()))) &&
            ((this.v1==null && other.getV1()==null) || 
             (this.v1!=null &&
              this.v1.equals(other.getV1()))) &&
            ((this.n2==null && other.getN2()==null) || 
             (this.n2!=null &&
              this.n2.equals(other.getN2()))) &&
            ((this.v2==null && other.getV2()==null) || 
             (this.v2!=null &&
              this.v2.equals(other.getV2()))) &&
            ((this.n3==null && other.getN3()==null) || 
             (this.n3!=null &&
              this.n3.equals(other.getN3()))) &&
            ((this.v3==null && other.getV3()==null) || 
             (this.v3!=null &&
              this.v3.equals(other.getV3())));
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
        if (getN1() != null) {
            _hashCode += getN1().hashCode();
        }
        if (getV1() != null) {
            _hashCode += getV1().hashCode();
        }
        if (getN2() != null) {
            _hashCode += getN2().hashCode();
        }
        if (getV2() != null) {
            _hashCode += getV2().hashCode();
        }
        if (getN3() != null) {
            _hashCode += getN3().hashCode();
        }
        if (getV3() != null) {
            _hashCode += getV3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchTestManual.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">SearchTestManual"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIdentityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sIdentityKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "n1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("v1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "v1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "n2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("v2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "v2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "n3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("v3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "v3"));
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
