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
import com.zoc.entity.act.CNSZZKZX;
import com.zoc.service.act.CNSZZKZXService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZZKZX")
public class CNSZZKZXController extends ActController<CNSZZKZX> {

	private static Logger logger = LoggerFactory.getLogger(CNSZZKZXController.class);

	private static final String DEFAULT_PAGE = "act/CN";

	private static final String CONTROLLER_ID = "CNSZZKZX";

	@Autowired
	private CNSZZKZXService CNSZZKZXService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZZKZX");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "表3.15 年末参保职工平均个人帐户空账储存额情况（新人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZZKZX> list(Model model, CNSZZKZX entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNSZZKZXService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNSZZKZXService.batchSave(SuperUtils.parseArray(data, CNSZZKZX.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZZKZX.class, CNSZZKZXService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZZKZX entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNSZZKZXService.list(entity), CONTROLLER_ID);
	}

}
