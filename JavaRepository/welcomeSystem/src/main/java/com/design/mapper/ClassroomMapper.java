package com.design.mapper;

import com.design.model.Classroom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomMapper {
    @Insert("insert into classroom(name, teacher) values (#{name}, #{teacher})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int saveClassroom(Classroom classroom);

    @Update("update classroom set name=#{name}, teacher=#{teacher} where id = #{id}")
    int updateClassroom(Classroom classroom);
}
