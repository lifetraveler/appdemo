package com.zoc.web.security;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoc.service.security.MenuService;
import com.zoc.service.security.StandardCodeService;
import com.zoc.service.security.UserService;
import com.zoc.service.security.impl.ShiroDbRealm;

import com.zoc.common.SuperUtils;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.StandardCode;
import com.zoc.entity.security.User;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {

	private static final String MAIN_PAGE = "security/menu";

	@Autowired
	private MenuService menuService;

	private static Logger logger = LoggerFactory.getLogger(MenuController.class);

	@RequestMapping(method = RequestMethod.GET)
	@RequiresPermissions(value = "menu:default")
	public String main() {
		return MAIN_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions(value = "menu:list")
	public @ResponseBody
	List<Menu> list() {
		return menuService.list(null);
	}
	
	@RequestMapping(value = "/fetchByPermission", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Menu fetchByPermission(@RequestParam("menu_id") String menu_id) {
		return menuService.fetchByPermission(menu_id);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions(value = "menu:save")
	public @ResponseBody
	void save(@RequestParam("data") String data) {
		logger.debug(data);
		Menu menu = SuperUtils.parseObject(data, Menu.class);
		menuService.save(menu, menu.getState());

	}
	
	@RequestMapping(value = "/remove", method = { RequestMethod.POST })
	@RequiresPermissions(value = "menu:remove")
	public @ResponseBody
	void remove(@RequestParam("data") String data){
		logger.debug(data);
		Menu menu = SuperUtils.parseObject(data, Menu.class);
		menuService.removeIncludeChildren(menu);
	}
	
	

}
