package com.zoc.service.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.repository.security.MenuDao;
import com.zoc.service.security.MenuService;

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
		for (Menu m : menus) {
			this.removeIncludeChildren(m);
		}
	}

	@Override
	public Menu fetchByPermission(String menu_id) {
		return menuDao.fetchByPermission(menu_id);
	}

	@Override
	public List<Menu> listByRoleId(String role_id) {
		return menuDao.listByRoleId(role_id);
	}

	@Override
	@Transactional
	public void add(Menu menu) {
		menuDao.insert(menu);
		for (Permission permission : menu.getPermissions()) {
			menuDao.insertMenuPermission(menu.getMenu_id(), permission.getPermission());
		}
	}

	@Override
	@Transactional
	public void modify(Menu menu) {
		menuDao.update(menu);
		// delete all then insert
		menuDao.deleteMenuPermission(menu.getMenu_id());
		for (Permission permission : menu.getPermissions()) {
			menuDao.insertMenuPermission(menu.getMenu_id(), permission.getPermission());
		}
	}

	@Override
	@Transactional
	public void remove(Menu menu) {
		menuDao.delete(menu);
		menuDao.deleteMenuPermission(menu.getMenu_id());
	}

	/**
	 * @param menu
	 * 更新的是在角色选择之后，角色所带的菜单及该角色所选择的权限，不是上面的菜单权限更新
	 */
	@Transactional
	public void modifyWithRolePermission(Menu menu){
		
	}
}
