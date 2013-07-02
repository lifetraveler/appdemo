package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDYCN;
import com.zoc.repository.act.CNNSDYCNDao;
import com.zoc.service.act.CNNSDYCNService;

@Service
public class CNNSDYCNServiceImpl extends SuperServiceImpl<CNNSDYCN, Long> implements CNNSDYCNService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDYCNDao.class.getName());
	}

}
