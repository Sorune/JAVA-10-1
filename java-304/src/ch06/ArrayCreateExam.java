package ch06;

public class ArrayCreateExam {
	public static void main(String[] args) {
		int[] scores = {80,20,40,30,50};
		int sum = 0;
		for (int i=0;i<scores.length;i++) {
			sum+=scores[i];
		}

		System.out.printf("점수의 총점은 %d입니다.\n",sum);
		System.out.printf("점수의 평균은 %d입니다.\n",sum/scores.length);
		
		
	}
}
