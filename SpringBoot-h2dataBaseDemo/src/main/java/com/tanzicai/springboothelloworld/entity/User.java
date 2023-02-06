package com.tanzicai.springboothelloworld.entity;


/**
 * @author tanzicai
 */


public class User {
    /**
     * user's name
     */
    private String name;
    /**
     * user's age
     */
    private int age;

    /**
     * init
     * @param name user's name
     * @param age user's age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
