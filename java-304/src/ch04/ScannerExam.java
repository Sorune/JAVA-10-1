package ch04;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		//앞으로는 키보드로 입력된 값을 처리하려 한다.
		//scanner 객체를 사용하여 콘솔에 입력할 수 있도록 할 것이다.
		//Scanner타입 변수명 = new Scanner(System.in) 객체 생성
		Scanner in = new Scanner(System.in); //스캐너 객체로 입력받는다.
		int x = in.nextInt();//콘솔에 정수값을 입력 받을 수 있다.
		int y = in.nextInt();
		System.out.printf("%d * %d은 %d입니다.\n",x,y,x*y);
	}
}
