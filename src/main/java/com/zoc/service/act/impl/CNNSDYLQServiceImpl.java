package com.zoc.service.act.impl;

import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYLQ;
import com.zoc.repository.act.CNNSDYLQDao;
import com.zoc.service.act.CNNSDYLQService;

@Service
public class CNNSDYLQServiceImpl extends SuperServiceImpl<CNNSDYLQ, Long> implements CNNSDYLQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYLQDao.class.getName());
	}

}
