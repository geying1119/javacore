package com.kobe.oo;

public class Teacher implements Working{

	@Override
	public void goToWork() {
		System.out.println("Teacher: Teacher also needs"
				+ " to work from Monday to Friday.");
	}

}
