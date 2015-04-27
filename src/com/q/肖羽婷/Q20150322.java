package com.q.肖羽婷;

public class Q20150322 {
	public static void main(String[] args) {
		Lader.bottom=60;
		Lader laderOne,laderTwo;
		System.out.println("现在所有Lader对象的bottom都是"+Lader.bottom);
		laderOne=new Lader();
		laderTwo=new Lader();
		System.out.println("laderOne的bottom:"+laderOne.getBottom());
		System.out.println("laderTwo的bottom:"+laderTwo.getBottom());
		laderOne.setAbove(11);
		laderTwo.setAbove(22);
		laderTwo.setBottom(100);
		System.out.println("现在所有Lader对象的bottom都是"+Lader.bottom);
		System.out.println("laderOne的above:"+laderOne.getAbove());
		System.out.println("laderTwo的above:"+laderTwo.getAbove());
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