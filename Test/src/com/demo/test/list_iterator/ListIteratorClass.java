package com.demo.test.list_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class ListIteratorClass {

	public static void main(String[] args) {
		Integer[] oddIntegers = { 1, 3, 5, 7, 9 };
		
		List<Integer> oddList = new ArrayList<>();
		oddList.addAll(Arrays.asList(oddIntegers));
		
		ListIterator<Integer> li = oddList.listIterator();
		
		int i = 0;
		while (li.hasNext()) {
			System.out.println(li.next());
			i++;
			if (i == 3) {
				li.add(79);
			}
		}
		
		System.out.println(oddList);

	}

}
