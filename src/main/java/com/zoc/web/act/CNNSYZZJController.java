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
import com.zoc.entity.act.CNNSYZZJ;
import com.zoc.service.act.CNNSYZZJService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSYZZJ")
public class CNNSYZZJController extends ActController<CNNSYZZJ> {

	private static Logger logger = LoggerFactory.getLogger(CNNSYZZJController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNNSYZZJ";

	@Autowired
	private CNNSYZZJService CNNSYZZJService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSYZZJ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "基本养老保险基金总支出及财政到帐同比增减情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSYZZJ> list(Model model, CNNSYZZJ entity, @RequestParam(value = "key", required = false) String key) {
		return CNNSYZZJService.list(abstractList(entity, key, CNNSYZZJ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSYZZJService.batchSave(SuperUtils.parseArray(data, CNNSYZZJ.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSYZZJ.class, CNNSYZZJService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSYZZJ entity) {
		abstractDownload(response, CNNSYZZJService.list(abstractList(entity, null, CNNSYZZJ.class)), CONTROLLER_ID);
	}

}
