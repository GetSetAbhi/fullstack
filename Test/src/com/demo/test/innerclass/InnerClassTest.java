package com.demo.test.innerclass;

import com.demo.test.innerclass.OuterClass.InnerClass;

class OuterClass {
	private int x = 10;
	
	public OuterClass(int x) {
		this.x = x;
	}

	class InnerClass {
		public int getX() {
			return x;
		}
	}
	
	private class InnerClass2 {
		public int getX() {
			return x;
		}
	}
	
	public int getInnerX() {
		return new InnerClass2().getX();
	}
}
public class InnerClassTest {

	public static void main(String[] args) {
		OuterClass o = new OuterClass(5);
		InnerClass i = o.new InnerClass();
		System.out.println("Public inner class : " + i.getX());
		System.out.println("Private inner class : " + i.getX());

	}

}
