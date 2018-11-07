package com.cernet.util;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;


public class CXFClientUtil {  
      
    public static final String CXF_CLIENT_CONNECT_TIMEOUT = Config.getValue("connectTimeOut");  
    public static final String CXF_CLIENT_RECEIVE_TIMEOUT = Config.getValue("receiveTimeOut");  
  
    public static void configTimeout(Object service) {  
        Client proxy = ClientProxy.getClient(service);  
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();  
        HTTPClientPolicy policy = new HTTPClientPolicy();  
        int connectTimeOut = Integer.parseInt(CXF_CLIENT_CONNECT_TIMEOUT)*1000;
        int receiveTimeOut = Integer.parseInt(CXF_CLIENT_RECEIVE_TIMEOUT)*1000;
        policy.setConnectionTimeout(connectTimeOut);  
        policy.setReceiveTimeout(receiveTimeOut);  
        conduit.setClient(policy);  
    }  
      
}  
