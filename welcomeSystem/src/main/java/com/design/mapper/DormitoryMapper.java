package com.design.mapper;

import com.design.model.Dormitory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryMapper {
    @Insert("insert into dormitory(site, floor, dormitory_num) values (#{site}, #{floor}, #{dormitoryNum})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int saveDormitory(Dormitory dormitory);
}
