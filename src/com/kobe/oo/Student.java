package com.kobe.oo;

public class Student implements Training, Working{
		
	@Override
	public void attendClass() {
		System.out.println("Student: attend class each Sunday.");
	}

	@Override
	public void takeExam() {
		System.out.println("Student: take exam in December.");
	}
	
	@Override
	public void goToWork() {
		System.out.println("Student: Student needs to work from Monday to Friday.");
	}

}
