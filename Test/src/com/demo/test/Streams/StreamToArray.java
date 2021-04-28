package com.demo.test.Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StreamToArray {

	public static void main(String[] args) {
		int[] num = {1, 2, 3};
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		
		Arrays.asList(num).stream().map(item -> map.get(item)).forEach(item -> System.out.println(item));
		
	}

}
