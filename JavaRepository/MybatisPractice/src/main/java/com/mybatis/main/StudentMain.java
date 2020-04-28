package com.mybatis.main;

import com.mybatis.dao.StudentMapper;
import com.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) throws IOException {
         findStudentById();
        // findStudentByIdLazyLoad();
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

    // 通过id找到student
    // 两个session用来测试二级缓存
    public static void findStudentById() throws IOException {
        SqlSession session = getSession();
        SqlSession session2 = getSession();

        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = session2.getMapper(StudentMapper.class);

        Student student = studentMapper.findStudentById(1);
        System.out.println(student);
        session.close();

        Student student2 = studentMapper2.findStudentById(1);
        System.out.println(student2);
//        session2.close();
    }

    // 通过id找到student，在找studentCard
    // 延迟加载（一对多）
    public static void findStudentByIdLazyLoad() throws IOException {
        SqlSession session = getSession();

        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        // 通过log可以看出，执行这一步的时候，只调用了select * from student
        List<Student> students = studentMapper.findStudentByIdLazyLoad();

        for (Student stu: students) {
            System.out.println(stu.getName());
        }

        for (Student stu: students) {
            // 当获取card信息的时候，才执行了findStudentCardById的sql语句
            System.out.println(stu.getCard());
        }
    }
}
