package com.design.controller;

import com.design.model.Department;
import com.design.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/save")
    public void saveDepartment(Department department) {
        departmentService.saveDepartment(department);
    }
}
