package com.mybatis.main;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.dao.PersonMapper;
import com.mybatis.model.Address;
import com.mybatis.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PersonMain {
    public static void main(String[] args) throws IOException {
        // findPersonById();
         findAllPerson();
        // addPerson();
        // deletePersonByName();
        // updatePersonById();
        // findPersonByAddress();
        // findPeronByNameOrAge();
        // findNameAndAgeFromPerson();
        // findPersonWithIfTag1();
        // findPersonWithWhereTag();
        // findPersonWithForeachTag1();
        // findPersonWithForeachTag2();
        // findPersonWithForeachTag3();
        // findPersonWithForeachTag4();
        // findPersonWithForeachTag5();
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

    // 根据id找person
    public static void findPersonById() throws IOException {
        SqlSession session = getSession();

        // 使用原始的方式查询
        //第一个参数是 mapper文件的namespace + 方法id(如果这个方法的id在所有的映射文件中都是唯一的，那么可以只写方法的id), 第二个参数是sql语句需要的参数
         Person person = session.selectOne("findPersonById", 1);

        // 使用接口开发的写法
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person1 = personMapper.findPersonById(1);

        System.out.println(person1);
    }

    // 查询所有的person
    public static void findAllPerson() throws IOException {
        SqlSession session = getSession();
        // 使用原始的方式查询
        // List<Person> personList = session.selectList("findAllPerson");

        // 接口开发的方式
        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        //第三种，Mapper接口方式的调用，推荐这种使用方式。

        // 使用分页，每页有10个数据，一共两页
        Page<Object> page = PageHelper.startPage(2, 10);
        List<Person> personList = personMapper.findAllPerson();

        // List<Person> personList = personMapper.findAllPerson();
        System.out.println(personList);
        System.out.println("当前页：" + page.getPageNum());
    }

    // 添加person
    public static void addPerson() throws IOException {
        SqlSession session = getSession();

        // 使用原始的方式插入数据
        Person person1 = new Person(3, "小明", 26);

        // 这里的sex属性是为了测试类型转换器
        person1.setSex(true);
        int count = session.insert("addPerson", person1);

        // 使用接口开发的写法
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        personMapper.addPerson(person1);

        // 因为我们使用的是jdbc的事务管理，所以需要手动提交
        session.commit();
    }

    // 根据name删除person
    public static void deletePersonByName() throws IOException {
        SqlSession session = getSession();
        // 使用原始的方法删除
        int deleteCount = session.delete("deleteStudentByName","小明");

        // 使用接口开发的写法
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        personMapper.deleteStudentByName("小明");
        session.commit();
    }

    // 更新person
    public static void updatePersonById() throws IOException {
        SqlSession session = getSession();
        // 使用原始的方法更新
        Person person = session.selectOne("findPersonById", 1);
        person.setAge(24);
        session.update("updatePersonById",person);

        // 使用接口开发的写法
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Boolean result = personMapper.updatePersonById(person);
        System.out.println(result);
//        session.commit();
    }

    // ---------- 以下的方法我们将不再使用原始的方法，全部使用接口开发的方式 ----------------------------

    // 根据address来找person
    public static void findPersonByAddress() throws IOException {
        SqlSession session = getSession();

        Address address = new Address();
        address.setHomeAddress("山西运城");
        address.setSchoolAddress("山西太原");

        Person person = new Person();
        person.setAddress(address);

        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        List<Person> personList = personMapper.findPersonByAddress(person);

        System.out.println(personList);
    }

    // 使用hashmap来传值
    public static void findPeronByNameOrAge() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("name", "景轩");
        hashMap.put("age", "25");

        List<Person> personList = personMapper.findPeronByNameOrAge(hashMap);

        System.out.println(personList);
    }

    // 使用hashMap来接收结果
    public static void findNameAndAgeFromPerson() throws IOException {
        SqlSession session = getSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        List<HashMap<String, Object>> result = personMapper.findNameAndAgeFromPerson();

        System.out.println(result);
    }

    // 使用if标签
    public static void findPersonWithIfTag1() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        Person person = new Person();
        person.setName("景轩");
        person.setAge(25);

        List<Person> personList = personMapper.findPersonWithIfTag1(person);

        System.out.println(personList);
    }

    // 使用where标签
    public static void findPersonWithWhereTag() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        Person person = new Person();
        person.setName("景轩");
        person.setAge(25);

        List<Person> personList = personMapper.findPersonWithWhereTag(person);
        System.out.println(personList);
    }

    // 使用foreach标签
    // 传入list
    public static void findPersonWithForeachTag1() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        ArrayList ageList = new ArrayList();
        ageList.add(24);
        ageList.add(25);

        List<Person> personList = personMapper.findPersonWithForeachTag1(ageList);
        System.out.println(personList);
    }

    // 使用foreach标签
    // 传入数组
    public static void findPersonWithForeachTag2() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        int[] ageList = {24, 25};

        List<Person> personList = personMapper.findPersonWithForeachTag2(ageList);
        System.out.println(personList);
    }

    // 使用foreach标签
    // 传入对象数组
    public static void findPersonWithForeachTag3() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);

        Person person1 = new Person();
        person1.setAge(24);
        Person person2 = new Person();
        person2.setAge(25);

        Person[] personListParam = {person1, person2};

        List<Person> personList = personMapper.findPersonWithForeachTag3(personListParam);
        System.out.println(personList);
    }

    // 使用foreach标签
    // 传入对象集合
    public static void findPersonWithForeachTag4() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        ArrayList personListParam = new ArrayList();

        Person person1 = new Person();
        person1.setAge(24);
        Person person2 = new Person();
        person2.setAge(25);

        personListParam.add(person1);
        personListParam.add(person2);

        List<Person> personList = personMapper.findPersonWithForeachTag4(personListParam);
        System.out.println(personList);
    }

    // 使用foreach标签
    // 传入hashmap
    public static void findPersonWithForeachTag5() throws IOException {
        SqlSession session = getSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        ArrayList personListParam = new ArrayList();

        Person person1 = new Person();
        person1.setAge(24);
        Person person2 = new Person();
        person2.setAge(25);
        personListParam.add(person1);
        personListParam.add(person2);

        HashMap<String, Object> mapParams = new HashMap<String, Object>();
        mapParams.put("personList", personListParam);

        List<Person> personList = personMapper.findPersonWithForeachTag5(mapParams);
        System.out.println(personList);
    }
}
