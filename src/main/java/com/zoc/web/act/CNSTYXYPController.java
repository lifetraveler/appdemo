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
import com.zoc.entity.act.CNSTYXYP;
import com.zoc.service.act.CNSTYXYPService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTYXYP")
public class CNSTYXYPController extends ActController<CNSTYXYP> {

	private static Logger logger = LoggerFactory.getLogger(CNSTYXYPController.class);

	private static final String DEFAULT_PAGE = "act/CN";

	private static final String CONTROLLER_ID = "CNSTYXYP";

	@Autowired
	private CNSTYXYPService CNSTYXYPService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTYXYP");
		model.addAttribute("UNIT", 2);
		model.addAttribute("TITLE", "表3.22 年新退休人员应发月平均养老金水平");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTYXYP> list(Model model, CNSTYXYP entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNSTYXYPService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSTYXYPService.batchSave(SuperUtils.parseArray(data, CNSTYXYP.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSTYXYP.class, CNSTYXYPService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSTYXYP entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNSTYXYPService.list(entity), CONTROLLER_ID);
	}

}
