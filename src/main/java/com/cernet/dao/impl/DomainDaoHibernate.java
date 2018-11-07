package com.cernet.dao.impl;



import com.cernet.dao.DomainDao;
import com.cernet.model.Domain;


public class DomainDaoHibernate extends GenericDaoHibernate<Domain, Long> implements
		DomainDao {

	public DomainDaoHibernate() {
		super(Domain.class);
	}


}
