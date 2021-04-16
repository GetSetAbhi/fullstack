package com.demo.test.hashing_test;

import java.util.HashMap;
import java.util.Map;

public class HasherTest {

	public static void main(String[] args) {
		
		CModel m1 = new CModel("One");
		CModel m2 = new CModel("Tne");
		
		Map<CModel, String> map = new HashMap<>();
		
		map.put(m1, "ONE");
		map.put(m2, "BLAAAAAAAAAAAA");
		
		System.out.println(map.size());
		
		String demo = map.get(m2);
		System.out.println(demo);
		
		System.out.println("M1 hashcode " + m1.hashCode());
		System.out.println("M2 hashcode " + m2.hashCode());

		System.out.println(m1.equals(m2));
	}

}
