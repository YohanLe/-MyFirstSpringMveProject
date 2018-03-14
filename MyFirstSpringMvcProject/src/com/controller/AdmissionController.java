package com.controller;

import java.util.ArrayList;

import org.hibernate.validator.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javasrc.Registration;
import javasrc.Student;

@Controller
public class AdmissionController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"studentSkills"});
	}
	
	@RequestMapping(value = "/AdmissionForm.html" , method = RequestMethod.GET)
	public ModelAndView GetAdmissionForm() {
		
		ModelAndView model1 = new ModelAndView("AdmissionForm");
		return model1;
	}
	
	@RequestMapping(value= "/submitAdmissionForm.html" , method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentname") String name , @RequestParam("studenthobby") String hoby){
		ModelAndView model1 = new ModelAndView("AdmissionSucess");
		model1.addObject("msg", " detail submitted by" + name + " " + hoby);
		return model1;
		
	}
	
	
	@RequestMapping(value = "/AdmissionForm1.html" , method = RequestMethod.GET)
	public ModelAndView GetAdmissionForm1() {
		
		ModelAndView model1 = new ModelAndView("AdmissionForm1");
		return model1;
	}
	
	@RequestMapping(value = "/Home.html" , method = RequestMethod.GET)
	public ModelAndView Gethome() {
		
		ModelAndView model1 = new ModelAndView("Home");
		return model1;
	}
	
	
	// Registration
	
	@RequestMapping(value = "/Registration.html" , method = RequestMethod.GET)
	public ModelAndView GetRegistration() {
		
		ModelAndView model1 = new ModelAndView("Registration");
		return model1;
	}
	@RequestMapping(value= "/submitRegistration.html" , method = RequestMethod.POST)
	public ModelAndView submitRegistration(@ModelAttribute("registration1") Registration registration1, BindingResult results){
		if(results.hasErrors()){
			ModelAndView model1 = new ModelAndView("registration1");
			return model1;
		}
			ModelAndView model1 = new ModelAndView("RegistrationSucess");
			return model1;
		}
	
		
	//@RequestMapping(value= "/submitAdmissionForm1.html" , method = RequestMethod.POST)
//	public ModelAndView submitAdmissionForm1(@RequestParam("studentname") String name , @RequestParam("studenthobby") String hobby){
//		
//		Student student1 = new Student();
//		student1.setStudentname(name);
//		student1.setStudenthobby(hobby);@Valid
	
	@RequestMapping(value= "/submitAdmissionForm1.html" , method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm1(@ModelAttribute("student1") Student student1, BindingResult results){
		
		if(results.hasErrors()){
			ModelAndView model1 = new ModelAndView("AdmissionForm1");
			return model1;
		}
		
		ModelAndView model1 = new ModelAndView("AdmissionSucess1");
		return model1;
		
	}
	@ModelAttribute
	public void addingcommonobject(Model model1) {
		model1.addAttribute("headermessage", " This is my new Spring Mvc project for library management");
	}
	
	// This is a method used for webservice
	
	@ResponseBody
	@RequestMapping(value="/student", method= RequestMethod.GET)
	public ArrayList<Student> getStudentsList(){
		
		Student student1 = new Student();
		student1.setStudentname("Yohan");
		
		Student student2 = new Student();
		student2.setStudentname("Mintamir");
		
		Student student3 = new Student();
		student3.setStudentname("Our kid");
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);
		
		return studentsList;
	}
	
	

}
