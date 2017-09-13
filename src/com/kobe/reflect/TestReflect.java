package com.kobe.reflect;

import java.lang.reflect.Proxy;

import com.kobe.equalsAndHashcode.Person;

public class TestReflect {

    public static void main(String[] args) {
        Person s = new Person("Kobe", Person.GENDER.MALE, 33);
        Person s2 = new Person("Umi", Person.GENDER.FEMALE, 25);
        Reflect rf = new Reflect(s2);
        Comparable comparable = (Comparable) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(), rf);
        comparable.compareTo(s);
    }

}
