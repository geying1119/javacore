package com.kobe.oo;

public class Test {

	public static void main(String[] args) {
		
		
		testPolymorphism();
		testInheritance();
	}

	private static void testInheritance() {
		Training tr = new Student();
		tr.attendClass();
		tr = new HardWorkingStudent();
		tr.attendClass();
	}

	private static void testPolymorphism() {
		//多态： 基类类型 + 子类重写方法
		Working worker = new Student();
		worker.goToWork();
		worker = new Teacher();
		worker.goToWork();		
	}

}
