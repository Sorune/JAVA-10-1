package ch05;

public class BreakExam {
	public static void main(String[] args) {
		//반복문이나 switch문에서 break 처리시 루프를 중지함
		
		int i = 0;
		
		while (true) {
			int number = (int)(Math.random()*45)+1;
			i++;
			System.out.printf("오늘의 로또번호 : %d\n",number);
			if (i==6) {
				System.out.println("로또 프로그램 종료");
				break;
			}
			
		}
	}
}
