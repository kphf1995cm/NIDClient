package com.cernet.soa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;



@WebService
public interface NidServer {

	
	@WebMethod
	String tracebackNID(@WebParam(name="nid") String nid, @WebParam(name="mac") String mac, @WebParam(name="ip") String ip);
	
	@WebMethod
	String naIdeaList(@WebParam(name="naIP") String naIp, @WebParam(name="startTime") String startTime, @WebParam(name="endTime") String endTime);
}
