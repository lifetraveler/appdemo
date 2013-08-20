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
import com.zoc.entity.act.CNSZRXCB;
import com.zoc.service.act.CNSZRXCBService;

/**
 * @author Super
 */
@Controller
@RequestMapping(value = "CNSZRXCB")
public class CNSZRXCBController extends ActController<CNSZRXCB> {

	private static Logger logger = LoggerFactory.getLogger(CNSZRXCBController.class);

	private static final String DEFAULT_PAGE = "act/ACT";

	private static final String CONTROLLER_ID = "CNSZRXCB";

	@Autowired
	private CNSZRXCBService CNSZRXCBService;

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("LOCATION", SuperUtils.getSubjectUser().getLocation());
		model.addAttribute("MENUID", "CNSZRXCB");
		model.addAttribute("UNIT", 0);
		model.addAttribute("TITLE", "年末新参保职工人数情况");
		return DEFAULT_PAGE;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<CNSZRXCB> list(Model model, CNSZRXCB entity, @RequestParam(value = "key", required = false) String key) {
		return CNSZRXCBService.list(abstractList(entity, key, CNSZRXCB.class));
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody
	String save(@RequestParam("data") String data) {
		logger.debug(data);
		try{
		CNSZRXCBService.batchSave(SuperUtils.parseArray(data, CNSZRXCB.class));
		return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody
	String upload(MultipartHttpServletRequest request) {
		return abstractUpload(request, CONTROLLER_ID, CNSZRXCB.class, CNSZRXCBService);

	}

	@RequestMapping(value = "/download", method = { RequestMethod.GET })
	public @ResponseBody
	void download(HttpServletResponse response, CNSZRXCB entity) {
		abstractDownload(response, CNSZRXCBService.list(abstractList(entity, null, CNSZRXCB.class)), CONTROLLER_ID);
	}

}
