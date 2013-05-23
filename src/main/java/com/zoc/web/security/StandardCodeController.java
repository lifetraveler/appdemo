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

import com.zoc.service.security.StandardCodeService;
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
	public String main() {
		return MAIN_PAGE;
	}

	@RequiresPermissions(value = { "standardcode:listByPage" })
	@RequestMapping(value = "/listByPage", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	SuperPage<StandardCode> listByPage(SuperPage<StandardCode> page,
			@RequestParam(value = "code_name", required = false) String code_name) {
		return standardcodeService.listByPage(null, page);
	}

	@RequiresPermissions(value = { "standardcode:list" })
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<StandardCode> list(SuperPage<StandardCode> page,
			@RequestParam(value = "code_name", required = false) String code_name) {
		return standardcodeService.list(new StandardCode(code_name));
	}

}
