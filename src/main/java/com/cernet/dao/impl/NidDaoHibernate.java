package com.cernet.dao.impl;




import com.cernet.dao.NidDao;
import com.cernet.model.Nid;


public class NidDaoHibernate extends GenericDaoHibernate<Nid, Long> implements
		NidDao {

	public NidDaoHibernate() {
		super(Nid.class);
	}

	

}
