package ch06;

public class ArrayCreateExam {
	public static void main(String[] args) {
		int[] scores;
		scores = new int[]{83,24,42,37,58,87,98,27,79};
		int sum = 0;
		
		for (int i=0;i<scores.length;i++) {
			sum+=scores[i];
		}
		
		double avg = sum/scores.length;
		System.out.printf("점수의 총점은 %d입니다.\n",sum);
		System.out.printf("점수의 평균은 %f입니다.\n",avg);
		
		
	}
}
