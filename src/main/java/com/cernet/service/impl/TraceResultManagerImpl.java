package com.cernet.service.impl;


import java.util.List;

import com.cernet.dao.TraceResultDao;
import com.cernet.model.TraceResult;
import com.cernet.service.TraceResultManager;


public class TraceResultManagerImpl extends GenericManagerImpl<TraceResult, Long> implements
		TraceResultManager {
	private TraceResultDao traceResultDao;
	public TraceResultManagerImpl(TraceResultDao traceResultDao) {
		super(traceResultDao);
		this.traceResultDao = traceResultDao;
	}
	public List<TraceResult> getTraceResultByPara(String ipaddr, String userName) {
		// TODO Auto-generated method stub
		return traceResultDao.getTraceResultByPara(ipaddr, userName);
	}


}
