package com.zoc.web.act;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zoc.common.SuperUtils;
import com.zoc.entity.act.CNNSDDYQ;
import com.zoc.entity.act.CNSZZSZZ;
import com.zoc.service.act.CNSZZSZZService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZZSZZ")
public class CNSZZSZZController extends ActController<CNSZZSZZ> {

	private static Logger logger = LoggerFactory.getLogger(CNSZZSZZController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZZSZZ";

	@Autowired
	private CNSZZSZZService CNSZZSZZService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZZSZZ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "表3.16 年末参保职工平均个人帐户实账储存额情况（中人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZZSZZ> list(Model model, CNSZZSZZ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZZSZZService.list(abstractList(entity, key, CNSZZSZZ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSZZSZZService.batchSave(SuperUtils.parseArray(data, CNSZZSZZ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZZSZZ.class, CNSZZSZZService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZZSZZ entity) {
		abstractDownload(response, CNSZZSZZService.list(abstractList(entity, null, CNSZZSZZ.class)), CONTROLLER_ID);
	}

}
