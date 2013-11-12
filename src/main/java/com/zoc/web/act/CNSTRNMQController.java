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
import com.zoc.entity.act.CNSTRNMQ;
import com.zoc.service.act.CNSTRNMQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSTRNMQ")
public class CNSTRNMQController extends ActController<CNSTRNMQ> {

	private static Logger logger = LoggerFactory.getLogger(CNSTRNMQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSTRNMQ";

	@Autowired
	private CNSTRNMQService CNSTRNMQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSTRNMQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末退休人员人数情况");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSTRNMQ> list(Model model, CNSTRNMQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSTRNMQService.list(abstractList(entity, key, CNSTRNMQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSTRNMQService.batchSave(SuperUtils.parseArray(data, CNSTRNMQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSTRNMQ.class, CNSTRNMQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSTRNMQ entity) {
		abstractDownload(response, CNSTRNMQService.list(abstractList(entity, null, CNSTRNMQ.class)), CONTROLLER_ID);
	}

}
