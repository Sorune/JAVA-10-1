package ch10.clientexception;

import java.util.Scanner;

public class LoginExam {
	public static void main(String[] args) {
		//id와 password를 검증하여 예외처리
		Scanner in = new Scanner(System.in);
		System.out.println("id를 입력하세요");
		System.out.print(">>> ");
		String id = in.next();
		System.out.println("pw를 입력하세요");
		System.out.print(">>> ");
		String pw = in.next();
		
		try {
			login(id,pw);
		} catch (NotExistIdException | WrongPasswordException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	private static void login(String id, String pw) throws NotExistIdException, WrongPasswordException {
		// TODO Auto-generated method stub
		if(!id.equals("kkw")) {
			throw new NotExistIdException("아이디가 존재하지 않습니다.");
		} else {
			if(!pw.equals("123")) {
				throw new WrongPasswordException("비밀번호가 일치하지 않습니다.");
			}
		}
	}
}
