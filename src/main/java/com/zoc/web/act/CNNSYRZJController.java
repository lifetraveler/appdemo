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
import com.zoc.entity.act.CNNSYRZJ;
import com.zoc.service.act.CNNSYRZJService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSYRZJ")
public class CNNSYRZJController extends ActController<CNNSYRZJ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSYRZJController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSYRZJ";

	@Autowired
	private CNNSYRZJService CNNSYRZJService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSYRZJ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "基本养老保险基金收入同比增减情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSYRZJ> list(Model model, CNNSYRZJ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSYRZJService.list(abstractList(entity, key, CNNSYRZJ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSYRZJService.batchSave(SuperUtils.parseArray(data, CNNSYRZJ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSYRZJ.class, CNNSYRZJService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSYRZJ entity) {
		abstractDownload(response, CNNSYRZJService.list(abstractList(entity, null, CNNSYRZJ.class)), CONTROLLER_ID);
	}

}
