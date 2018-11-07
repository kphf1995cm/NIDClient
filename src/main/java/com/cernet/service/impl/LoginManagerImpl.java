package com.cernet.service.impl;


import com.cernet.dao.LoginDao;
import com.cernet.model.Login;
import com.cernet.service.LoginManager;


public class LoginManagerImpl extends GenericManagerImpl<Login, String> implements
		LoginManager {
	private LoginDao loginDao;
	public LoginManagerImpl(LoginDao loginDao) {
		super(loginDao);
		this.loginDao = loginDao;
	}


}
