package com.demo.test.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationMain {

	public static void main(String[] args) {

		Employee emp = new Employee(1, "Abhishek", "Raina");
		
		try
		{
		   ObjectInputStream oos = new ObjectInputStream(new FileInputStream("empInfo.txt"));
		   Employee e = (Employee) oos.readObject();
		   System.out.println("First Name : " + e.getFirstName());
		   System.out.println("Last Name : " + e.getLastName());
		   System.out.println("Full Name : " + e.fullName);
		   System.out.println("Full Name : " + e.getFullName());
		   oos.close();
		} catch (Exception e)
		{
		   System.out.println(e);
		}
	}
}
