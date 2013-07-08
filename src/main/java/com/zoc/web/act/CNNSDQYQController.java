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
import com.zoc.entity.act.CNNSDQYQ;
import com.zoc.service.act.CNNSDQYQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDQYQ")
public class CNNSDQYQController extends ActController<CNNSDQYQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDQYQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDQYQ";

	@Autowired
	private CNNSDQYQService CNNSDQYQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNNSDQYQ");
		model.addAttribute("year", 2011);
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险情况综合表（企业）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDQYQ> list(Model model, CNNSDQYQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNNSDQYQService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDQYQService.batchSave(SuperUtils.parseArray(data, CNNSDQYQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDQYQ.class, CNNSDQYQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDQYQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNNSDQYQService.list(entity), CONTROLLER_ID);
	}

}
