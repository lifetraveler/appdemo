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
import com.zoc.entity.act.CNSTZKZQ;
import com.zoc.service.act.CNSTZKZQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTZKZQ")
public class CNSTZKZQController extends ActController<CNSTZKZQ> {

	private static Logger logger = LoggerFactory.getLogger(CNSTZKZQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSTZKZQ";

	@Autowired
	private CNSTZKZQService CNSTZKZQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTZKZQ");
		model.addAttribute("UNIT", 2);
		model.addAttribute("TITLE", "年末退休人员平均个人帐户空账储存额情况");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTZKZQ> list(Model model, CNSTZKZQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSTZKZQService.list(abstractList(entity, key, CNSTZKZQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSTZKZQService.batchSave(SuperUtils.parseArray(data, CNSTZKZQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSTZKZQ.class, CNSTZKZQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSTZKZQ entity) {
		abstractDownload(response, CNSTZKZQService.list(abstractList(entity, null, CNSTZKZQ.class)), CONTROLLER_ID);
	}

}
