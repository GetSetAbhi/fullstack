package com.design.pattern.structural.facade;

interface Phone {
	void makeSale();
}

class Iphone implements Phone {
	@Override
	public void makeSale() {
		System.out.println("IPhone is sold");
	}
}

class Samsung implements Phone {
	@Override
	public void makeSale() {
		System.out.println("Samsung is sold");
	}
}

class PhoneShop {
	private String name;
	private Iphone iphone;
	private Samsung samsung;
	
	public PhoneShop(String phoneName) {
		this.name = phoneName;
		this.iphone = new Iphone();
		this.samsung = new Samsung();
	}
	
	public void purchase() {
		switch (this.name.toLowerCase()) {
			case "samsung" :
				samsung.makeSale();
				break;
			case "iphone" :
				iphone.makeSale();
				break;
			default:
				System.out.println(this.name + " phone is unavailable in our shop.");
		}
	}
}

public class Facade {

	public static void main(String[] args) {
		PhoneShop p = new PhoneShop("android");
		p.purchase();

	}

}
