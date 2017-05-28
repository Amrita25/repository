package com.springmvc.formvalidation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.formvalidation.model.Student;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String homepage(ModelMap model){

		
		return "welcome";

	}

	@RequestMapping(method=RequestMethod.GET , value="/addnew")
	public String newRegistration(ModelMap model){

		Student student = new Student();
		List<String> subjectlist = getList();
		model.addAttribute("student", student);
		model.addAttribute("subjectlist",subjectlist);
		return "enroll";

	}
	private List<String> getList() {
		List<String>subjectlist = new ArrayList();
		subjectlist.add("Scidence");
		subjectlist.add("History");
		return subjectlist;
	}

	@RequestMapping(method =RequestMethod.POST, value="/addnew/save")
	public String saveRegistration(@Valid Student student,BindingResult bindingResult,ModelMap model){

		if(bindingResult.hasErrors()) {
			model.addAttribute("subjectlist",getList());
			return "enroll";
		}

		model.addAttribute("msg", "Dear "+student.getFirstName()+" Your registration completed successfully");
		return "success";
	}

}
