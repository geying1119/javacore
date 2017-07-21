package com.kobe.generic;

/**
 * Created by I047580 on 3/25/2017.
 */
public class Student implements Comparable {
    private int age;
    private String name;
    private boolean gender;

    public Student() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Student(String name, boolean gender, int age) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    @AddTrace("before")
    public int compareTo(Object o) {
        Student b = (Student) o;
        if (this.getAge() < b.getAge()) {
            return -1;
        } else if (this.getAge() == b.getAge()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\t"
                + "Gender: " + this.isGender() + "\t"
                + "Age: " + this.getAge();
    }
}
