package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSYJZQ;
import com.zoc.repository.act.CNNSYJZQDao;
import com.zoc.service.act.CNNSYJZQService;

@Service
public class CNNSYJZQServiceImpl extends SuperServiceImpl<CNNSYJZQ, Long> implements CNNSYJZQService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSYJZQDao.class.getName());
	}

}
