package com.demo.test.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Checker {
	void add(int a, int b);
}
class Printer { 
	public static void print(Object item) {
		System.out.println(item);
	}
	
	public void add(int a, int b) {
		int result = a + b;
		System.out.println(result);
	}
}

public class StreamWIthMethodReference {

	public static void main(String[] args) {
		Integer[] oddIntegers = { 1, 3, 5, 7, 9, 2, 4, 6, 8 };
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(oddIntegers));
		
		list.stream().forEach(Printer::print);
		System.out.println("##########");
		Printer p = new Printer();
		Checker c = p::add;
		c.add(1, 2);

	}

}
