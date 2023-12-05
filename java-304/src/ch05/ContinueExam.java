package ch05;

public class ContinueExam {
	public static void main(String[] args) {
		//continue문은 반복문을 종료하지 않고 계속 반복문을 수행
		//for 문의 증강식 또는 while 문의 조건식으로 이동
		
		for (int i = 1; i<= 10 ;i++) {
			if(i%2!=0) {
				System.out.println(i+"는 짝수가 아님");
				continue;
				// continue 아래는 실행이 안됨
			}
			System.out.println(i);
		}
	}
}
