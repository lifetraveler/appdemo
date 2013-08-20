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
import com.zoc.entity.act.CNSZRRSX;
import com.zoc.service.act.CNSZRRSXService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZRRSX")
public class CNSZRRSXController extends ActController<CNSZRRSX> {

	private static Logger logger = LoggerFactory.getLogger(CNSZRRSXController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZRRSX";

	@Autowired
	private CNSZRRSXService CNSZRRSXService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZRRSX");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工人数情况（新人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZRRSX> list(Model model, CNSZRRSX entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZRRSXService.list(abstractList(entity, key, CNSZRRSX.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZRRSXService.batchSave(SuperUtils.parseArray(data, CNSZRRSX.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZRRSX.class, CNSZRRSXService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZRRSX entity) {
		abstractDownload(response, CNSZRRSXService.list(abstractList(entity, null, CNSZRRSX.class)), CONTROLLER_ID);
	}

}
