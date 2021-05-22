package com.demo.test.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Grouping {

	public static void main(String[] args) {

		Movie one = new Movie(7, "Avengers 1", 2012);
		Movie two = new Movie(6, "Avengers Age of Ultron", 2015);
		Movie three = new Movie(8, "Avengers Infinity War", 2018);
		Movie four = new Movie(9, "Avengers Endgame", 2019);
		
		List<Movie> list = new ArrayList<>();
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		
		Map<Integer, List<String>> map = list.stream().collect(Collectors.groupingBy(Movie::getYear, Collectors.mapping(Movie::getName, Collectors.toList())));
		
		Map<Integer, List<Movie>> map2 = list.stream().collect(Collectors.groupingBy(Movie::getYear, Collectors.toList()));

		Set<Integer> keySet = map.keySet();
		if (!keySet.isEmpty()) {
			for (Integer key : keySet) {
				List<String> l = map.get(key);
				System.out.println("#" + key);
				if (!l.isEmpty()) {
					l.forEach(item -> System.out.print(item + " "));
				}
				System.out.println("############################");
			}
		}
		
		for (Map.Entry<Integer, List<Movie>> e : map2.entrySet()) {
			
		}
	}

}
