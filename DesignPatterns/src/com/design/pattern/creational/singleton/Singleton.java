package com.design.pattern.creational.singleton;

import java.io.Serializable;

public class Singleton {

	public static void main(String[] args) {
		SingletonEarly s1 = SingletonEarly.getInstance();
		SingletonEarly s2 = SingletonEarly.getInstance();
		System.out.println("S1 hashcode : " + s1);
		System.out.println("S2 hashcode :" + s2);
		
		System.out.println("#############################");
		System.out.println("#############################");
		
		SingletonLazy sl1 = SingletonLazy.getInstance();
		SingletonLazy sl2 = SingletonLazy.getInstance();
		System.out.println("SL1 hashcode : " + sl1);
		System.out.println("SL2 hashcode :" + sl2);

	}

}

class SingletonLazy implements Serializable {
	
	private static SingletonLazy instance = null;
	
	private SingletonLazy() {}
	
	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
	
	 protected Object readResolve()
	    {
	        return instance;
	    }

}

class SingletonEarly {

	private static SingletonEarly instance = new SingletonEarly();

	private SingletonEarly() {}

	public static SingletonEarly getInstance() {
		return instance;
	}

}
