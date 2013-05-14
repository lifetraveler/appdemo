package com.zoc.service.security.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoc.common.page.SuperPage;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;
import com.zoc.repository.security.StandardCodeDao;
import com.zoc.service.security.StandardCodeService;
import com.zoc.service.security.UserService;

import com.zoc.common.service.impl.SuperServiceImpl;

@Service
public class StandardCodeServiceImpl extends SuperServiceImpl<StandardCode, Long> implements StandardCodeService {

	@Autowired
	private StandardCodeDao standardCodeDao;

	@Override
	public void initStatements() {
		this.setStatement(StandardCodeDao.class.getName());
	}

}
