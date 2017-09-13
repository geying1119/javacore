package com.kobe.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProcessFile {
	private String inputFilePath;
	private String outputFilePath;
	
	public ProcessFile(String inputFilePath, String outputFilePath) {
		super();
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
	}

	public void processFile() {
		File file = new File(inputFilePath);  
        if(file == null || !file.exists() || !file.isFile()) {
        	System.out.println("bad file!");
        	return;
        }
        InputStream is = null;
        OutputStream os = null;
        try {
			is = new FileInputStream(file);
			os = new FileOutputStream(outputFilePath);
			byte[] bytes = new byte[1024];
			int length = 0;
			int bytesWritten = 0;
			while ((length =is.read(bytes)) != -1) {
				String str = new String(bytes);
				os.write(bytes, bytesWritten, length);
				bytesWritten += length;
				System.out.println(str);
			}
			
        } catch (FileNotFoundException e) {
        	System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("IO exception");
		} finally{			
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				System.out.println("IO exception");
			}
		}        
	};
}
