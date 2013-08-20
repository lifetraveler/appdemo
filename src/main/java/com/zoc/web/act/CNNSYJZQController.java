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
import com.zoc.entity.act.CNNSYJZQ;
import com.zoc.service.act.CNNSYJZQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSYJZQ")
public class CNNSYJZQController extends ActController<CNNSYJZQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSYJZQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSYJZQ";

	@Autowired
	private CNNSYJZQService CNNSYJZQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSYJZQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "基本养老保险基金收支情况决算表(企业)");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSYJZQ> list(Model model, CNNSYJZQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSYJZQService.list(abstractList(entity, key, CNNSYJZQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSYJZQService.batchSave(SuperUtils.parseArray(data, CNNSYJZQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSYJZQ.class, CNNSYJZQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSYJZQ entity) {
		abstractDownload(response, CNNSYJZQService.list(abstractList(entity, null, CNNSYJZQ.class)), CONTROLLER_ID);
	}

}
