package com.zoc.service.act.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.zoc.common.SuperUtils;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.act.CWSJHGJJ;
import com.zoc.entity.act.CWSJSRGZ;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.User;
import com.zoc.repository.act.CWSJHGJJDao;
import com.zoc.repository.act.CWSJSRGZDao;
import com.zoc.repository.security.MenuDao;
import com.zoc.repository.security.PermissionDao;
import com.zoc.repository.security.UserDao;
import com.zoc.service.act.CWSJHGJJService;
import com.zoc.service.act.CWSJSRGZService;
import com.zoc.service.security.MenuService;
import com.zoc.service.security.UserService;

@Service
public class CWSJSRGZServiceImpl extends SuperServiceImpl<CWSJSRGZ, Long> implements CWSJSRGZService {


	@Override
	public void initStatements() {
		this.setStatement(CWSJSRGZDao.class.getName());
	}

}
