package com.design.service.impl;

import com.design.mapper.DormitoryMapper;
import com.design.model.Dormitory;
import com.design.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public int saveDormitory(Dormitory dormitory) {
        return dormitoryMapper.saveDormitory(dormitory);
    }
}
