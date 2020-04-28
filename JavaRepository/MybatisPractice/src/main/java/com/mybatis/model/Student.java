package com.mybatis.model;

import java.io.Serializable;

// Student和Class主要用来演示一对多
// Student和StudentCard主要用来演示一对一
public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private StudentCard card;

    public StudentCard getCard() {
        return card;
    }

    public void setCard(StudentCard card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", card=" + card +
                '}';
    }
}
