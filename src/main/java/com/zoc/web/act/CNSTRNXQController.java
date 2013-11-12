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
import com.zoc.entity.act.CNSTRNXQ;
import com.zoc.service.act.CNSTRNXQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTRNXQ")
public class CNSTRNXQController extends ActController<CNSTRNXQ> {

	private static Logger logger = LoggerFactory.getLogger(CNSTRNXQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSTRNXQ";

	@Autowired
	private CNSTRNXQService CNSTRNXQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTRNXQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "新退休人员人数情况");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTRNXQ> list(Model model, CNSTRNXQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSTRNXQService.list(abstractList(entity, key, CNSTRNXQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSTRNXQService.batchSave(SuperUtils.parseArray(data, CNSTRNXQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSTRNXQ.class, CNSTRNXQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSTRNXQ entity) {
		abstractDownload(response, CNSTRNXQService.list(abstractList(entity, null, CNSTRNXQ.class)), CONTROLLER_ID);
	}

}
