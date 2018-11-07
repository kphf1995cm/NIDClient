package com.cernet.service.impl;


import java.util.List;

import com.cernet.dao.GroupDao;
import com.cernet.model.Group;
import com.cernet.service.GroupManager;


public class GroupManagerImpl extends GenericManagerImpl<Group, Long> implements
		GroupManager {
	private GroupDao groupDao;
	
	public GroupManagerImpl(GroupDao groupDao) {
		super(groupDao);
		this.groupDao = groupDao;
	}
	
	public List<Group> getGroupList() {
		List<Group> groupList = groupDao.getGroupList();
		return groupList;
	}


}
