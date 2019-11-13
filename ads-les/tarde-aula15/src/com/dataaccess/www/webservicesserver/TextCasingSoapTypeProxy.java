package com.dataaccess.www.webservicesserver;

public class TextCasingSoapTypeProxy implements com.dataaccess.www.webservicesserver.TextCasingSoapType {
  private String _endpoint = null;
  private com.dataaccess.www.webservicesserver.TextCasingSoapType textCasingSoapType = null;
  
  public TextCasingSoapTypeProxy() {
    _initTextCasingSoapTypeProxy();
  }
  
  public TextCasingSoapTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initTextCasingSoapTypeProxy();
  }
  
  private void _initTextCasingSoapTypeProxy() {
    try {
      textCasingSoapType = (new com.dataaccess.www.webservicesserver.TextCasingLocator()).getTextCasingSoap();
      if (textCasingSoapType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)textCasingSoapType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)textCasingSoapType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (textCasingSoapType != null)
      ((javax.xml.rpc.Stub)textCasingSoapType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dataaccess.www.webservicesserver.TextCasingSoapType getTextCasingSoapType() {
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType;
  }
  
  public java.lang.String titleCaseWordsWithToken(java.lang.String sText, java.lang.String sToken) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.titleCaseWordsWithToken(sText, sToken);
  }
  
  public java.lang.String invertStringCase(java.lang.String sAString) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.invertStringCase(sAString);
  }
  
  public java.lang.String invertCaseFirstAdjustStringToPrevious(java.lang.String sAString) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.invertCaseFirstAdjustStringToPrevious(sAString);
  }
  
  public java.lang.String invertCaseFirstAdjustStringToCurrent(java.lang.String sAString) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.invertCaseFirstAdjustStringToCurrent(sAString);
  }
  
  public java.lang.String allUppercaseWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.allUppercaseWithToken(sAString, sToken);
  }
  
  public java.lang.String allLowercaseWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.allLowercaseWithToken(sAString, sToken);
  }
  
  public java.lang.String uppercaseWordsWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.uppercaseWordsWithToken(sAString, sToken);
  }
  
  public java.lang.String lowercaseWordsWithToken(java.lang.String sAString, java.lang.String sToken) throws java.rmi.RemoteException{
    if (textCasingSoapType == null)
      _initTextCasingSoapTypeProxy();
    return textCasingSoapType.lowercaseWordsWithToken(sAString, sToken);
  }
  
  
}