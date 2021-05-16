package com.demo.test.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UseOfFunctionToRepresentLambdaExpression {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(9, 8, 3, 4, 5, 1, 12, 13);

		Function<Integer, Integer> f = item -> item * 10;
		
		List<Integer> output = list.stream().map(f).collect(Collectors.toList());
		
		System.out.println(output);

	}
}
