package com.cernet.service.impl;


import com.cernet.dao.IdeaDao;
import com.cernet.model.Idea;
import com.cernet.service.IdeaManager;


public class IdeaManagerImpl extends GenericManagerImpl<Idea, Long> implements
		IdeaManager {
	private IdeaDao ideaDao;
	public IdeaManagerImpl(IdeaDao ideaDao) {
		super(ideaDao);
		this.ideaDao = ideaDao;
	}
	
	public Idea getNtIdea(String naIp, String startTimeString, String endTimeString) {
		
		return ideaDao.getNtIdea(naIp, startTimeString, endTimeString);
	}
	public void updateNtIdea(Idea ntIdea) {
		ideaDao.updateNtIdea(ntIdea);
		
	}


}
