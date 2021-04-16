package com.demo.test.ThreadDemo;

class CustomThread extends Thread {

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Counting " + i);
			}
			notify();
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		System.out.println("Main Thread started");
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (this) {
					for (int i = 0; i < 5; i++) {
						System.out.println("Counting " + i);
					}
					notify();
				}
			}
		});
		
		thread.start();
		synchronized (thread) {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Main Thread Ended");

	}

}
