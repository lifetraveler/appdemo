package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZJJSQ;
import com.zoc.repository.act.CNSZJJSQDao;
import com.zoc.service.act.CNSZJJSQService;

@Service
public class CNSZJJSQServiceImpl extends SuperServiceImpl<CNSZJJSQ, Long> implements CNSZJJSQService {

	@Override
	public void initStatements() {
		this.setStatement(CNSZJJSQDao.class.getName());
	}

}
