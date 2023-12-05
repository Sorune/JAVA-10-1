package ch05;

import java.util.*;

public class DiceGame {
	public static void main(String[] args) {
		
		while(true) {
			int dice = (int)(Math.random()*6) + 1;
			
			Scanner input = new Scanner(System.in);
			
			System.out.print("숫자를 입력해주세요(1~6) : ");
			int number = input.nextInt();
			
			if ((number > 6) || (number < 0)) {
				System.out.println("주사위 눈금을 입력해 주세요. 범위는 1~6입니다.");
				continue;
			} else {
				
				if (number == dice) {
					System.out.println("주사위 눈금은 : " + dice + "입니다.");
					System.out.print("정답입니다. 계속 진행하시겠습니까?(y/n) : ");
				} else {
					System.out.println("주사위 눈금은 : " + dice + "입니다.");
					System.out.print("오답입니다. 계속 진행하시겠습니까?(y/n) : ");
				
				}
				String answer = input.next();
				
				if (answer.equals("y")) {
					continue;
				} else {
					break;
				}
			}
		}
		
	}
}
