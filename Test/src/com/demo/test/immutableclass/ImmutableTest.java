package com.demo.test.immutableclass;


class Age {
	private int age;
	public Age(int age) {
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

final class ImmutableStudent {
	private final String name;
	private final Age age;
	
	public ImmutableStudent(String name, Age age) {
		this.name = name;
		this.age = new Age(age.getAge());
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		return new Age(age.getAge());
	}
}
public class ImmutableTest {

	public static void main(String[] args) {

	}

}
