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
import com.zoc.entity.act.CNNSDYGQ;
import com.zoc.service.act.CNNSDYGQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYGQ")
public class CNNSDYGQController extends ActController<CNNSDYGQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYGQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDYGQ";

	@Autowired
	private CNNSDYGQService CNNSDYGQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDYGQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险个人账户累计记账额同比情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYGQ> list(Model model, CNNSDYGQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSDYGQService.list(abstractList(entity, key, CNNSDYGQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYGQService.batchSave(SuperUtils.parseArray(data, CNNSDYGQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYGQ.class, CNNSDYGQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYGQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNNSDYGQService.list(abstractList(entity, null, CNNSDYGQ.class)), CONTROLLER_ID);
	}

}
