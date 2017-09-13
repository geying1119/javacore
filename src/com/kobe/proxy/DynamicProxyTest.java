package com.kobe.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by I047580 on 7/31/2017.
 */
public class DynamicProxyTest {
    public static void consumer(Interface iface) {
        iface.doSth();
        iface.sthElse("aha");
    }

    public static void main(String[] args) {
        RealObject realObj = new RealObject();
        consumer(realObj);

        Proxy proxy = (Proxy) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(realObj));
        //if looking into class file (refer to GenerateClassFileDemo.java), we can find proxy
        // is also implements the interface of second param above, so 1) it can be casted into type of second param above
        //2) the method is called by invoke()
        Interface iface = (Interface)proxy;
        consumer(iface);
    }
}
