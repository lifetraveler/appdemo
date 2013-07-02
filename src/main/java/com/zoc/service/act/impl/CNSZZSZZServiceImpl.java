package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZZSZZ;
import com.zoc.repository.act.CNSZZSZZDao;
import com.zoc.service.act.CNSZZSZZService;

@Service
public class CNSZZSZZServiceImpl extends SuperServiceImpl<CNSZZSZZ, Long> implements CNSZZSZZService {

	@Autowired
	CNSZZSZZDao cnszjjsqDao;

	@Override
	public void initStatements() {
		this.setStatement(CNSZZSZZDao.class.getName());
	}

}
