package ch05;

public class WhilePrintExam {
	public static void main(String[] args) {
		//while 문은 정해진 횟수 제한 없이 개발자가 false처리를 해야 종료되는 반복문
		// while( true ) = 계속 반복
		// while( false ) = 중단
		int i = 1;
		while (i<= 10) {
			System.out.println("현재 값 : " + i);
			i++;
		}
	}
}
