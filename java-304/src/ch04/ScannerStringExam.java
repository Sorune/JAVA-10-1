package ch04;

import java.util.Scanner;

public class ScannerStringExam {

	public static void main(String[] args) {
		//키보드로 입력받는 내용이 문자열일 경우에는 next(), nextLine()을 사용한다.
		Scanner input = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String x = input.next();
		System.out.print("나이를 입력하세요 : ");
		String y = input.next();
		System.out.print("이메일을 입력하세요 : ");
		String z = input.next();
		System.out.printf("안녕하세요. 저는 %s입니다. 나이는 %s입니다. 제 이메일은 %s입니다.",x,y,z);
	}
}
