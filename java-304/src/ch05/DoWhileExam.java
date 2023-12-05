package ch05;

import java.util.Scanner;

public class DoWhileExam {
	public static void main(String[] args) {
		// do {실행문} while (조건문){}
		// do-while문은 실행문을 한번은 무조건 처리한다.
		
		System.out.println("채팅 프로그램에 오신 것을 환영합니다.");
		System.out.println("프로그램을 종료하려면 \'q\'를 입력하세요");
		
		Scanner in = new Scanner(System.in);
		String inputString;
		do {
			//처음 실행되는 문
			System.out.print(">>>");
			inputString = in.nextLine();
			System.out.printf("전송값 : %s\n",inputString);
		} while (!inputString.equals("q"));
		System.out.println("프로그램을 종료합니다");
	}
}
