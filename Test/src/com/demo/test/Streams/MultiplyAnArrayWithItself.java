package com.demo.test.Streams;

import java.util.Arrays;
import java.util.List;

public class MultiplyAnArrayWithItself {

	public static void main(String[] args) {
		Integer ls[] = {1, 2, 3, 4};
		List<Integer> list = Arrays.asList(ls);
		
		int value = list.stream().reduce(1, (item, p) -> p = p * item).intValue();

		System.out.println(value);
	}

}
