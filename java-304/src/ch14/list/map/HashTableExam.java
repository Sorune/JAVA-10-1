package ch14.list.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExam {
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("로그인 화면입니다");
			System.out.print("아이디 : ");
			String id = in.next();
			
			if(map.containsKey(id)) {

				System.out.print("비밀번호 : ");
				String pw = in.next();
				if(map.get(id).equals(pw)) {
					System.out.println("로그인 되었습니다.");
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			} else {
				System.out.println("아이디가 없습니다.");
			}
		}
	}
}
