package com.design.controller;

import com.design.model.*;
import com.design.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private ProfessionService professionService;

    @RequestMapping("/save")
    public void saveStudent(Student student) {
        studentService.saveStudent(student);
    }

    @RequestMapping("/test")
    public void test() {
        Classroom classroom = new Classroom();
        classroom.setName("1408");
        classroom.setTeacher("张三");
        classroomService.saveClassroom(classroom);

        Department department = new Department();
        department.setName("土木工程");
        departmentService.saveDepartment(department);

        Dormitory dormitory = new Dormitory();
        dormitory.setDormitoryNum("222");
        dormitory.setFloor("2");
        dormitory.setSite("明德二号楼");
        dormitoryService.saveDormitory(dormitory);

        Profession profession = new Profession();
        profession.setDepartment(department);
        profession.setName("建筑专业");
        professionService.saveProfession(profession);

        Student student = new Student();
        student.setName("李四");
        student.setDepartment(department);
        student.setAddress("上海市");
        student.setClassroom(classroom);
        student.setDormitory(dormitory);
        student.setIdentityNum("142727199822347753");
        student.setPay(false);
        student.setStudentId("15344201");
        student.setTelephone("17521023548");
        student.setTuition("5000");
        student.setProfession(profession);
        studentService.saveStudent(student);

    }
	
}
