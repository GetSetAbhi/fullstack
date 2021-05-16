package com.demo.test;

public class Test {
	
	public void loop() {
		String[] list = {"yo", "bro", "haha", "hehe"};
		for (String locale: list) {
			ThreadImpl t = new ThreadImpl(locale);
			t.start();
			synchronized (t) {
				try {
					t.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("###########");
		}
	}

	public static void main(String[] args) {
		new Test().loop();

	}

}
