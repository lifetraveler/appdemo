package com.zoc.service.security;

import java.util.List;

import com.zoc.common.service.SuperService;
import com.zoc.entity.security.Menu;

public interface MenuService extends SuperService<Menu,Long>{
	
	
	public void removeIncludeChildren(Menu menu);
	
	public Menu fetchByPermission(String menu_id);
	
	public List<Menu> listByRoleId(String role_id);
	
	
}
