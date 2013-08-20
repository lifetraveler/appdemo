package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYGQ;
import com.zoc.repository.act.CNNSDYGQDao;
import com.zoc.service.act.CNNSDYGQService;

@Service
public class CNNSDYGQServiceImpl extends SuperServiceImpl<CNNSDYGQ, Long> implements CNNSDYGQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYGQDao.class.getName());
	}

}
