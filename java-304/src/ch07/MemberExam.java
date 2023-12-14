package ch07;

import java.util.Scanner;

public class MemberExam {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		Member member = new Member();
		System.out.println("사용하실 ID를 입력해주세요.");
		System.out.print(">>> ");
//		String id = in.next();
		member.id = in.next();
		
		System.out.println("사용하실 PASS를 입력해주세요.");
		System.out.print(">>> ");
//		String pass = in.next();
		member.pass = in.next();
		
//		Member member = new Member(id,pass);
		System.out.println("나이를 입력해 주세요.");
		System.out.print(">>> ");
		member.age = in.nextInt();
		
		
		member.checkAge();
		
	}
}
