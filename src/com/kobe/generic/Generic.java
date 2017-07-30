package com.kobe.generic;

/* 泛型使用场景
1. 用于集合
编译期间类型检查， 表示改集合可以存放指定类型的元素
2. 用于类
普通类的代码工厂，节省定义相似类的重复代码，
3. 用于方法
参数，返回值可以适配指定类型
*/

/* 泛型的好处
* 1. Generic VS Object
* 可读性好，健壮性好
* 2. 避免代码重复
* 3. 限制类型 - 只接受想接受的类型
* <T extends XX, YY> 其中XX, YY可以是一个类，也可以是一个接口
* 或者<? extends XX, YY, ZZ>,表示任意继承与XX的子类，或者是实现了XX接口的类

* 4. Generic VS 类的继承
* 在JAVA引入泛型之前，java程序用继承来做到泛型，编译期间多态
* */

/* 泛型的擦除带来的局限性
* ！！！！！！
* 1）JVM里没有泛型，泛型在运行期间会被擦除
* 2）泛型擦除规则就是: 有限制类型的，就保留限制类型，没有限制类型的就用Object
* 3）JVM自动加上强制类型转换
* ！！！！！
* */

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {
    public <T extends Comparable> T findSmall(List<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        T smallest = collection.get(0);
        for (T t : collection) {
            if (t.compareTo(smallest) < 0) {
                smallest = t;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        List<Long> l = new ArrayList<>();
        l.add(1L);
        l.add(3L);
        l.add(4L);
        List<Student> students = new ArrayList<>();
        students.add(new JuniorStudent("kobe", true, 34));
        students.add(new JuniorStudent("umi", false, 33));
        Generic<Long> gen = new Generic<>();
        Generic<Student> genStudent = new Generic<>();
        Student s = genStudent.findSmall(students);

        System.out.print(gen.findSmall(l) + "\n");
        System.out.print(s.toString());
    }
}
