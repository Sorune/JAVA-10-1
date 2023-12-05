package ch05;

import java.util.Scanner;

public class UpDownGame {
	public static void main(String[] args) {
		
		
		String keepGoing = "y";
		Scanner in = new Scanner(System.in);
		while (keepGoing.equals("y")) {
			int number = (int)(Math.random()*31)+1 , answer;
		
			do {
				System.out.print("숫자를 입력하세요 : ");
				answer = in.nextInt();
				
				if (answer > number) {
					System.out.println("down");
				} else if (answer < number) {
					System.out.println("up");
				}
			} while (answer != number);
			
			System.out.println("정답입니다! 정답은 : "+number);
			System.out.println("계속하시겠습니까? 계속하려면 y를 눌러주세요");
			keepGoing = in.next();
		}
	}
}
