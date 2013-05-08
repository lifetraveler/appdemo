package com.zoc.web.security;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.alibaba.fastjson.JSON;
import com.zoc.common.SuperUtils;
import com.zoc.entity.security.Menu;
import com.zoc.entity.security.Permission;
import com.zoc.service.security.PermissionService;
import com.zoc.service.security.impl.ShiroDbRealm;

/**
 * @author Super
 */
@Controller
public class MainController {

	@Autowired
	PermissionService permissionService;

	private static final String MAIN_PAGE = "security/main";

	private static Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return MAIN_PAGE;
	}

	@RequestMapping(value = "/permission/list", method = { RequestMethod.POST })
	public @ResponseBody
	List<Permission> list(@RequestParam(value = "permission", required = false) String permission) {
		List<Permission> permissions = permissionService.list(new Permission(permission));
		logger.debug("Permission List:{}", JSON.toJSONString(permissions));
		return permissions;
	}

}
