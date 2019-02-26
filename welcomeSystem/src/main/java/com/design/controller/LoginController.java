package com.design.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.design.model.Student;
import com.design.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String login() {
		ModelAndView mav = new ModelAndView("login");
		Student student = studentService.findStudentById(1);
		System.out.println(student.getName());
		return "login";
	}
}
