package com.demo.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColllectionsDemo {

	public void demo(List<Integer> c) {
		System.out.println("Adding custom value in list");
		c.add(0);
		c.forEach(item -> System.out.println(item + ""));
	}

	public static void main(String[] args) {
		Integer[] oddIntegers = { 1, 3, 5, 7, 9 };

		List<Integer> oddList = new ArrayList<>();
		oddList.addAll(Arrays.asList(oddIntegers));
		
		List<Integer> list = Collections.unmodifiableList(oddList);
		
		new ColllectionsDemo().demo(list);

	}

}
