package com.kobe.basic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

public class FlowControl {
	static int classStaticVar = 100;
	static {
		System.out.println("Class's static "
				+ "var is initialized before "
				+ "calling main(): " 
	+ "FlowControl.classStaticVar");
	}
	
	public int count;	
	public FlowControl(int count) {		
		this.count = count;
	}
	public void addOne(int i) {
		i = i+1;
	}
	public void addOne(FlowControl fc ) {
		fc.count += 1;		
	}
	
	public static void main(String[] args) {		
		print99Multiplication();		
		//testParamPass();				
		//testRecursiveMethod();
		//TestScanner();
		//testMap();
		//testWhileFor();
	}
	public static void testMap() {			
		//Map m = new HashMap<>();
		Map<String, Integer> m = new HashMap<>();			
		m.put("male", 25);
		m.put("female", 15);
		m.put("abc", 100);
		//m.put("efg", "sbc");
		Set keys = m.keySet();
		int classSize = 0;		
		if(m.containsKey("male")) {
			classSize += (m.get("male").intValue());
		} 
		if(m.containsKey("female")) {
			classSize += (int)(m.get("female"));
		} 
		
		System.out.println("class size is: " + classSize);
	}
	private static void testWhileFor() {
		List list = new ArrayList();
		list.add("abc");
		list.add(123);
		list.add(456L);
		Iterator ir = list.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	private static void TestScanner() {
		Scanner sc = new Scanner(System.in);		
		String str = sc.nextLine();
		String[] strArry = str.split("@");
		System.out.println("the input has " + 
		(strArry.length -1) + " @");
		
	}
	private static void testRecursiveMethod() {
		long n = 3;
		System.out.println("Total value is: " + factorial(n));
	}
	private static void testParamPass() {
		FlowControl fc = new FlowControl(1);
		int i = 5;
		System.out.println("before call: " + i);
		fc.addOne(i);
		System.out.println("after call: " + i);	
		
		System.out.println("before call: " + fc.count);
		fc.addOne(fc);
		System.out.println("before call: " + fc.count);
	}

	private static long factorial(long n) {
		//退出机制, 否则有死循环的可能
		if(n == 1) {
			return 1;
		}
		
		//递归实现体
		return n*factorial(n-1);
	}
	
	private static void print99Multiplication() {
		for(int i = 1; i < 10; i ++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 1; j <= i; j ++) {
				sb.append(String.valueOf(j))
				.append(" X ")
				.append(String.valueOf(i))
				.append(" = ")
				.append(String.valueOf(j*i))
				.append("\t");				
			}
			System.out.println(sb);
		}		
	}
}
