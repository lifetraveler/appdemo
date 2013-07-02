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
import com.zoc.entity.act.CNSTYYGP;
import com.zoc.service.act.CNSTYYGPService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTYYGP")
public class CNSTYYGPController extends ActController<CNSTYYGP> {

	private static Logger logger = LoggerFactory.getLogger(CNSTYYGPController.class);

	private static final String DEFAULT_PAGE = "act/CN";

	private static final String CONTROLLER_ID = "CNSTYYGP";

	@Autowired
	private CNSTYYGPService CNSTYYGPService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTYYGP");
		model.addAttribute("UNIT", 2);
		model.addAttribute("TITLE", "表3.21 年退休人员应发实账个人账户月平均养老金水平");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTYYGP> list(Model model, CNSTYYGP entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNSTYYGPService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSTYYGPService.batchSave(SuperUtils.parseArray(data, CNSTYYGP.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSTYYGP.class, CNSTYYGPService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSTYYGP entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNSTYYGPService.list(entity), CONTROLLER_ID);
	}

}