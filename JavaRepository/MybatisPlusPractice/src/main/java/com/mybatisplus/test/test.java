package com.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mybatisplus.mapper.StudentMapper;
import com.mybatisplus.model.Student;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
//        testInsert();
//        testDelete();
//        testUpdate();
//        testQuery();
        testQuery2();
    }

    public static void testQuery3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = new Student("景轩", 24);
        student.insert();
    }

    public static void testUpdate2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class); // 默认是接口名首字母小写

        Student student = new Student("景轩", 24);

        UpdateWrapper<Student> wrapper = new UpdateWrapper<>();
        wrapper.eq("stu_no", 3);
        // 将id为3的改为student
        studentMapper.update(student, wrapper);
    }

    public static void testQuery2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class); // 默认是接口名首字母小写

        // 条件注解
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        // age在3到5之间，并且id大于等于 1(默认是and的关系)
        wrapper.between("stu_age", 3, 5).ge("stu_no", 1);

        // 这里的or使用lambda表达式，将后续的两个条件都放到or里面 select * from student where stu_age between 3 and 5 or (stu_no > 1 and stu_no < 3)
        wrapper.between("stu_age", 3, 5).or(i -> i.ge("stu_no", 1).le("stu_no", 3));

        List<Student> studentList = studentMapper.selectList(wrapper);
        System.out.println(studentList);
    }

    public static void testInsert() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class); // 默认是接口名首字母小写
        Student student = new Student("景轩", 24);
        studentMapper.insert(student);
    }

    public static void testDelete() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class); // 默认是接口名首字母小写
        studentMapper.deleteById(1);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(3);
        studentMapper.deleteBatchIds(ids);
        HashMap<String, Object> maps = new HashMap<String, Object>();
        maps.put("stu_mame", "景轩");
        studentMapper.deleteByMap(maps);
    }

    public static void testUpdate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class); // 默认是接口名首字母小写
        Student student = new Student(4,"景轩", 25);
        studentMapper.updateById(student);
    }

    public static void testQuery() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class); // 默认是接口名首字母小写
        Student student = studentMapper.selectById(4);
        System.out.println(student);
    }

    public static void testConnection() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
