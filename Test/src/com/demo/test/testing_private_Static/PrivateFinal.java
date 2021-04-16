package com.demo.test.testing_private_Static;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class A {
	
	public int hello() {
		return 1;
	}
	
	public float hello(int a) {
		return (float) 1.0;
	}
}

public class PrivateFinal {
	public static void main(String[] args) {
		Integer[] intl = {1, 2, 3, 4, 5, 6, 7, 8 , 9};
		
		List<Integer> list = Arrays.asList(intl);
		
		List<Integer> glList = list.stream().filter(item -> item >=5).collect(Collectors.toList());
		
		glList.forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println("################");
		
		List<Integer> convertList = list.stream().map(item -> item *2).collect(Collectors.toList());
		convertList.forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println("#################");
		
		Optional<Integer> reduction = list.stream().map(item -> item *2).reduce((ans,b) -> ans+b);
		System.out.println(reduction.get());
		
		System.out.println("##########3");
		String[] myArray = { "this", "is", "a", "sentence" };
		String result = Arrays.stream(myArray)
		                .reduce("", (a,b) -> a + b);
		System.out.println(result);
	}
}
