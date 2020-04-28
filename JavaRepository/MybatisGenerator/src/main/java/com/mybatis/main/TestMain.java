package com.mybatis.main;

import com.mybatis.dao.StudentMapper;
import com.mybatis.model.StudentExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class TestMain {


    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andAgeBetween(22, 25);

        long count = studentMapper.countByExample(studentExample);

        System.out.println(count);
    }

    // 获取SqlSession, 相当于JDBC中的connection
    public static SqlSession getSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);

        //这个session就相当于jdbc的connection

        SqlSession session = sqlSessionFactory.openSession(true);

        return session;
    }
}
