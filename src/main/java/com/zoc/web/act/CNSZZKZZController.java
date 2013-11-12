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
import com.zoc.entity.act.CNSZZKZZ;
import com.zoc.service.act.CNSZZKZZService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZZKZZ")
public class CNSZZKZZController extends ActController<CNSZZKZZ> {

	private static Logger logger = LoggerFactory.getLogger(CNSZZKZZController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZZKZZ";

	@Autowired
	private CNSZZKZZService CNSZZKZZService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZZKZZ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工平均个人帐户空账储存额情况（中人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZZKZZ> list(Model model, CNSZZKZZ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZZKZZService.list(abstractList(entity, key, CNSZZKZZ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSZZKZZService.batchSave(SuperUtils.parseArray(data, CNSZZKZZ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZZKZZ.class, CNSZZKZZService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZZKZZ entity) {
		abstractDownload(response, CNSZZKZZService.list(abstractList(entity, null, CNSZZKZZ.class)), CONTROLLER_ID);
	}

}
