package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javasrc.Student;
import javasrc.Transaction;

@Controller
public class TransactionController {
	
	
	
	@RequestMapping(value = "/Transaction.html" , method = RequestMethod.GET)
	public ModelAndView GetTransaction() {
		
		ModelAndView model1 = new ModelAndView("Transaction");
		return model1;
	}
	
	
	@RequestMapping(value= "/submitTransaction.html" , method = RequestMethod.POST)
	public ModelAndView submitTransaction(@ModelAttribute("Transaction1") Transaction Transaction1, BindingResult results){
		
		if(results.hasErrors()){
			ModelAndView model1 = new ModelAndView("Transaction");
			return model1;
		}
		
		ModelAndView model1 = new ModelAndView("TransactionSucess");
		return model1;
		
	}

}
