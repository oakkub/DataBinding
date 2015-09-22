package com.databinding.oakkub.databinding;

/**
 * Created by OaKKuB on 9/22/2015.
 */
public class Employee {

    private String name;
    private int age;
    private boolean gender;

    public Employee(String name, int age, boolean gender) {

        this.name = name;
        this.age = age;
        this.gender = gender;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender ? "FEMALE" : "MALE";
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Gender: %s", name, age, getGender());
    }
}
