package com.q.������;

public class Student {
	
	public Student() {
		System.out.println("I'm student");
	}
	
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void func1() {
		System.out.println("���Ǻ���1");
	}
	
	public void func2() {
		System.out.println("���Ǻ���2");
	}
	
	public void func3() {
		System.out.println("���Ǻ���3");
	}
	
}
