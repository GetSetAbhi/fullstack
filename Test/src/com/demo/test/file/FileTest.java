package com.demo.test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		String path = "D:\\SPRING_WORKSPACE\\Test\\abhi.txt";
		
		File file = new File(path);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String content = br.readLine();
			while (content != null) {
				System.out.println(content);
				content = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
