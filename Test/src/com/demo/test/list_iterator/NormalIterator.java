package com.demo.test.list_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NormalIterator {

	public static void main(String[] args) {
		Integer[] oddIntegers = { 1, 3, 5, 7, 9 };

		List<Integer> oddList = new ArrayList<>();
		oddList.addAll(Arrays.asList(oddIntegers));

		Iterator<Integer> iterator = oddList.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			//iterator.remove();
			oddList.remove(0);
			System.out.println("Size : " + oddList.size());
		}
	}

}
