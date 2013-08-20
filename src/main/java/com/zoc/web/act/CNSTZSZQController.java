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
import com.zoc.entity.act.CNSTZSZQ;
import com.zoc.service.act.CNSTZSZQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTZSZQ")
public class CNSTZSZQController extends ActController<CNSTZSZQ> {

	private static Logger logger = LoggerFactory.getLogger(CNSTZSZQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSTZSZQ";

	@Autowired
	private CNSTZSZQService CNSTZSZQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTZSZQ");
		model.addAttribute("UNIT", 2);
		model.addAttribute("TITLE", "表3.23 年末退休人员平均个人帐户实账储存额情况");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTZSZQ> list(Model model, CNSTZSZQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSTZSZQService.list(abstractList(entity, key, CNSTZSZQ.class));
	}
	
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSTZSZQService.batchSave(SuperUtils.parseArray(data, CNSTZSZQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSTZSZQ.class, CNSTZSZQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSTZSZQ entity) {
		abstractDownload(response, CNSTZSZQService.list(abstractList(entity, null, CNSTZSZQ.class)), CONTROLLER_ID);
	}

}
