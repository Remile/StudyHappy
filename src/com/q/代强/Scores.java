package com.q.��ǿ;

import java.util.Arrays;

public class Scores {
	//��� main ����
	public static void main(String[] args) {
		Scores score = new Scores();
		int[] scores={89,-23,64,91,119,52,73};    
		score.sort(scores);
	}

	//���巽����ɳɼ��������ǰ�����Ĺ���
	public void sort(int[] scores){
		Arrays.sort(scores);
		int i = scores.length - 1;
		int num = 0;
		System.out.println("���Գɼ���ǰ����Ϊ:");
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
