package com.demo.test.Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsDemo {

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
		
		list.stream().sorted((a, b) -> {
			return a.getRating() - b.getRating();
		}).forEach(item -> {
			System.out.println(item.getName() + " " + item.getRating());
		});
		
		System.out.println("#################################################");
		
		// getting the highest rated movie
		Movie high = list.stream().max((a, b) -> {
			return a.getRating() - b.getRating();
		}).get();
		
		System.out.println("Highest rated movie is : " + high.getName() + ", " + high.getRating());

		System.out.println("#################################################");
		
		// average rating of all movies
		
		Double averageRating = list.stream().mapToDouble(item -> Double.valueOf(item.getRating())).average().getAsDouble();
		System.out.println("Average Rating is : " + averageRating);
	}

}
