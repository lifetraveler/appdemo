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
import com.zoc.entity.act.CNSZJJSQ;
import com.zoc.service.act.CNSZJJSQService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZJJSQ")
public class CNSZJJSQController extends ActController<CNSZJJSQ> {

	private static Logger logger = LoggerFactory.getLogger(CNSZJJSQController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZJJSQ";

	@Autowired
	private CNSZJJSQService CNSZJJSQService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZJJSQ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工人均缴费基数情况");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZJJSQ> list(Model model, CNSZJJSQ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZJJSQService.list(abstractList(entity, key, CNSZJJSQ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZJJSQService.batchSave(SuperUtils.parseArray(data, CNSZJJSQ.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZJJSQ.class, CNSZJJSQService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZJJSQ entity) {
		abstractDownload(response, CNSZJJSQService.list(abstractList(entity, null, CNSZJJSQ.class)), CONTROLLER_ID);
	}

}
