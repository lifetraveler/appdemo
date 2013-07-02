package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZJNXX;
import com.zoc.repository.act.CNSZJNXXDao;
import com.zoc.service.act.CNSZJNXXService;

@Service
public class CNSZJNXXServiceImpl extends SuperServiceImpl<CNSZJNXX, Long> implements CNSZJNXXService {


	@Override
	public void initStatements() {
		this.setStatement(CNSZJNXXDao.class.getName());
	}

}
