package com.kobe.annotation;

/**
 * Created by I047580 on 7/30/2017.
 */
public class Calculator {

    @EnableTrace
    public Long add(Long a, Long b) {
        Long result = a+b;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Long result = c.add(100L, 200L);

        PerformanceReport pr = new PerformanceReport(c.getClass());
        pr.printReport();
    }
}
