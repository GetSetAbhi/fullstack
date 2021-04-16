package com.demo.test.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TestingStreamsAverage {

	public static void main(String[] args) {
		
		Integer[] oddIntegers = { 1, 3, 5, 7, 9, 2, 4, 6, 8 };
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(oddIntegers));
		
		OptionalDouble value = list.stream().mapToDouble(item -> Double.valueOf(item)).average();
		
		if (value.isPresent()) {
			System.out.println(value.getAsDouble());
		}
		
		List<Integer> output = list.stream().sorted((a, b) -> {
			return a - b;
		}).collect(Collectors.toList());
		
		System.out.println(output.get(output.size() - 2));
		
		System.out.println("#######################");

		// Using the reduce to calculate the total sum
		int total = list.stream().reduce(0 , (item, i) -> i = item + i).intValue();
		System.out.println("Total sum is : " + total);
	}

}
