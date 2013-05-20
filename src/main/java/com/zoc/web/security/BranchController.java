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

import com.zoc.service.security.BranchService;

import com.zoc.common.SuperUtils;
import com.zoc.entity.security.Branch;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "branch")
public class BranchController {

	private static final String MAIN_PAGE = "security/branch";

	@Autowired
	private BranchService branchService;

	private static Logger logger = LoggerFactory.getLogger(BranchController.class);

	@RequestMapping(method = RequestMethod.GET)
	@RequiresPermissions(value = "branch:default")
	public String main() {
		return MAIN_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions(value = "branch:list")
	public @ResponseBody
	List<Branch> list() {
		return branchService.list(null);
	}
	

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions(value = "branch:save")
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		Branch branch = SuperUtils.parseObject(data, Branch.class);
		branchService.save(branch);
		return "保存成功";

	}
	
	@RequestMapping(value = "/remove", method = { RequestMethod.POST })
	@RequiresPermissions(value = "branch:remove")
	public @ResponseBody
	String remove(@RequestParam("data") String data){
		logger.debug(data);
		Branch branch = SuperUtils.parseObject(data, Branch.class);
		branchService.remove(branch);
		return "删除成功";
	}
	
	

}
