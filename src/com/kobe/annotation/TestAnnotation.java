package com.kobe.annotation;

/**
 * Created by I047580 on 7/30/2017.
 */
public class TestAnnotation {

    @EnableTrace
    public Long add(Long a, Long b) {
        Long result = a+b;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        TestAnnotation c = new TestAnnotation();
        Long result = c.add(100L, 200L);

        ProcessAnnotation pr = new ProcessAnnotation(c.getClass());
        pr.printReport();
    }
}
