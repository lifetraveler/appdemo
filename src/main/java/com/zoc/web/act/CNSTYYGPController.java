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
import com.zoc.entity.act.CNSTYYGP;
import com.zoc.service.act.CNSTYYGPService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTYYGP")
public class CNSTYYGPController extends ActController<CNSTYYGP> {

	private static Logger logger = LoggerFactory.getLogger(CNSTYYGPController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSTYYGP";

	@Autowired
	private CNSTYYGPService CNSTYYGPService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTYYGP");
		model.addAttribute("UNIT", 2);
		model.addAttribute("TITLE", "年退休人员应发实账个人账户月平均养老金水平");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTYYGP> list(Model model, CNSTYYGP entity, @RequestParam(value = "key", required = false) String key) {
		return CNSTYYGPService.list(abstractList(entity, key, CNSTYYGP.class));
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
		abstractDownload(response, CNSTYYGPService.list(abstractList(entity, null, CNSTYYGP.class)), CONTROLLER_ID);
	}

}
