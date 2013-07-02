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
import com.zoc.entity.act.CNNSDYCN;
import com.zoc.service.act.CNNSDYCNService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNNSDYCN")
public class CNNSDYCNController extends ActController<CNNSDYCN> {

	private static Logger logger = LoggerFactory.getLogger(CNNSDYCNController.class);

	private static final String DEFAULT_PAGE = "act/CNNSDYCN";

	private static final String CONTROLLER_ID = "CNNSDYCN";

	@Autowired
	private CNNSDYCNService CNNSDYCNService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("location", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("year", 2011);
		model.addAttribute("MENUID", "CNNSDYCN");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "分地区基本养老保险参保农民工同比情况表");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNNSDYCN> list(Model model, CNNSDYCN entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		return CNNSDYCNService.list(entity);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		CNNSDYCNService.batchSave(SuperUtils.parseArray(data, CNNSDYCN.class));
		return "save success!";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNNSDYCN.class, CNNSDYCNService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNNSDYCN entity) {
		entity.setLocation(SuperUtils.getSubjectUser().getLocation());
		abstractDownload(response, CNNSDYCNService.list(entity), CONTROLLER_ID);
	}

}
