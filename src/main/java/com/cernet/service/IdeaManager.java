package com.cernet.service;

import com.cernet.model.Idea;


public interface IdeaManager extends GenericManager<Idea, Long> {



	public Idea getNtIdea(String naIp, String startTimeString, String endTimeString);

	public void updateNtIdea(Idea ntIdea);

}
