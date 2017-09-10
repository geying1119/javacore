package com.kobe.basic;

import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {
		//f2();

	}

	private static void f2() throws IOException {
		f1();
		
	}

	private static void f1() throws IOException {
		int arr[] = {1, 2};
		throw new ArrayIndexOutOfBoundsException();
		//System.out.println(arr[3]);
	}

}
