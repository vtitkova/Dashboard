/**
 * NewsTypeDays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class NewsTypeDays  implements java.io.Serializable {
    private java.lang.String sIdentityKey;

    private java.lang.String estateTypes;

    private java.lang.String count;

    private java.lang.String offices;

    private int days;

    private int sortType;

    public NewsTypeDays() {
    }

    public NewsTypeDays(
           java.lang.String sIdentityKey,
           java.lang.String estateTypes,
           java.lang.String count,
           java.lang.String offices,
           int days,
           int sortType) {
           this.sIdentityKey = sIdentityKey;
           this.estateTypes = estateTypes;
           this.count = count;
           this.offices = offices;
           this.days = days;
           this.sortType = sortType;
    }


    /**
     * Gets the sIdentityKey value for this NewsTypeDays.
     * 
     * @return sIdentityKey
     */
    public java.lang.String getSIdentityKey() {
        return sIdentityKey;
    }


    /**
     * Sets the sIdentityKey value for this NewsTypeDays.
     * 
     * @param sIdentityKey
     */
    public void setSIdentityKey(java.lang.String sIdentityKey) {
        this.sIdentityKey = sIdentityKey;
    }


    /**
     * Gets the estateTypes value for this NewsTypeDays.
     * 
     * @return estateTypes
     */
    public java.lang.String getEstateTypes() {
        return estateTypes;
    }


    /**
     * Sets the estateTypes value for this NewsTypeDays.
     * 
     * @param estateTypes
     */
    public void setEstateTypes(java.lang.String estateTypes) {
        this.estateTypes = estateTypes;
    }


    /**
     * Gets the count value for this NewsTypeDays.
     * 
     * @return count
     */
    public java.lang.String getCount() {
        return count;
    }


    /**
     * Sets the count value for this NewsTypeDays.
     * 
     * @param count
     */
    public void setCount(java.lang.String count) {
        this.count = count;
    }


    /**
     * Gets the offices value for this NewsTypeDays.
     * 
     * @return offices
     */
    public java.lang.String getOffices() {
        return offices;
    }


    /**
     * Sets the offices value for this NewsTypeDays.
     * 
     * @param offices
     */
    public void setOffices(java.lang.String offices) {
        this.offices = offices;
    }


    /**
     * Gets the days value for this NewsTypeDays.
     * 
     * @return days
     */
    public int getDays() {
        return days;
    }


    /**
     * Sets the days value for this NewsTypeDays.
     * 
     * @param days
     */
    public void setDays(int days) {
        this.days = days;
    }


    /**
     * Gets the sortType value for this NewsTypeDays.
     * 
     * @return sortType
     */
    public int getSortType() {
        return sortType;
    }


    /**
     * Sets the sortType value for this NewsTypeDays.
     * 
     * @param sortType
     */
    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NewsTypeDays)) return false;
        NewsTypeDays other = (NewsTypeDays) obj;
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
            ((this.estateTypes==null && other.getEstateTypes()==null) || 
             (this.estateTypes!=null &&
              this.estateTypes.equals(other.getEstateTypes()))) &&
            ((this.count==null && other.getCount()==null) || 
             (this.count!=null &&
              this.count.equals(other.getCount()))) &&
            ((this.offices==null && other.getOffices()==null) || 
             (this.offices!=null &&
              this.offices.equals(other.getOffices()))) &&
            this.days == other.getDays() &&
            this.sortType == other.getSortType();
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
        if (getEstateTypes() != null) {
            _hashCode += getEstateTypes().hashCode();
        }
        if (getCount() != null) {
            _hashCode += getCount().hashCode();
        }
        if (getOffices() != null) {
            _hashCode += getOffices().hashCode();
        }
        _hashCode += getDays();
        _hashCode += getSortType();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NewsTypeDays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">NewsTypeDays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIdentityKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "sIdentityKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estateTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "EstateTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "Count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offices");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "Offices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("days");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "Days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "SortType"));
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
