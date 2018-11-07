package com.cernet.dao;

import java.util.List;

import com.cernet.model.TraceResult;


public interface TraceResultDao extends GenericDao<TraceResult, Long> {

	public List<TraceResult> getTraceResultByPara(String ipaddr, String userName);

}
