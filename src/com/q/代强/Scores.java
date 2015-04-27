package com.q.代强;

import java.util.Arrays;

public class Scores {
	//完成 main 方法
	public static void main(String[] args) {
		Scores score = new Scores();
		int[] scores={89,-23,64,91,119,52,73};    
		score.sort(scores);
	}

	//定义方法完成成绩排序并输出前三名的功能
	public void sort(int[] scores){
		Arrays.sort(scores);
		int i = scores.length - 1;
		int num = 0;
		System.out.println("考试成绩的前三名为:");
		while(num < 3) {
			if((scores[i] >= 0) && (scores[i] <= 100)) {
				System.out.println(scores[i]);
				num ++;
				i --;
			}else {
				i --;
			}
		}
	}
}
