package com.design.service.impl;

import com.design.mapper.ProfessionMapper;
import com.design.model.Profession;
import com.design.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public int saveProfession(Profession profession) {
        return professionMapper.saveProfession(profession);
    }
}
