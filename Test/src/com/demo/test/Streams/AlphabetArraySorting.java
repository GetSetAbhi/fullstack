package com.demo.test.Streams;

import java.util.Arrays;
import java.util.List;

/**
 * sort an array of string based on alphabetical order
 * 
 * **/
public class AlphabetArraySorting {

	public static void main(String[] args) {
		String ls[] = {"Steve", "Tony", "Banner", "Natasha", "Thor", "Clint"};
		List<String> list = Arrays.asList(ls);
		
		list.stream().sorted((a, b) -> {
			return a.compareTo(b);
		}).forEach(item -> {
			System.out.println(item);
		});

	}

}
