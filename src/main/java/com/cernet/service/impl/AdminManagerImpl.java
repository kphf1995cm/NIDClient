package com.cernet.service.impl;


import com.cernet.dao.AdminDao;
import com.cernet.model.Admin;
import com.cernet.service.AdminManager;


public class AdminManagerImpl extends GenericManagerImpl<Admin, String> implements
		AdminManager {
	private AdminDao adminDao;
	public AdminManagerImpl(AdminDao adminDao) {
		super(adminDao);
		this.adminDao = adminDao;
	}


}
