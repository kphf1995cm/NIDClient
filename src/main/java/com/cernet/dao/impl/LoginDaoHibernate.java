package com.cernet.dao.impl;



import com.cernet.dao.LoginDao;
import com.cernet.model.Login;


public class LoginDaoHibernate extends GenericDaoHibernate<Login, String> implements
		LoginDao {

	public LoginDaoHibernate() {
		super(Login.class);
	}


}
