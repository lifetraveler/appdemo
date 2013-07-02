package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTZSZQ;
import com.zoc.repository.act.CNSTZSZQDao;
import com.zoc.service.act.CNSTZSZQService;

@Service
public class CNSTZSZQServiceImpl extends SuperServiceImpl<CNSTZSZQ, Long> implements CNSTZSZQService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTZSZQDao.class.getName());
	}

}
