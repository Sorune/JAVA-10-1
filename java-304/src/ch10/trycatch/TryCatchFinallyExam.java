package ch10.trycatch;

import java.util.Scanner;

public class TryCatchFinallyExam {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		int numData = 0;
		double dobData = 0;
		try {
			System.out.println("------------------------------");
			System.out.println("숫자 2개를 입력하세요");
			System.out.print("숫자 1(정수) : ");
			data1 = in.next();
			System.out.print("숫자 2(실수) : ");
			data2 = in.next();
			
			numData = Integer.parseInt(data1);
			dobData = Double.parseDouble(data2);
			

			System.out.println("두 수의 합은 다음과 같습니다.");
			System.out.printf("%d + %.2f = %.2f",numData,dobData,numData+dobData);
		} catch (NumberFormatException e) { // 숫자 형식 변환 예외처리
			System.out.println("잘못된 숫자 입력입니다.");
		} catch (NullPointerException e) {
			System.out.println("값이 입력되지 않았습니다.");
		} finally {
			System.out.println("다시 실행은 ctrl+f11을 입력하세요");
		}
		
	}
}