package com.q.Ф����;

public class Q20150322 {
	public static void main(String[] args) {
		Lader.bottom=60;
		Lader laderOne,laderTwo;
		System.out.println("��������Lader�����bottom����"+Lader.bottom);
		laderOne=new Lader();
		laderTwo=new Lader();
		System.out.println("laderOne��bottom:"+laderOne.getBottom());
		System.out.println("laderTwo��bottom:"+laderTwo.getBottom());
		laderOne.setAbove(11);
		laderTwo.setAbove(22);
		laderTwo.setBottom(100);
		System.out.println("��������Lader�����bottom����"+Lader.bottom);
		System.out.println("laderOne��above:"+laderOne.getAbove());
		System.out.println("laderTwo��above:"+laderTwo.getAbove());
		System.out.println(laderOne.getBottom());
	}
}
class Lader {
	double above,height;
	static double bottom;
	void setAbove(double a){
		above=a;

	}
	void setBottom(double b){
		bottom=b;
	}
	double getAbove(){
		return above;
	}
	double getBottom(){
		return bottom;
	}

}