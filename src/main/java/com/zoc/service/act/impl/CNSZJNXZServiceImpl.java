package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSZJNXZ;
import com.zoc.repository.act.CNSZJNXZDao;
import com.zoc.service.act.CNSZJNXZService;

@Service
public class CNSZJNXZServiceImpl extends SuperServiceImpl<CNSZJNXZ, Long> implements CNSZJNXZService {


	@Override
	public void initStatements() {
		this.setStatement(CNSZJNXZDao.class.getName());
	}

}
