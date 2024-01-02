package ch10.trycatch.throwsexam;

import java.util.Scanner;

public class ThrowsExam {
	
	public static void main(String[] args) {
		//예외를 호출한 곳으로 떠넘기는 것 -> throw
		Scanner in = new Scanner(System.in);
		
		System.out.println("찾을 클래스를 입력하세요");
		System.out.print(">>> ");
		String input = in.next();
		
		String className = String.format("java.lang.%s", input);
		
		try {
			findClass(className);//메서드 호출
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 클래스가 존재하지 않습니다.");
//		} finally {
//			System.out.println("ctrl+f11로 다시 실행해주세요.");
		}
	}

	private static void findClass(String className) throws ClassNotFoundException {
		// TODO 클래스를 찾는 동작
		
		Class clazz = Class.forName(className);
		System.out.println("해당하는 클래스가 존재합니다.");
	}
	
}
