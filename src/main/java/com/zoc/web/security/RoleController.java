package com.zoc.web.security;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoc.service.security.RoleService;
import com.zoc.common.SuperUtils;
import com.zoc.entity.security.Role;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "role")
public class RoleController {

	private static final String MAIN_PAGE = "security/role";

	@Autowired
	private RoleService roleService;

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return MAIN_PAGE;
	}

	@RequiresPermissions(value = "role:list")
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<Role> list() {
		return roleService.list(null);
	}

	@RequiresPermissions(value = "role:save")
	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		Role role = SuperUtils.parseObject(data, Role.class);
		if(SuperUtils.isNullOrEmpty(role.getRole_id()))
			return "角色代码不能为空";
		try{
			roleService.save(role);
			return "更新成功";
		}catch(Exception e){
			logger.debug("捕获到了");
			e.printStackTrace();
			return "更新失败";
		}
		
	}

}
