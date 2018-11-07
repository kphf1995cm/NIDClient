package com.cernet.dao.impl;



import com.cernet.dao.TraceLogDao;
import com.cernet.model.TraceLog;


public class TraceLogDaoHibernate extends GenericDaoHibernate<TraceLog, Long> implements
		TraceLogDao {

	public TraceLogDaoHibernate() {
		super(TraceLog.class);
	}


}
