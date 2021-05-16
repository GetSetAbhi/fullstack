package com.demo.test.method_reference;

import java.util.function.BiFunction;

class Addition {
	public static int add(int a, int b) {
		return a + b;
	}
}

interface MessageInterface {
	void hello();
}

class Message {
	public void sayHello() {
		System.out.println("HELLO");
	}
}
public class MethodReferenceDemo {

	public static void main(String[] args) {
		// reference to static method
		BiFunction<Integer, Integer, Integer> adder = Addition::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
		
		// Reference to instance Method
		Message m = new Message();
		MessageInterface mi = m::sayHello;
		
		mi.hello();
	}

}
