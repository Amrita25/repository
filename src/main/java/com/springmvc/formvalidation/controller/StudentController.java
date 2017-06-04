package com.springmvc.formvalidation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.formvalidation.model.Student;
import com.springmvc.formvalidation.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	Logger logger = Logger.getLogger( StudentController.class.getName() );
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value={"/","/list","/remove/list"}, method=RequestMethod.GET)
	public String homepage(ModelMap model){

		List<Student> students=studentService.findAllStudents();
		model.addAttribute("students", students);
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
		subjectlist.add("Science");
		subjectlist.add("History");
		subjectlist.add("Physics");
		subjectlist.add("Maths");
		return subjectlist;
	}

	@RequestMapping(method =RequestMethod.POST,value ="/addnew")
	public String saveRegistration(@Valid Student student,BindingResult bindingResult,ModelMap model){

		if(bindingResult.hasErrors()) {
			model.addAttribute("subjectlist",getList());
			return "enroll";
		}
		logger.log(Level.SEVERE,"Hello :",student.getStudentId());
		studentService.saveStudent(student);
		model.addAttribute("msg", "Dear "+student.getFirstName()+" Your registration completed successfully");
		return "success";
	}
	
	@RequestMapping(method =RequestMethod.POST,value ="/update/addnew")
	public String updateRegistration(@Valid Student student,BindingResult bindingResult,ModelMap model){

		if(bindingResult.hasErrors()) {
			model.addAttribute("subjectlist",getList());
			return "enroll";
		}
		logger.log(Level.SEVERE,"Hello :",student.getStudentId());
		studentService.updateStudent(student);
		model.addAttribute("msg", "Dear "+student.getFirstName()+" Your registration completed successfully");
		return "success";
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String removeStudent(@PathVariable("id") long id,ModelMap model){
		if(studentService.removeStudent(id)){
			model.addAttribute("msg", "Removed sucessfully");
		}else{
			model.addAttribute("msg", "Something went Wrong !! :(");
		}
		return "success";

	}
	
	@RequestMapping(method=RequestMethod.GET,value="/update/{id}")
	public String updateStudent(@PathVariable("id") long id,ModelMap model){
		Student finalStudent = studentService.findEntity(id);
		logger.log(Level.SEVERE,"Update student :",id);
		model.addAttribute("student",finalStudent);
		model.addAttribute("subjectlist",getList());
		model.addAttribute("edit", true);
		return "enroll";
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
