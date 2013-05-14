package com.zoc.service.security.impl;

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
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.User;
import com.zoc.repository.security.MenuDao;
import com.zoc.repository.security.PermissionDao;
import com.zoc.repository.security.UserDao;
import com.zoc.service.security.MenuService;
import com.zoc.service.security.UserService;

@Service
public class MenuServiceImpl extends SuperServiceImpl<Menu, Long> implements MenuService {

	@Autowired
	MenuDao menuDao;

	@Override
	public void initStatements() {
		this.setStatement(MenuDao.class.getName());
	}
	
	
	/**
	 * 因为树有子节点，所以需要重载remove方法
	 */
	@Override
	@Transactional
	public void removeIncludeChildren(Menu menu) {
		this.remove(menu);
		List<Menu> menus = menuDao.listChildren(menu);
		for (Menu m : menus){
			this.removeIncludeChildren(m);
		}
	}


	@Override
	public Menu fetchByPermission(String menu_id) {
		return menuDao.fetchByPermission(menu_id);
	}


	@Override
	@Transactional
	public void add(Menu menu) {
		menuDao.insert(menu);
		for(Permission permission : menu.getPermissions()){
			menuDao.insertMenuPermission(menu.getMenu_id(), permission.getPermission());
		}
	}
	
	@Override
	@Transactional
	public void modify(Menu menu){
		menuDao.update(menu);
		//delete all then insert
		menuDao.deleteMenuPermission(menu.getMenu_id());
		for(Permission permission : menu.getPermissions()){
			menuDao.insertMenuPermission(menu.getMenu_id(), permission.getPermission());
		}
	}
	
	@Override
	@Transactional
	public void remove(Menu menu){
		menuDao.delete(menu);
		menuDao.deleteMenuPermission(menu.getMenu_id());
	}
	
	
	
	

}
