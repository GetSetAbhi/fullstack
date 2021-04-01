package com.design.pattern.creational.factory;

abstract class Animal {
	abstract String makeSound(); 
}

class Dog extends Animal {
	@Override
	public String makeSound() {
		return "BOW BOW";	
	}
}

class Cat extends Animal {
	@Override
	public String makeSound() {
		return "Meow";
	}
}

class AnimalFactory {
	public static Animal getInstance(String name) {
		if (name.toUpperCase().equals("CAT")) {
			return new Cat();
		} else if (name.toUpperCase().equals("DOG")) {
			return new Dog();
		}
		return null;
	}
}

public class Factory {

	public static void main(String[] args) {
		Animal cat = AnimalFactory.getInstance("cat");
		Animal dog = AnimalFactory.getInstance("dog");
		System.out.println("Cat says : " + cat.makeSound());
		System.out.println("Dog says : " + dog.makeSound());

	}

}
