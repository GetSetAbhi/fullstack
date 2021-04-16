package com.demo.test.functional_interface;

interface Functional1 {
	default void hello() {
		System.out.println("Calling from default");
	}
}

class MainClass implements Functional1 {
	@Override
	public void hello() {
		Functional1.super.hello();
	}
}
public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
