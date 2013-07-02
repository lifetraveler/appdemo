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
import com.zoc.entity.act.CNNSDYLQ;
import com.zoc.service.act.CNNSDYLQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYLQ")
public class CNNSDYLQController extends ActController<CNNSDYLQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYLQController.class);

	private static final String DEFAULT_PAGE = "act/CNNSDYLQ";

	private static final String CONTROLLER_ID = "CNNSDYLQ";

	@Autowired
	private CNNSDYLQService CNNSDYLQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDYLQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险离休人员同比情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYLQ> list(Model model, CNNSDYLQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNNSDYLQService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYLQService.batchSave(SuperUtils.parseArray(data, CNNSDYLQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYLQ.class, CNNSDYLQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYLQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNNSDYLQService.list(entity), CONTROLLER_ID);
	}

}
