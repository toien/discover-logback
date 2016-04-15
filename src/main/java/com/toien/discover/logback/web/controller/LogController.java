package com.toien.discover.logback.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.toien.discover.logback.module.number.NumberCruncher;

@Controller
@RequestMapping("/log")
public class LogController {

	private static Logger logger = LoggerFactory.getLogger(LogController.class);
	
	private NumberCruncher numberCruncher = new NumberCruncher();

	@RequestMapping("info/{num}")
	public ModelAndView addInfo(@PathVariable int num) {

		for (int i = 0; i < num; i++) {
			logger.info("request log info message {}", i);
		}

		return new ModelAndView("/index.jsp");
	}

	@RequestMapping("error")
	public ModelAndView makeError() {

		logger.error("request log error",
				new RuntimeException("This is a normal RuntimeException."));

		return new ModelAndView("/index.jsp");
	}

	@RequestMapping("longname")
	public ModelAndView aReallyReallyReallyReallyReallyReallyReallyReallyReallyLongMethod() {

		logger.info("request log from method with a really long name");

		return new ModelAndView("/index.jsp");
	}

	@RequestMapping("factor/{num}")
	public ModelAndView factor(@PathVariable int num, HttpServletRequest request,
			HttpServletResponse response) {

		int[] rs = numberCruncher.factor(num);
		
		return new ModelAndView("/index.jsp");
	}
}
