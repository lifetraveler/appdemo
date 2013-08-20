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
import com.zoc.entity.act.CNNSQZCB;
import com.zoc.service.act.CNNSQZCBService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSQZCB")
public class CNNSQZCBController extends ActController<CNNSQZCB> {

	private static Logger logger = LoggerFactory.getLogger(CNNSQZCBController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSQZCB";

	@Autowired
	private CNNSQZCBService CNNSQZCBService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSQZCB");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "企业基本养老保险中央财政专项补助情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSQZCB> list(Model model, CNNSQZCB entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSQZCBService.list(abstractList(entity, key, CNNSQZCB.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSQZCBService.batchSave(SuperUtils.parseArray(data, CNNSQZCB.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSQZCB.class, CNNSQZCBService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSQZCB entity) {
		abstractDownload(response, CNNSQZCBService.list(abstractList(entity, null, CNNSQZCB.class)), CONTROLLER_ID);
	}

}
