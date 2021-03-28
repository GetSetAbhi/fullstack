package com.design.pattern.creational.abstractfactory;

interface Mammal {
	abstract void makeSound();
}

class Cow implements Mammal {
	@Override
	public void makeSound() {
		System.out.println("Cow says moo");	
	}
}

class Pig implements Mammal {
	@Override
	public void makeSound() {
		System.out.println("Pig says oink");	
	}
}

class Tiger implements Mammal {
	@Override
	public void makeSound() {
		System.out.println("Tiger says roar");	
	}
}

class Hyena implements Mammal {
	@Override
	public void makeSound() {
		System.out.println("Hyena says hehehehe");	
	}
}

abstract class MammalFactory {
	public abstract Mammal getMammal(String name);
}

class DomesticAnimalFactory extends MammalFactory {
	@Override
	public Mammal getMammal(String name) {
		if (name.toLowerCase().equals("cow")) {
			return new Cow();
		} else if (name.toLowerCase().equals("pig")) {
			return new Pig();
		}
		return null;
	}	
}

class WildAnimalFactory extends MammalFactory {
	@Override
	public Mammal getMammal(String name) {
		if (name.toLowerCase().equals("tiger")) {
			return new Tiger();
		} else if (name.toLowerCase().equals("hyena")) {
			return new Hyena();
		}
		return null;
	}
}

class AnimalFactory2 {
	public static MammalFactory getFactory(boolean isWild) {
		if (isWild) {
			return new WildAnimalFactory();
		} 
		return new DomesticAnimalFactory();
	}
}



public class AbstractFactory {

	public static void main(String[] args) {
		MammalFactory factory1 = AnimalFactory2.getFactory(true);
		Mammal animal1 = factory1.getMammal("tiger");
		Mammal animal2 = factory1.getMammal("hyena");
		animal1.makeSound();
		animal2.makeSound();
		
		System.out.println("#################");
		
		MammalFactory factory2 = AnimalFactory2.getFactory(false);
		Mammal danimal1 = factory2.getMammal("cow");
		Mammal danimal2 = factory2.getMammal("pig");
		danimal1.makeSound();
		danimal2.makeSound();

	}

}
