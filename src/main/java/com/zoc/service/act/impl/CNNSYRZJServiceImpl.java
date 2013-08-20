package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSYRZJ;
import com.zoc.repository.act.CNNSYRZJDao;
import com.zoc.service.act.CNNSYRZJService;

@Service
public class CNNSYRZJServiceImpl extends SuperServiceImpl<CNNSYRZJ, Long> implements CNNSYRZJService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSYRZJDao.class.getName());
	}

}
