package com.cernet.service.impl;



import com.cernet.dao.NidDao;
import com.cernet.model.Nid;
import com.cernet.service.NidManager;


public class NidManagerImpl extends GenericManagerImpl<Nid, Long> implements
		NidManager {
	private NidDao nidDao;
	
	public NidManagerImpl(NidDao nidDao) {
		super(nidDao);
		this.nidDao = nidDao;
	}
	
	
}
