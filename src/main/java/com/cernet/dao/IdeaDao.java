package com.cernet.dao;

import com.cernet.model.Idea;


public interface IdeaDao extends GenericDao<Idea, Long> {

	//public void updateIdeaTable(Idea naIdea);

	public Idea getNtIdea(String naIp, String startTimeString, String endTimeString);

	public void updateNtIdea(Idea ntIdea);

}
