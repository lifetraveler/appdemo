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
import com.zoc.entity.act.CNSZZSZX;
import com.zoc.service.act.CNSZZSZXService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZZSZX")
public class CNSZZSZXController extends ActController<CNSZZSZX> {

	private static Logger logger = LoggerFactory.getLogger(CNSZZSZXController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZZSZX";

	@Autowired
	private CNSZZSZXService CNSZZSZXService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZZSZX");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "表3.17 年末参保职工平均个人帐户实账储存额情况（新人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZZSZX> list(Model model, CNSZZSZX entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZZSZXService.list(abstractList(entity, key, CNSZZSZX.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZZSZXService.batchSave(SuperUtils.parseArray(data, CNSZZSZX.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZZSZX.class, CNSZZSZXService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZZSZX entity) {
		abstractDownload(response, CNSZZSZXService.list(abstractList(entity, null, CNSZZSZX.class)), CONTROLLER_ID);
	}

}
