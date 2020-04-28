package com.mybatis.main;

import com.mybatis.dao.ClassMapper;
import com.mybatis.model.Class;
import com.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ClassMain {
    public static void main(String[] args) throws IOException {
        // findStudentsByClass();
        findClassLazyLoad();
    }

    // 获取SqlSession, 相当于JDBC中的connection
    public static SqlSession getSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);

        //这个session就相当于jdbc的connection

        SqlSession session = sqlSessionFactory.openSession();

        return session;
    }

    public static void findStudentsByClass() throws IOException {
        SqlSession session = getSession();

        ClassMapper classMapper = session.getMapper(ClassMapper.class);

        List<Student> students = classMapper.findStudentsByClass(1);

        System.out.println(students);
    }

    // 一对多，延迟加载
    // 先查询班级，再查询班级中的学生
    public static void findClassLazyLoad() throws IOException {
        SqlSession session = getSession();

        ClassMapper classMapper = session.getMapper(ClassMapper.class);

        // 只获取class的信息
        List<Class> classList = classMapper.findClassLazyLoad();

        for (Class stuClass: classList) {
            System.out.println(stuClass.getClassName());
        }

        for (Class stuClass: classList) {
            // 当需要student信息的时候才会执行查询student的sql
            System.out.println(stuClass.getStudents());
        }
    }
}
