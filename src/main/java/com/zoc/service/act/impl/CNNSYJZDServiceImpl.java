package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNNSYJZD;
import com.zoc.repository.act.CNNSYJZDDao;
import com.zoc.service.act.CNNSYJZDService;

@Service
public class CNNSYJZDServiceImpl extends SuperServiceImpl<CNNSYJZD, Long> implements CNNSYJZDService {

	@Override
	public void initStatements() {
		this.setStatement(CNNSYJZDDao.class.getName());
	}

}
