/**
 * TestFunctionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public class TestFunctionResponse  implements java.io.Serializable {
    private java.lang.String testFunctionResult;

    public TestFunctionResponse() {
    }

    public TestFunctionResponse(
           java.lang.String testFunctionResult) {
           this.testFunctionResult = testFunctionResult;
    }


    /**
     * Gets the testFunctionResult value for this TestFunctionResponse.
     * 
     * @return testFunctionResult
     */
    public java.lang.String getTestFunctionResult() {
        return testFunctionResult;
    }


    /**
     * Sets the testFunctionResult value for this TestFunctionResponse.
     * 
     * @param testFunctionResult
     */
    public void setTestFunctionResult(java.lang.String testFunctionResult) {
        this.testFunctionResult = testFunctionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TestFunctionResponse)) return false;
        TestFunctionResponse other = (TestFunctionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.testFunctionResult==null && other.getTestFunctionResult()==null) || 
             (this.testFunctionResult!=null &&
              this.testFunctionResult.equals(other.getTestFunctionResult())));
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
        if (getTestFunctionResult() != null) {
            _hashCode += getTestFunctionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TestFunctionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emprof.no/", ">TestFunctionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testFunctionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://emprof.no/", "TestFunctionResult"));
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
