package com.cernet.dao.impl;



import java.util.List;

import com.cernet.dao.GroupDao;
import com.cernet.model.Group;


public class GroupDaoHibernate extends GenericDaoHibernate<Group, Long> implements
		GroupDao {

	public GroupDaoHibernate() {
		super(Group.class);
	}

	public List<Group> getGroupList() {
		  String hql =" from Group" ;
	      return getHibernateTemplate().find(hql);
	}


}
