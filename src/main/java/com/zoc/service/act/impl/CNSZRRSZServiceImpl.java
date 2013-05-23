package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZRRSZ;
import com.zoc.repository.act.CNSZRRSZDao;
import com.zoc.service.act.CNSZRRSZService;

@Service
public class CNSZRRSZServiceImpl extends SuperServiceImpl<CNSZRRSZ, Long> implements CNSZRRSZService {

	@Autowired
	CNSZRRSZDao cnszrrszDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZRRSZDao.class.getName());
	}


	
	
	
	
	

}
