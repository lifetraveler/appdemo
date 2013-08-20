package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYQK;
import com.zoc.repository.act.CNNSDYQKDao;
import com.zoc.service.act.CNNSDYQKService;

@Service
public class CNNSDYQKServiceImpl extends SuperServiceImpl<CNNSDYQK, Long> implements CNNSDYQKService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYQKDao.class.getName());
	}

}
