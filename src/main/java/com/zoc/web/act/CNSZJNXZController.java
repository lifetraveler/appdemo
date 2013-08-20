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
import com.zoc.entity.act.CNSZJNXZ;
import com.zoc.service.act.CNSZJNXZService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZJNXZ")
public class CNSZJNXZController extends ActController<CNSZJNXZ> {

	private static Logger logger = LoggerFactory.getLogger(CNSZJNXZController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZJNXZ";

	@Autowired
	private CNSZJNXZService CNSZJNXZService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZJNXZ");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末参保职工人均缴费年限（含视同）情况（中人）");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZJNXZ> list(Model model, CNSZJNXZ entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZJNXZService.list(abstractList(entity, key, CNSZJNXZ.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZJNXZService.batchSave(SuperUtils.parseArray(data, CNSZJNXZ.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZJNXZ.class, CNSZJNXZService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZJNXZ entity) {
		abstractDownload(response, CNSZJNXZService.list(abstractList(entity, null, CNSZJNXZ.class)), CONTROLLER_ID);
	}

}
