package ch05;

public class ForExam {
	public static void main(String[] args) {
		// for 문은 반복되는 함수로 최대값을 가지고 있다.
		for (int i = 2; i<10; i++) {
			System.out.printf("*** %d단 ***\n",i);
			for (int j = 1;j<10;j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}
	}
}
