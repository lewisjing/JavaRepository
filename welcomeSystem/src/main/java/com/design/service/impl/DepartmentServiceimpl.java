package com.design.service.impl;

import com.design.mapper.DepartmentMapper;
import com.design.model.Department;
import com.design.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceimpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    public void saveDepartment(Department department) {
        departmentMapper.saveDepartment(department);
    }
}
