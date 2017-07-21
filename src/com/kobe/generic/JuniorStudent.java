package com.kobe.generic;

/**
 * Created by I047580 on 3/25/2017.
 */
public class JuniorStudent extends Student {
    private String highSchoolName;

    public JuniorStudent(String name, boolean gender, int age, String highSchoolName) {
        super(name, gender, age);
        this.highSchoolName = highSchoolName;
    }

    public JuniorStudent(String name, boolean gender, int age) {
        super(name, gender, age);
        this.highSchoolName = "NormalHighSchool";
    }

    public String getHighSchoolName() {
        return highSchoolName;
    }

    public void setHighSchoolName(String highSchoolName) {
        this.highSchoolName = highSchoolName;
    }

    @Override
    public String toString() {
        return super.toString() + "\tHighSchoolName: " + this.highSchoolName;
    }
}
