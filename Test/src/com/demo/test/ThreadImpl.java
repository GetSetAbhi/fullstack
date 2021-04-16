package com.demo.test;

public class ThreadImpl extends Thread {
	
	private String locale;
	
	public ThreadImpl(String locale) {
		this.locale = locale;
	}

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("hello " + this.locale);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.notify();
		}
	}
}
