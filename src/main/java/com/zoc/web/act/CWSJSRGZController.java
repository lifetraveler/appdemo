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
import com.zoc.entity.act.CWSJSRGZ;
import com.zoc.service.act.CWSJSRGZService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CWSJSRGZ")
public class CWSJSRGZController extends ActController<CWSJSRGZ> {

	private static Logger logger = LoggerFactory.getLogger(CWSJSRGZController.class);

	private static final String DEFAULT_PAGE = "act/CWSJSRGZ";

	private static final String CONTROLLER_ID = "CWSJSRGZ";

	@Autowired
	private CWSJSRGZService CWSJSRGZService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CWSJSRGZ> list(Model model, CWSJSRGZ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CWSJSRGZService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CWSJSRGZService.batchSave(SuperUtils.parseArray(data, CWSJSRGZ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CWSJSRGZ.class, CWSJSRGZService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CWSJSRGZ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CWSJSRGZService.list(entity), CONTROLLER_ID);
	}

}
