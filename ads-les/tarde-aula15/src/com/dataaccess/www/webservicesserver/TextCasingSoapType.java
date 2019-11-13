/**
 * TextCasingSoapType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dataaccess.www.webservicesserver;

public interface TextCasingSoapType extends java.rmi.Remote {
    public java.lang.String titleCaseWordsWithToken(java.lang.String sText, java.lang.String sToken) throws java.rmi.RemoteException;

    /**
     * Uppercase letters that are lowercase and lowercase letters
     * that are uppercase.
     */
    public java.lang.String invertStringCase(java.lang.String sAString) throws java.rmi.RemoteException;

    /**
     * Invert the casing of the first letter and adjust the string
     * to conform with the previous casing of first letter.
     */
    public java.lang.String invertCaseFirstAdjustStringToPrevious(java.lang.String sAString) throws java.rmi.RemoteException;

    /**
     * Invert the casing of the first letter and adjust the string
     * to conform with the current casing of first letter.
     */
    public java.lang.String invertCaseFirstAdjustStringToCurrent(java.lang.String sAString) throws java.rmi.RemoteException;

    /**
     * Change string to uppercase adding token between characters.
     */
    public java.lang.String allUppercaseWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException;

    /**
     * Change string to lowercase adding token between characters.
     */
    public java.lang.String allLowercaseWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException;

    /**
     * Change string to uppercase adding token between characters
     * of each word.
     */
    public java.lang.String uppercaseWordsWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException;

    /**
     * Change string to lowercase adding token between characters
     * of each word.
     */
    public java.lang.String lowercaseWordsWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException;
}
