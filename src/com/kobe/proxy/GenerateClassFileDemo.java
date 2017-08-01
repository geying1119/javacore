package com.kobe.proxy;

import com.kobe.equalsAndHashcode.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by I047580 on 7/31/2017.
 */
public class GenerateClassFileDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("before class file generation");
        String path = "c:/code/javacore/src/com/kobe/proxy/$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", new Class[] {Interface.class});

        FileOutputStream fos = null;
        fos = new FileOutputStream(path);
        fos.write(classFile);
        fos.flush();
        fos.close();

        System.out.println("after class file generation");
    }
}
