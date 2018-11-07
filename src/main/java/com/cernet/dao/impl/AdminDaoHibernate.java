package com.cernet.dao.impl;



import com.cernet.dao.AdminDao;
import com.cernet.model.Admin;


public class AdminDaoHibernate extends GenericDaoHibernate<Admin, String> implements
		AdminDao {

	public AdminDaoHibernate() {
		super(Admin.class);
	}


}
