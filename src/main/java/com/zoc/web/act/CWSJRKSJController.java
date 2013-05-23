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
import com.zoc.entity.act.CWSJRKSJ;
import com.zoc.service.act.CWSJRKSJService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CWSJRKSJ")
public class CWSJRKSJController extends ActController<CWSJRKSJ> {

	private static Logger logger = LoggerFactory.getLogger(CWSJRKSJController.class);

	private static final String DEFAULT_PAGE = "act/CWSJRKSJ";

	private static final String CONTROLLER_ID = "CWSJRKSJ";

	@Autowired
	private CWSJRKSJService CWSJRKSJService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CWSJRKSJ> list(Model model, CWSJRKSJ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CWSJRKSJService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CWSJRKSJService.batchSave(SuperUtils.parseArray(data, CWSJRKSJ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CWSJRKSJ.class, CWSJRKSJService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CWSJRKSJ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CWSJRKSJService.list(entity), CONTROLLER_ID);
	}

}
