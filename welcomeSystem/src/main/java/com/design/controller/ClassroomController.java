package com.design.controller;

import com.design.model.Classroom;
import com.design.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @RequestMapping("/save")
    public int saveClassroom(Classroom classroom) {
        return classroomService.saveClassroom(classroom);
    }
}
