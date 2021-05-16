package com.demo.test.enums;

import java.util.ArrayList;
import java.util.Arrays;

public class EnumTest {

	public enum Season { WINTER, SPRING, SUMMER, FALL }  
	
	public static void main(String[] args) {
		
		var local = Season.WINTER;
		
		/*System.out.println(local);
		Stream.of(Season.values()).forEach(item -> {
			System.out.println(item);
		});*/

		ArrayList<Season> list = new ArrayList<>(Arrays.asList(Season.values()));
		list.forEach(item -> {
			System.out.println(item);
		});
	}

}
