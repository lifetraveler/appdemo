package com.zoc.service.act.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CNSTYYGP;
import com.zoc.repository.act.CNSTYYGPDao;
import com.zoc.service.act.CNSTYYGPService;

@Service
public class CNSTYYGPServiceImpl extends SuperServiceImpl<CNSTYYGP, Long> implements CNSTYYGPService {

	@Override
	public void initStatements() {
		this.setStatement(CNSTYYGPDao.class.getName());
	}

}
