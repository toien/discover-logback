package com.toien.discover.logback.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/log")
public class LogController {
	
	private static Logger logger = LoggerFactory.getLogger(LogController.class);

	@RequestMapping("info/{num}")
	public ModelAndView addInfo(@PathVariable int num) {
		
		for(int i = 0; i < num; i++) {
			logger.info("request log info message {}", i);
		}
		
		return new ModelAndView("/index.jsp");
	}
	
	@RequestMapping("error")
	public ModelAndView makeError() {
		
		logger.error("request log error", new RuntimeException("This is a normal RuntimeException."));
		
		return new ModelAndView("/index.jsp");
	}
	
	@RequestMapping("longname")
	public ModelAndView aReallyReallyReallyReallyReallyReallyReallyReallyReallyLongMethod() {
		
		logger.info("request log from method with a really long name");
		
		return new ModelAndView("/index.jsp");
	}
}
