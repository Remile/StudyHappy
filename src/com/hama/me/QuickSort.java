package com.hama.me;

public class QuickSort {

	public static void main(String[] args) {
//		int[] array = {9,8,7,6,5,4,3,2,1};
		int[] array = {1,4,5,8,6,3,9,2,7};
		new QuickSort().sort(array, 0, array.length - 1);
		for(int i : array) {
			System.out.print( i + " ");
		}
	}

	public void sort(int [] array, int begin, int end) {
		if(begin < end) {
			// 选第一个作为关键字
			int key = array[begin];
			int m = begin ;
			for(int i = begin + 1 ; i <= end; i ++) {
				if(key >= array[i]) {
					m ++;
					int temp = array[m];
					array[m] = array[i];
					array[i] = temp;
//					swap(array[m], array[i]);
				}
			}
			array[begin] = array[m];
			array[m] = key;
//			swap(array[begin], array[m]);
			sort(array, begin, m - 1);
			sort(array, m + 1, end);
		}
	}
	
	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}
