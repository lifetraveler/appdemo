package com.zoc.web.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoc.common.SuperUtils;
import com.zoc.entity.security.Lov;
import com.zoc.entity.security.Permission;
import com.zoc.service.security.PermissionService;

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

	@RequestMapping(value = "/lov/{lov_id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String lov(@PathVariable String lov_id,Model model) {
		Lov lov = new Lov();
		lov.setLov_id(lov_id);
		Map<String,String> fields = new HashMap<String,String>();
		//需要后期完善
		if(StringUtils.equals(lov_id, "lov_branch")){
			fields.put("branch_code", "机构代码");
			fields.put("branch_name", "机构名称");
			lov.setFields(fields);
			lov.setLov_url("branch/list");
		}else if(StringUtils.equals(lov_id, "lov_role")){
			fields.put("role_id", "角色代码");
			fields.put("role_desc", "角色名称");
			lov.setFields(fields);
			lov.setLov_url("role/list");
		}
		model.addAttribute("lov_attr", lov);
		return "security/lov";
	}

	@RequestMapping(value = "/permission/list", method = { RequestMethod.POST })
	public @ResponseBody
	List<Permission> list(@RequestParam(value = "permission", required = false) String permission) {
		List<Permission> permissions = permissionService.list(new Permission(permission));
		return permissions;
	}

	@RequestMapping(value = "/permission/listPermissionByRoleIdMenuId", method = { RequestMethod.POST })
	public @ResponseBody
	List<Permission> list(@RequestParam(value = "menu_id", required = true) String menu_id,
			@RequestParam(value = "role_id", required = true) String role_id) {
		return permissionService.listPermissionByRoleIdMenuId(menu_id, role_id);
	}

	@RequestMapping(value = "/YQNRKYCQ", method = { RequestMethod.GET })
	public String sss() {
		return "/act/YQNRKYCQ";
	}

}
