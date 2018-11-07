package com.cernet.service.impl;


import com.cernet.dao.DomainDao;
import com.cernet.model.Domain;
import com.cernet.service.DomainManager;


public class DomainManagerImpl extends GenericManagerImpl<Domain, Long> implements
		DomainManager {
	private DomainDao domainDao;
	public DomainManagerImpl(DomainDao domainDao) {
		super(domainDao);
		this.domainDao = domainDao;
	}


}
