package com.zoc.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoc.common.service.impl.SuperServiceImpl;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.entity.security.Role;
import com.zoc.repository.security.RoleDao;
import com.zoc.service.security.RoleService;

@Service
public class RoleServiceImpl extends SuperServiceImpl<Role, Long> implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public void initStatements() {
		this.setStatement(RoleDao.class.getName());
	}

	@Override
	public void modify(Role role) {
		roleDao.update(role);
		roleDao.deleteRoleMenuPermissionByRoleId(role.getRole_id());
		addRoleMenuPermission(role);
	}

	@Override
	public void add(Role role) {
		roleDao.insert(role);
		addRoleMenuPermission(role);
	}

	public void addRoleMenuPermission(Role role) {
		if (role.getMenus() != null) {
			for (Menu menu : role.getMenus()) {
				if (menu.getPermissions() != null) {
					for (Permission permission : menu.getPermissions()) {
						roleDao.insertRoleMenuPermission(role.getRole_id(), menu.getMenu_id(),
								permission.getPermission());
					}
				}
			}
		}
	}
}
