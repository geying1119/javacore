package com.kobe.proxy;

/**
 * Created by I047580 on 7/31/2017.
 */
public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSth();
        iface.sthElse("aha");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
