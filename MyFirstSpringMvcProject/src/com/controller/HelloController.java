package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HelloController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloworld() {
		ModelAndView model1 = new ModelAndView("HelloPage");
		model1.addObject("msg","helloworld");
		return model1;
		
	}

}
