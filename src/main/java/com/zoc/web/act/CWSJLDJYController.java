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
import com.zoc.entity.act.CWSJLDJY;
import com.zoc.service.act.CWSJLDJYService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CWSJLDJY")
public class CWSJLDJYController extends ActController<CWSJLDJY> {

	private static Logger logger = LoggerFactory.getLogger(CWSJLDJYController.class);

	private static final String DEFAULT_PAGE = "act/CWSJLDJY";

	private static final String CONTROLLER_ID = "CWSJLDJY";

	@Autowired
	private CWSJLDJYService CWSJLDJYService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CWSJLDJY> list(Model model, CWSJLDJY entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CWSJLDJYService.list(entity);
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
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CWSJLDJYService.list(entity), CONTROLLER_ID);
	}

}
