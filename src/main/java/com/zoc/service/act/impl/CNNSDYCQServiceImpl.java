package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYCQ;
import com.zoc.repository.act.CNNSDYCQDao;
import com.zoc.service.act.CNNSDYCQService;

@Service
public class CNNSDYCQServiceImpl extends SuperServiceImpl<CNNSDYCQ, Long> implements CNNSDYCQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYCQDao.class.getName());
	}

}
