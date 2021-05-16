package com.demo.test.fail_fast_fail_safe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {

	public static void main(String[] args) {
		Integer[] oddIntegers = { 1, 3, 5, 7, 9 };
		Integer[] evenIntegers = { 2, 4, 6, 8 };
		
		List<Integer> oddList = new ArrayList<>();
		oddList.addAll(Arrays.asList(oddIntegers));
		
		Iterator<Integer> oddIter = oddList.iterator();
		
		int i = 0;
		while (oddIter.hasNext()) {
			System.out.println(oddIter.next());
			i++;
			if (i == 1) {
				oddList.add(79);
			}
		}
		System.out.println("############");
		
		CopyOnWriteArrayList<Integer> cOddList = new CopyOnWriteArrayList<>();
		cOddList.addAll(oddList);
		i = 0;
		Iterator<Integer> io = cOddList.iterator();
		while(io.hasNext()) {
			System.out.println(io.next());
			if (i == 1) {
				cOddList.add(79);
			}
		}
		System.out.println("############");
		System.out.println(cOddList);

	}

}
