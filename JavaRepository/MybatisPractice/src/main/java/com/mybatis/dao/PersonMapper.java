package com.mybatis.dao;

import com.mybatis.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface PersonMapper {
    // 方法名和mapper.xml中的id一致
    // 参数和parameterType一致
    // 返回值和resultType一致
    Person findPersonById(int id);

    List<Person> findAllPerson();

    void addPerson(Person person);

    Boolean updatePersonById(Person person);

    void deleteStudentByName(String name);

    List<Person> findPersonByAddress(Person person);

    List<Person> findPeronByNameOrAge(HashMap hashMap);

    // 当我们使用hashmap来作为返回值的时候，一定要注意接口方法中的返回值
    // 一个HashMap只能接收一个对象的，也就是说，如果结果中含有2个perosn对象的数据，这里就要用两个HashMap，
    // 所以返回值必须使用List
    List<HashMap<String, Object>> findNameAndAgeFromPerson();

    List<Person> findPersonWithIfTag1(Person person);

    List<Person> findPersonWithWhereTag(Person person);

    List<Person> findPersonWithForeachTag1(ArrayList ageList);

    List<Person> findPersonWithForeachTag2(int[] ageList);

    List<Person> findPersonWithForeachTag3(Person[] personList);

    List<Person> findPersonWithForeachTag4(ArrayList personList);

    List<Person> findPersonWithForeachTag5(HashMap<String, Object> personList);
}
