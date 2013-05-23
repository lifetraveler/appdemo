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
import com.zoc.entity.act.CWSJHGJJ;
import com.zoc.service.act.CWSJHGJJService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CWSJHGJJ")
public class CWSJHGJJController extends ActController<CWSJHGJJ> {

	private static Logger logger = LoggerFactory.getLogger(CWSJHGJJController.class);

	private static final String DEFAULT_PAGE = "act/CWSJHGJJ";

	private static final String CONTROLLER_ID = "CWSJHGJJ";

	@Autowired
	private CWSJHGJJService CWSJHGJJService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CWSJHGJJ> list(Model model, CWSJHGJJ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CWSJHGJJService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CWSJHGJJService.batchSave(SuperUtils.parseArray(data, CWSJHGJJ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CWSJHGJJ.class, CWSJHGJJService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CWSJHGJJ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CWSJHGJJService.list(entity), CONTROLLER_ID);
	}

}
