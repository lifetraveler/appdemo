package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSDQYZ;
import com.zoc.repository.act.CNNSDQYZDao;
import com.zoc.service.act.CNNSDQYZService;

@Service
public class CNNSDQYZServiceImpl extends SuperServiceImpl<CNNSDQYZ, Long> implements CNNSDQYZService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSDQYZDao.class.getName());
	}

}
