package com.design.mapper;

import com.design.model.Profession;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionMapper {
    @Insert("insert into profession (name, department_id) values(#{name}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int saveProfession(Profession profession);
}
