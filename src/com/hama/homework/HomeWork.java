package com.hama.homework;

public class HomeWork {
	
	// ��̬��ʼ����
	static {
		System.out.println("��̬��ʼ����");
		init();
	}
	
	// һ����ʼ������
	public static void init() {
		System.out.println("��װ�Ҿͳ�ʼ����");
	}
	
	// ����һ�������
	public static final int arg1 = 1;
	
	// ����������Ա����
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
		// ������һ���ֲ�����
		int arg4 = 2;
		System.out.println("�ֲ�����arg4:" + arg4);
	}
	
	public static void main(String[] args) {
		HomeWork work = new HomeWork();
		work.process();
	}
	
}
