package ch05;

import java.util.*;

public class DiceExam {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num = (int)(Math.random() * 6) +1;
		System.out.println("주사위 값 : " + num);
		
		if (num == 1) {
			System.out.println("1번 값이 나왔습니다. 1차적으로 한잔하세요");
		} else if(num == 2) {
			System.out.println("2번 값이 나왔습니다. 2칸 옆자리와 한잔하세요");
		} else if(num == 3) {
			System.out.println("3번 값이 나왔습니다. 3잔을 마시면 됩니다");
		} else if(num == 4) {
			System.out.println("4번 값이 나왔습니다. 빨대로 4번 흡입하세요");
		} else if(num == 5) {
			System.out.println("5번 값이 나왔습니다. 옆자리 한잔 드세요");
		} else if (num==6) {
			System.out.println("6번 값이 나왔습니다. 춤을 추시면서 집에 가시면 됩니다");
		} else {
			System.out.println("프로그램 오류 개발자에게 7잔 먹이세요");
		}
	}
}
