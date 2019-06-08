package com.ystu.web_first.Model;

public class Person {
    private long id;
    private String name;
    private String pass;
    private int age;


    public Person(long id, String name, String pass, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
