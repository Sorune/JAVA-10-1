package ch05;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		// if는 판단을 해서 true와 false를 처리하는 함수
		Scanner in = new Scanner(System.in); //키보드로 입력을 받는 객체 생성
		while (true) {
		System.out.print("귀하의 점수를 입력하세요 : ");
		int score = in.nextInt(); //키보드로 입력한 정수값을 score변수에 넣는다.
		
			if (score > 100) {
				System.out.println("입력값이 100점 초과입니다. 다시 입력해주세요 : "+score);
			} else if (score >= 90) {
				System.out.println("점수가 90점 이상입니다. : "+score);
				System.out.println("귀하의 등급은 A등급 입니다.");
				break;
			} else if (score >= 80) {
				System.out.println("점수가 80점 이상입니다. : "+score);
				System.out.println("귀하의 등급은 B등급 입니다.");
				break;
			} else if (score >= 70) { 
				System.out.println("점수가 70점 이상입니다. : "+score);
				System.out.println("귀하의 등급은 C등급 입니다.");
				break;
			} else if (score >= 60) { 
				System.out.println("점수가 60점 이상입니다. : "+score);
				System.out.println("귀하의 등급은 D등급 입니다.");
				break;
			} else if (score < 0) {
				System.out.println("입력한 점수가 올바르지 않습니다. 프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("점수가 60점 미만입니다. : " + score);
				System.out.println("귀하의 등급은 F등급 입니다.");
				break;
			}
		}
	}

}
