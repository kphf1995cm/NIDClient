package com.cernet.service;

import java.util.List;

import com.cernet.model.Group;


public interface GroupManager extends GenericManager<Group, Long> {

	public List<Group> getGroupList();

}
