package com.demo.test.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestingStreams2 {

	public static void main(String[] args) {

		Integer[] oddIntegers = { 1, 3, 5, 7, 9 };
		Integer[] evenIntegers = { 2, 4, 6, 8 };
		
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(oddIntegers));
		list.add(Arrays.asList(evenIntegers));
		
		System.out.println(list);
		
		Map<String, String> map = list.stream().flatMap(item -> item.stream()).collect(Collectors.toMap(item -> "key"+item, item -> "value"+item));
		
		for (String key : map.keySet()) {
			System.out.println(key + ", " + map.get(key));
		}
		
		List<Integer> output = list.stream().flatMap(item -> item.stream()).collect(Collectors.toList());
		
		System.out.println(output);
	}

}
