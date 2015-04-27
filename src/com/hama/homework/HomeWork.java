package com.hama.homework;

public class HomeWork {
	
	// 静态初始化块
	static {
		System.out.println("静态初始化块");
		init();
	}
	
	// 一个初始化方法
	public static void init() {
		System.out.println("假装我就初始化了");
	}
	
	// 这是一个类变量
	public static final int arg1 = 1;
	
	// 这是两个成员变量
	private String arg2;
	private int arg3;
	
	public String getArg2() {
		return arg2;
	}
	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}
	public int getArg3() {
		return arg3;
	}
	public void setArg3(int arg3) {
		this.arg3 = arg3;
	}
	
	public void process() {
		// 下面是一个局部变量
		int arg4 = 2;
		System.out.println("局部变量arg4:" + arg4);
	}
	
	public static void main(String[] args) {
		HomeWork work = new HomeWork();
		work.process();
	}
	
}
