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
import com.zoc.entity.act.CNNSDYSF;
import com.zoc.service.act.CNNSDYSFService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYSF")
public class CNNSDYSFController extends ActController<CNNSDYSF> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYSFController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDYSF";

	@Autowired
	private CNNSDYSFService CNNSDYSFService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDYSF");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险基金收缴率、负担系数情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYSF> list(Model model, CNNSDYSF entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSDYSFService.list(abstractList(entity, key, CNNSDYSF.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYSFService.batchSave(SuperUtils.parseArray(data, CNNSDYSF.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYSF.class, CNNSDYSFService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYSF entity) {
		abstractDownload(response, CNNSDYSFService.list(abstractList(entity, null, CNNSDYSF.class)), CONTROLLER_ID);
	}

}
