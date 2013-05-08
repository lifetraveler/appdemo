package com.zoc.service.security.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.zoc.common.SuperUtils;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.In_2_2_1;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.User;
import com.zoc.repository.security.MenuDao;
import com.zoc.repository.security.UserDao;
import com.zoc.service.security.MenuService;
import com.zoc.service.security.UserService;

@Service
public class MenuServiceImpl extends SuperServiceImpl<Menu, Long> implements MenuService {

	MenuDao menuDao;

	@Override
	public void initStatements() {
		this.setStatement(MenuDao.class.getName());
	}

}
