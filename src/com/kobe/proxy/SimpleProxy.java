package com.kobe.proxy;

/**
 * Created by I047580 on 7/31/2017.
 */
public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSth() {
        System.out.println("SimpleProxy doSth:");
        proxied.doSth();
    }

    @Override
    public void sthElse(String arg) {
        System.out.println("SimpleProxy sthElse:");
        proxied.sthElse(arg);
    }
}
