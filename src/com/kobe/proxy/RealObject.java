package com.kobe.proxy;

/**
 * Created by I047580 on 7/31/2017.
 */
public class RealObject implements Interface {

    @Override
    public void doSth() {
        System.out.println("doSomething");
    }

    @Override
    public void sthElse(String arg) {
        System.out.println("sthElse" + " " + arg);
    }
}


