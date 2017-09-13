package com.kobe.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JavaBasic {
	static int classStaticVar = 100;
	static {
		System.out.println("Class's static "
				+ "var is initialized before "
				+ "calling main(): " 
	+ "FlowControl.classStaticVar");
	}
	
	public int count;	
	public JavaBasic(int count) {		
		this.count = count;
	}
	public void addOne(int i) {
		i = i+1;
	}
	public void addOne(JavaBasic fc ) {
		fc.count += 1;		
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
		JavaBasic basic = new JavaBasic(0);
		basic.print99Multiplication();		
		basic.testParamPass();				
		basic.testRecursiveMethod();
		basic.TestScanner();		
		basic.testScannerFromFile();		
		basic.testMap();
		basic.testWhileFor();
	}
	private void testScannerFromFile() throws FileNotFoundException {
		File file = new File("C:\\code\\HelloWorld.java");  
        String encoding = "utf-8"; 

		if(file.exists() && file.isFile()) {
			Scanner sc = new Scanner(file, encoding);		
			int intCounter = 0;
			int charCounter = 0;
			int otherCounter = 0;
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();	
				for(int i = 0; i<line.length();i++) {
					if(Character.isDigit(line.charAt(i))) {
						intCounter++;
					} else if(Character.isLetter(line.charAt(i))) {
						charCounter++;
					} else {
						otherCounter++;
					}					
				}				
			}
			System.out.println("总字数： "+(intCounter+charCounter+otherCounter)
					+"  数字出现次数： "+intCounter 
					+"  字符出现次数： "+ charCounter 
					+ "  其它符号出现次数： "+ otherCounter);
		}        
	}
	public void testMap() {			
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
	private void testWhileFor() {
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
	private void TestScanner() {
		Scanner sc = new Scanner(System.in);		
		String str = sc.nextLine();
		String[] strArry = str.split("@");
		System.out.println("the input has " + 
		(strArry.length -1) + " @");
		
	}
	private void testRecursiveMethod() {
		long n = 3;
		System.out.println("Total value is: " + factorial(n));
	}
	private void testParamPass() {
		JavaBasic fc = new JavaBasic(1);
		int i = 5;
		System.out.println("before call: " + i);
		fc.addOne(i);
		System.out.println("after call: " + i);	
		
		System.out.println("before call: " + fc.count);
		fc.addOne(fc);
		System.out.println("before call: " + fc.count);
	}

	private long factorial(long n) {
		//退出机制, 否则有死循环的可能
		if(n == 1) {
			return 1;
		}
		
		//递归实现体
		return n*factorial(n-1);
	}
	
	private void print99Multiplication() {
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
