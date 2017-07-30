package com.kobe.reflect;

import com.kobe.annotation.EnableTrace;
import com.kobe.generic.Student;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;

/**
 * Created by I047580 on 3/25/2017.
 */
public class Reflect implements InvocationHandler {
    private Object object;

    public static void main(String[] args) {
        Student s = new Student("Umi", true, 33);
        Student s2 = new Student("Kobe", true, 25);
        Reflect rf = new Reflect(s2);
        Comparable comparable = (Comparable) Proxy.newProxyInstance(Student.class.getClassLoader(),
                Student.class.getInterfaces(), rf);
        String path = "c:/kobecode/$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        comparable.compareTo(s);
        //rf.proxyMethod(s);

    }

    public Reflect(Object object) {
        this.object = object;
    }

    public int proxyMethod(Student s2) {
        Object result = null;
        try {
            Class c = Class.forName("com.kobe.generic.Student");
            Student s = (Student) c.newInstance();
            Method[] methods = c.getMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(EnableTrace.class)) {
                    System.out.println("before call compareTo()\n");
                    try {
                        result = m.invoke(s, s2);
                        System.out.println(result.toString());
                        System.out.println("\nAfter call compareTo()\n");
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (int) result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call compareTo()\n");
        Object result = method.invoke(object, args);
        System.out.println("after call compareTo()\n");
        return result;
    }
}
