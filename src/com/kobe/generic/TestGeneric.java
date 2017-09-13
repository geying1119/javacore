package com.kobe.generic;

import java.util.ArrayList;
import java.util.List;

import com.kobe.equalsAndHashcode.Person;

public class TestGeneric {
	public static void main(String[] args) {
        List<Long> l = new ArrayList<>();
        l.add(1L);
        l.add(3L);
        l.add(4L);
        List<Person> students = new ArrayList<>();
        students.add(new JuniorStudent("kobe", Person.GENDER.MALE, 34));
        students.add(new JuniorStudent("umi", Person.GENDER.FEMALE, 33));
        Generic<Long> gen = new Generic<>();
        Generic<Person> genStudent = new Generic<>();
        Person s = genStudent.findSmall(students);

        System.out.print(gen.findSmall(l) + "\n");
        System.out.print(s.toString());
    }
}
