package com.kobe.annotation;

import java.lang.reflect.Method;

/**
 * Created by I047580 on 7/30/2017.
 */
public class PerformanceReport {
    private Class<?> clazz;

    public PerformanceReport(Class<?> clazz) {
        this.clazz = clazz;
    }

    public  void printReport() throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        Object obj = clazz.getConstructor(new Class[]{}).newInstance();
        for (Method m: methods) {
            EnableTrace e = m.getAnnotation(EnableTrace.class);
            if (e != null) {
                //invoke the method which has defined annotation
                m.invoke(obj, 100L, 400L);
            }

        }

    }
}
