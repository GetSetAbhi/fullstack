package com.demo.test.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SeriaMain {

	public static void main(String[] args) {

		Employee emp = new Employee(1, "Abhishek", "Raina");
		
		try
		{
		   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empInfo.txt"));
		   //Serialize the object
		   oos.writeObject(emp);
		   oos.close();
		} catch (Exception e)
		{
		   System.out.println(e);
		}
	}

}
