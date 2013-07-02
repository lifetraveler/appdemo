package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYJQ;
import com.zoc.repository.act.CNNSDYJQDao;
import com.zoc.service.act.CNNSDYJQService;

@Service
public class CNNSDYJQServiceImpl extends SuperServiceImpl<CNNSDYJQ, Long> implements CNNSDYJQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYJQDao.class.getName());
	}

}
