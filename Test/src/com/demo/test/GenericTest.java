package com.demo.test;

import java.util.ArrayList;
import java.util.List;

class GenericList<E> {
	private List<E> list = null;
	
	public GenericList() {
		list = new ArrayList<>();
	}
	
	public void add(E e) {
		list.add(e);
	}
	
	public E get(int i) {
		return list.get(i);
	}
	
	public int size() {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		return list.size();
	}
}
public class GenericTest {

	public static void main(String[] args) {
		GenericList<String> list = new GenericList<>();
		
		list.add("asdadasad");
		list.add("asasd");
		
		for (var i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		

	}

}
