package ch05;

public class WhileSumExam {
	public static void main(String[] args) {
		// 1부터 100까지의 누적 합
		
		int i = 1;
		
		int sum = 0;
		
		while ( i<=100 ) {
			System.out.print(sum);
			sum += i;
			System.out.printf(" + %d = %d\n",i,sum);
			i++;
		}
	}
}
