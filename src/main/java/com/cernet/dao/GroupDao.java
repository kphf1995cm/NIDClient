package com.cernet.dao;

import java.util.List;

import com.cernet.model.Group;


public interface GroupDao extends GenericDao<Group, Long> {

	public List<Group> getGroupList();

}
