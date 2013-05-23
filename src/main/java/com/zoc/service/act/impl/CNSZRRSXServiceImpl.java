package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.repository.act.CNSZRRSXDao;
import com.zoc.service.act.CNSZRRSXService;

@Service
public class CNSZRRSXServiceImpl extends SuperServiceImpl<CNSZRRSX, Long> implements CNSZRRSXService {

	@Autowired
	CNSZRRSXDao CNSZRRSXDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZRRSXDao.class.getName());
	}

	
	
	
	
	
	

}
