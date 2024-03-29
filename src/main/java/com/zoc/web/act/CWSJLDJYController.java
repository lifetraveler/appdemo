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
import com.zoc.entity.act.CWSJLDJY;
import com.zoc.service.act.CWSJLDJYService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CWSJLDJY")
public class CWSJLDJYController extends ActController<CWSJLDJY> {

	private static Logger logger = LoggerFactory.getLogger(CWSJLDJYController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CWSJLDJY";

	@Autowired
	private CWSJLDJYService CWSJLDJYService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", SuperUtils.DEFAULT_YEAR);
		model.addAttribute("MENUID", "CWSJLDJY");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "劳动就业");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CWSJLDJY> list(Model model, CWSJLDJY entity, @RequestParam(value = "key", required = false) String key) {
		return CWSJLDJYService.list(abstractList(entity, key, CWSJLDJY.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CWSJLDJYService.batchSave(SuperUtils.parseArray(data, CWSJLDJY.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CWSJLDJY.class, CWSJLDJYService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CWSJLDJY entity) {
		abstractDownload(response, CWSJLDJYService.list(abstractList(entity, null, CWSJLDJY.class)), CONTROLLER_ID);
	}

}
