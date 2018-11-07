package com.cernet.dao.impl;



import java.util.List;

import com.cernet.dao.IdeaDao;
import com.cernet.model.Idea;


public class IdeaDaoHibernate extends GenericDaoHibernate<Idea, Long> implements
		IdeaDao {

	public IdeaDaoHibernate() {
		super(Idea.class);
	}

	//public void updateIdeaTable(Idea naIdea) {
		
		
		
		
	//}

	public Idea getNtIdea(String naIp, String startTimeString,
			String endTimeString) {
		Idea ntIdea = null;
		try {
			String ntideasql = "from Idea i where 1=1 ";
			if(null != naIp && !naIp.equals("")){
				ntideasql += " and i.naIp = '" + naIp + "' ";
			}
			if(null != startTimeString && !startTimeString.equals("")){
				ntideasql += " and i.startTime = '" + startTimeString + "'";
			}
			if(null != endTimeString && !endTimeString.equals("")){
				ntideasql += " and i.endTime = '" + endTimeString + "'";
			}
			List<Idea> ntideaList = getHibernateTemplate().find(ntideasql);
			if(null != ntideaList && ntideaList.size() > 0){
				ntIdea = ntideaList.get(0);
			}
		}  catch (Exception exc) {
			System.out.println(exc);
			return null;
		}
		return ntIdea;
	}

	public void updateNtIdea(Idea ntIdea) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(ntIdea);
	}


}
