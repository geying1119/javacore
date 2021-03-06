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
    public Reflect(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call compareTo()");
        Object result = method.invoke(object, args);
        System.out.println("after call compareTo()");
        return result;
    }
}
