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
import com.zoc.entity.act.CNNSDYSQ;
import com.zoc.service.act.CNNSDYSQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYSQ")
public class CNNSDYSQController extends ActController<CNNSDYSQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYSQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDYSQ";

	@Autowired
	private CNNSDYSQService CNNSDYSQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", SuperUtils.DEFAULT_YEAR);
		model.addAttribute("MENUID", "CNNSDYSQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险当期非正常退休及死亡人员情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYSQ> list(Model model, CNNSDYSQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSDYSQService.list(abstractList(entity, key, CNNSDYSQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYSQService.batchSave(SuperUtils.parseArray(data, CNNSDYSQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYSQ.class, CNNSDYSQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYSQ entity) {
		abstractDownload(response, CNNSDYSQService.list(abstractList(entity, null, CNNSDYSQ.class)), CONTROLLER_ID);
	}

}
