package com.design.mapper;
import com.design.model.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {
    @Insert("insert into department(name) values (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int saveDepartment(Department department);
}
