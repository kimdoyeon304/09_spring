package com.project.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@ResponseBody
public class HomeController {

	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(HomeController.class);
	 * 
	 *//**
		 * Simply selects the home view to render by returning its name.
		 *//*
			 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
			 * home(Locale locale, Model model) {
			 * logger.info("Welcome home! The client locale is {}.", locale);
			 * 
			 * Date date = new Date(); DateFormat dateFormat =
			 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			 * 
			 * String formattedDate = dateFormat.format(date);
			 * 
			 * model.addAttribute("serverTime", formattedDate );
			 * 
			 * return "home"; }
			 */

	@GetMapping("/get.do")
	public String ajax() {
		System.out.println("fdsfs");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kor", "korea");
		map.put("us", "united states");

		return null;
	}
	
	@PostMapping("/post.do")
	public String record(HttpServletRequest request) {
		String str1 = request.getParameter("id");
		String str2 = request.getParameter("pwd");
		
		System.out.println(str1);
		System.out.println(str2);
		return null;
	}

}
