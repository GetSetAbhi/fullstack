package com.demo.test.trycatch;


class Demo {
	public final int add() {
		return 0;
	}
	
	public float add(int a) {
		return a;
	}
}

class Demo2 extends Demo {
}
public class TryCatchDemo {
	
	public String demo(int a) {
		try {
			if (a == 1) {
				return "safe";
			} else if (a == 2) {
				throw new Exception("Khatra");
			}
			System.exit(0);
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			return "always";
		}
	}

	public static void main(String[] args) {
		TryCatchDemo t = new TryCatchDemo();
		System.out.println(t.demo(1));
		System.out.println(t.demo(2));
		System.out.println(t.demo(3));
	}

}
