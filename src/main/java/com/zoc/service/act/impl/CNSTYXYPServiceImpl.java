package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTYXYP;
import com.zoc.repository.act.CNSTYXYPDao;
import com.zoc.service.act.CNSTYXYPService;

@Service
public class CNSTYXYPServiceImpl extends SuperServiceImpl<CNSTYXYP, Long> implements CNSTYXYPService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTYXYPDao.class.getName());
	}

}
