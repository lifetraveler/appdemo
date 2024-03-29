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
import com.zoc.entity.act.CNSZJNXX;
import com.zoc.service.act.CNSZJNXXService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZJNXX")
public class CNSZJNXXController extends ActController<CNSZJNXX> {

	private static Logger logger = LoggerFactory.getLogger(CNSZJNXXController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZJNXX";

	@Autowired
	private CNSZJNXXService CNSZJNXXService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZJNXX");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工人均缴费年限（含视同）情况（新人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZJNXX> list(Model model, CNSZJNXX entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZJNXXService.list(abstractList(entity, key, CNSZJNXX.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSZJNXXService.batchSave(SuperUtils.parseArray(data, CNSZJNXX.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZJNXX.class, CNSZJNXXService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZJNXX entity) {
		abstractDownload(response, CNSZJNXXService.list(abstractList(entity, null, CNSZJNXX.class)), CONTROLLER_ID);
	}

}
