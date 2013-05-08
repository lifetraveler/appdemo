package com.zoc.web.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**   
* @author Super 
*/
@Controller
@RequestMapping(value = "login")
public class LoginController {
	
	private static final String LOGIN_PAGE = "security/login";
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(){
		return LOGIN_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		return LOGIN_PAGE;
	}
	
	@RequestMapping(value = "/timeout", method = { RequestMethod.GET })
	public String timeout() {
		return LOGIN_PAGE;
	}

}
