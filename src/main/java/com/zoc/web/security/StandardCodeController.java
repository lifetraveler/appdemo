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

import com.alibaba.fastjson.JSON;
import com.zoc.service.security.StandardCodeService;
import com.zoc.service.security.impl.ShiroDbRealm;

import com.zoc.common.page.SuperPage;
import com.zoc.entity.security.StandardCode;

/**   
* @author Super 
*/
@Controller
@RequestMapping(value = "standardcode")
public class StandardCodeController {
	
	private static final String MAIN_PAGE = "security/standardcode";
	
	@Autowired
	private StandardCodeService standardcodeService;
	
	private static Logger logger = LoggerFactory.getLogger(StandardCodeController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String main(){
		return MAIN_PAGE;
	}
	
	@RequiresPermissions(value = { "standardcode:list" })
	@RequestMapping(value = "/list",method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody SuperPage<StandardCode> list(SuperPage<StandardCode> page,@RequestParam(value = "code_name",required = false) String code_name){
		return standardcodeService.queryStandardCodeListByPage(null,page);
	}
	

}
