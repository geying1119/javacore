package com.kobe.equalsAndHashcode;


import java.util.HashMap;
import java.util.Map;

/*
## equals()
- Object对象的默认实现是比较地址相等才相等
- 具体对象可以自己覆写
-

## hashcode()
- 当对象与hash类集合(hashmap，hashset，hashtable)工作时，必须覆写hashcode，否则的话，下面的代码不会得到预期结果：
```
Map<Person, String> m = new HashMap<Person, String>();
m.put(new Person("Mike", Male, 30), "USA");
String s = m.get(new Person("Mike", Male, 30));
//s是null，而不是USA
```
* */
public class Person implements Comparable {
    @Override
    public int compareTo(Object o) {
        Person b = (Person) o;
        if (this.getAge() < b.getAge()) {
            return -1;
        } else if (this.getAge() == b.getAge()) {
            return 0;
        } else {
            return 1;
        }
    }

    public enum GENDER {MALE, FEMALE};

    private String name;
    private GENDER gender;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, GENDER gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return gender == person.gender;
    }

   @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person kobe = new Person("Kobe", GENDER.MALE, 30);
        Person anotherKobe = new Person("Kobe", GENDER.MALE, 30);

        Map<Person, String> m = new HashMap<Person, String>();
        m.put(kobe, "USA");
        String countryName = m.get(anotherKobe);
        //if without re-write hashcode(), countryName will be null
        //if with re-write hashcode(), countryName is "USA"
        System.out.println(countryName);
        System.out.println("kobe's hashcode is: " + kobe.hashCode());
        System.out.println("anotherKobe's hashcode is: " + anotherKobe.hashCode());

    }

}
