package com.design.pattern.creational.prototype;

class I10 implements Cloneable {
	
	private String versionName;
	private String brandName;
	
	public I10(String versionName, String brandName) {
		this.versionName = versionName;
		this.brandName = brandName;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		I10 i10 = new I10("i10", "hyndai");
		System.out.println("I10 says : " + i10.getVersionName());
		
		I10 i20 = (I10) i10.clone();
		i20.setVersionName("i20");
		System.out.println("I20 says : " + i20.getVersionName() + ", brand name : " + i20.getBrandName());
		i10.setBrandName("blagg");
		System.out.println("I10 says : " + i10.getVersionName() + ", brand name : " + i10.getBrandName());
		System.out.println("I10 " + i10);
		System.out.println("I20 " + i20);
	}

}
