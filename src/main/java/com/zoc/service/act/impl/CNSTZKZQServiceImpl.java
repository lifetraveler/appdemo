package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTZKZQ;
import com.zoc.repository.act.CNSTZKZQDao;
import com.zoc.service.act.CNSTZKZQService;

@Service
public class CNSTZKZQServiceImpl extends SuperServiceImpl<CNSTZKZQ, Long> implements CNSTZKZQService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTZKZQDao.class.getName());
	}

}
