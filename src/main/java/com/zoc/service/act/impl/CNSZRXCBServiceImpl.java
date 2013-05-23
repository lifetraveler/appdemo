package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZRXCB;
import com.zoc.repository.act.CNSZRXCBDao;
import com.zoc.service.act.CNSZRXCBService;

@Service
public class CNSZRXCBServiceImpl extends SuperServiceImpl<CNSZRXCB, Long> implements CNSZRXCBService {

	@Autowired
	CNSZRXCBDao CNSZRXCBDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZRXCBDao.class.getName());
	}


	
	
	
	
	
	

}
