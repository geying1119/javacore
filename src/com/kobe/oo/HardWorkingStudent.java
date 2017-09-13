package com.kobe.oo;

public class HardWorkingStudent extends Student {

	@Override
	public void attendClass() {
		System.out.println("HardWorkingStudent: get up very early.");
		super.attendClass();
	}
	
}
