package com.demo.test;

class A {
	protected void hello() {
		System.out.println("A");
	}
}

class B extends A {
	@Override
	protected void hello() {
		System.out.println("B");
		super.hello();
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		B b = new B();
		b.hello();

	}

}
