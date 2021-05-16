package com.demo.test.Streams;

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (var i = 0;i < 5; i++) {
					System.out.println(i);
				}	
			}
		});
		
		t1.start();
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Second " + i);
			}
		});
		
		t2.start();
		
		Thread t3 = new Thread(() -> {
			while (true) {
				System.out.println("running....");
			}
		});
		t3.setDaemon(true);
		t3.start();
		t1.start();
		t2.start();

	}

}
