package com.cernet.dao.impl;



import java.util.List;

import com.cernet.dao.TraceResultDao;
import com.cernet.model.TraceResult;


public class TraceResultDaoHibernate extends GenericDaoHibernate<TraceResult, Long> implements
		TraceResultDao {

	public TraceResultDaoHibernate() {
		super(TraceResult.class);
	}

	public List<TraceResult> getTraceResultByPara(String ipaddr, String userName) {
		String hql =" from TraceResult where tracedIp = ? and addOpr = ?" ;
    	String[] paramsStrings = new String[]{ipaddr, userName};
        List l = getHibernateTemplate().find(hql, paramsStrings );
		return l;
	}


}
