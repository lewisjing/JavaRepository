package com.design.service.impl;

import com.design.mapper.ClassroomMapper;
import com.design.model.Classroom;
import com.design.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService{

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public int saveClassroom(Classroom classroom) {
        return classroomMapper.saveClassroom(classroom);
    }
}
