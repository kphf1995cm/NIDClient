package com.cernet.service;

import java.util.List;

import com.cernet.model.TraceResult;


public interface TraceResultManager extends GenericManager<TraceResult, Long> {

	public List<TraceResult> getTraceResultByPara(String ipaddr, String userName);

}
