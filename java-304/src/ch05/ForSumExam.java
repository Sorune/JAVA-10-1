package ch05;

import java.util.*;

public class ForSumExam {
	public static void main(String[] args) {
		// 1부터 100까지의 합을 구해본다.
		
		Scanner in = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("최대값을 입력하세요 : ");
		int max = in.nextInt();
		
		for (int i = 1; i<=max; i++) {
			System.out.printf("%d + %d = ",sum,i);
			sum += i;
			System.out.println(sum);
		}
		
		System.out.println(sum);
	}
}
