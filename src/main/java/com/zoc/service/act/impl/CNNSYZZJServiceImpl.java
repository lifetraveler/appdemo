package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSYZZJ;
import com.zoc.repository.act.CNNSYZZJDao;
import com.zoc.service.act.CNNSYZZJService;

@Service
public class CNNSYZZJServiceImpl extends SuperServiceImpl<CNNSYZZJ, Long> implements CNNSYZZJService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSYZZJDao.class.getName());
	}

}
