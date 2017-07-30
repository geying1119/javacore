package com.kobe.reflect;

import com.kobe.annotation.EnableTrace;
import com.kobe.equalsAndHashcode.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Class is for all object in JVM
 * instance of Class is by:
 * 1. XXXClass.class
 * 2. objectXXX.getClass()
 * 3. class.forName("path of XXXClass");
 */
public class Reflect implements InvocationHandler {
    private Object object;

    public static void main(String[] args) {
        Person s = new Person("Kobe", Person.GENDER.MALE, 33);
        Person s2 = new Person("Umi", Person.GENDER.FEMALE, 25);
        Reflect rf = new Reflect(s2);
        Comparable comparable = (Comparable) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(), rf);
        String path = "c:/code/javacore/$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Person.class.getInterfaces());
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

    public int proxyMethod(Person s2) {
        Object result = null;
        try {
            Class c = Class.forName("com.kobe.generic.Student");
            Person s = (Person) c.newInstance();
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
