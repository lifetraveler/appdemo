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
import com.zoc.entity.act.CNNSDYTQ;
import com.zoc.service.act.CNNSDYTQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYTQ")
public class CNNSDYTQController extends ActController<CNNSDYTQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYTQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDYTQ";

	@Autowired
	private CNNSDYTQService CNNSDYTQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNNSDYTQ");
		model.addAttribute("year", 2011);
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险离退休人员同比情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYTQ> list(Model model, CNNSDYTQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNNSDYTQService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYTQService.batchSave(SuperUtils.parseArray(data, CNNSDYTQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYTQ.class, CNNSDYTQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYTQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNNSDYTQService.list(entity), CONTROLLER_ID);
	}

}
