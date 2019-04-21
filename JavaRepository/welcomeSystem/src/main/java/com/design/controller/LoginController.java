package com.design.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.design.model.Department;
import com.design.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.design.model.Student;
import com.design.service.StudentService;
import com.design.util.ImageUtil;

@Controller
public class LoginController {

    @Autowired
	private StudentService studentService;

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void login(HttpServletResponse response) {
		try {
            ImageUtil.createcaptcha();
            BufferedImage image = ImageUtil.createImage();
            //以流的方式返回给客户端
            response.setContentType("image/jpeg");
            ByteArrayOutputStream bt = new ByteArrayOutputStream();
            //将图片转换成字节流
            ImageIO.write(image,"jpeg",bt);
            //得到输出流，返回客户端
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bt.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public void showPage() {
        Department department = new Department();
        department.setName("Test");
        departmentService.saveDepartment(department);
        Student student = new Student();
        student.setName("Jason");
        student.setDepartment(department);
        studentService.saveStudent(student);
	}
}
