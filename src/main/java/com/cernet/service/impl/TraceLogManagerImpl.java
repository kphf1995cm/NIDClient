package com.cernet.service.impl;


import com.cernet.dao.TraceLogDao;
import com.cernet.model.TraceLog;
import com.cernet.service.TraceLogManager;


public class TraceLogManagerImpl extends GenericManagerImpl<TraceLog, Long> implements
		TraceLogManager {
	private TraceLogDao traceLogDao;
	public TraceLogManagerImpl(TraceLogDao traceLogDao) {
		super(traceLogDao);
		this.traceLogDao = traceLogDao;
	}


}
