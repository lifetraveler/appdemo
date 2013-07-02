package com.zoc.web.siwc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "person")
public class PersonController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "perAdd")
	  public String main(Model model) {
	    return "/siwc/personAdd";
	  }
}
