package ch05;

import java.util.Scanner;

public class SsnExam {
	public static void main(String[] args) {
		System.out.print("당신의 주민번호를 입력하시오(010101-1234567)>");
		Scanner in = new Scanner(System.in);
		String regNo = in.nextLine();
		char gender = regNo.charAt(7);
		
		switch(Character.getNumericValue(gender)%2) {
		case 0:
			System.out.println("여자입니다");
			break;
		case 1:
			System.out.println("남자입니다");
			break;
			
		default : 
			System.out.println("양성..? or 중성...? 누구세요");
			break;
		}
	}
}
