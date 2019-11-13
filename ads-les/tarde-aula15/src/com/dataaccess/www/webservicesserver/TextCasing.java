/**
 * TextCasing.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dataaccess.www.webservicesserver;

public interface TextCasing extends javax.xml.rpc.Service {

/**
 * The Text Casing Web Service, implemented with DataFlex, provides
 * functions to change text casing in different ways.
 */
    public java.lang.String getTextCasingSoapAddress();

    public com.dataaccess.www.webservicesserver.TextCasingSoapType getTextCasingSoap() throws javax.xml.rpc.ServiceException;

    public com.dataaccess.www.webservicesserver.TextCasingSoapType getTextCasingSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
