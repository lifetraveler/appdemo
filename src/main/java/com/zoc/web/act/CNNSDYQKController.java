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
import com.zoc.entity.act.CNNSDYQK;
import com.zoc.service.act.CNNSDYQKService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYQK")
public class CNNSDYQKController extends ActController<CNNSDYQK> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYQKController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDYQK";

	@Autowired
	private CNNSDYQKService CNNSDYQKService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDYQK");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险人均缴费工资、退休人员养老金、替代率情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYQK> list(Model model, CNNSDYQK entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSDYQKService.list(abstractList(entity, key, CNNSDYQK.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYQKService.batchSave(SuperUtils.parseArray(data, CNNSDYQK.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYQK.class, CNNSDYQKService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYQK entity) {
		abstractDownload(response, CNNSDYQKService.list(abstractList(entity, null, CNNSDYQK.class)), CONTROLLER_ID);
	}

}
