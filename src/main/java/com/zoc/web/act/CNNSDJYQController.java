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
import com.zoc.entity.act.CNNSDJYQ;
import com.zoc.service.act.CNNSDJYQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDJYQ")
public class CNNSDJYQController extends ActController<CNNSDJYQ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDJYQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSDJYQ";

	@Autowired
	private CNNSDJYQService CNNSDJYQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNNSDJYQ");
		model.addAttribute("year", 2011);
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险情况综合表（机关事业）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDJYQ> list(Model model, CNNSDJYQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNNSDJYQService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDJYQService.batchSave(SuperUtils.parseArray(data, CNNSDJYQ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDJYQ.class, CNNSDJYQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDJYQ entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNNSDJYQService.list(entity), CONTROLLER_ID);
	}

}
