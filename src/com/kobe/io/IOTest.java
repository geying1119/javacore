package com.kobe.io;

public class IOTest {

	public static void main(String[] args) {
		String inputFile = "c:\\code\\HelloWorld.java";
		String outputFile = "c:\\code\\HelloWorld2.java";
		ProcessFile rf = new ProcessFile(inputFile, outputFile);
		rf.processFile();
	}

}
