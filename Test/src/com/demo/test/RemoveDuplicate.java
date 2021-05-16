package com.demo.test;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicate {
	
	static int findMaxValue(Integer[] input) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= max) {
				max = input[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
		Integer[] input = {1, 2, 2, 3, 4 ,5 ,6 ,6};
		
		int maxValue = RemoveDuplicate.findMaxValue(input);
		int[] temp = new int[maxValue + 1];
		
		for (int i = 0; i < input.length; i++) {
			int currentValue = input[i];
			if (temp[currentValue] == 0) {
				temp[currentValue] = 1;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= maxValue; i++) {
			if (temp[i] == 1) {
				list.add(i);
			}
		}
		
		Integer[] output = (Integer[]) list.toArray();
		System.out.println(output);

	}

}
