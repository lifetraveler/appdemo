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
import com.zoc.entity.act.CNNSDYHQ;
import com.zoc.service.act.CNNSDYHQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYHQ")
public class CNNSDYHQController extends ActController<CNNSDYHQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYHQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDYHQ";

	@Autowired
	private CNNSDYHQService CNNSDYHQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDYHQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险稽核清欠情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYHQ> list(Model model, CNNSDYHQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSDYHQService.list(abstractList(entity, key, CNNSDYHQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYHQService.batchSave(SuperUtils.parseArray(data, CNNSDYHQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYHQ.class, CNNSDYHQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYHQ entity) {
		abstractDownload(response, CNNSDYHQService.list(abstractList(entity, null, CNNSDYHQ.class)), CONTROLLER_ID);
	}

}
