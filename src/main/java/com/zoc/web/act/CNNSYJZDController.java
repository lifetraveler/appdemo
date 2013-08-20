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
import com.zoc.entity.act.CNNSYJZD;
import com.zoc.service.act.CNNSYJZDService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSYJZD")
public class CNNSYJZDController extends ActController<CNNSYJZD> {

	private static Logger logger = LoggerFactory.getLogger(CNNSYJZDController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSYJZD";

	@Autowired
	private CNNSYJZDService CNNSYJZDService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSYJZD");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "基本养老保险基金收支情况决算表(大口径)");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSYJZD> list(Model model, CNNSYJZD entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSYJZDService.list(abstractList(entity, key, CNNSYJZD.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSYJZDService.batchSave(SuperUtils.parseArray(data, CNNSYJZD.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSYJZD.class, CNNSYJZDService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSYJZD entity) {
		abstractDownload(response, CNNSYJZDService.list(abstractList(entity, null, CNNSYJZD.class)), CONTROLLER_ID);
	}

}
