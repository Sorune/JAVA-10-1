package ch05;

import java.io.IOException;
import java.util.*;

public class WhileExam {
	public static void main(String[] args) throws IOException { //throws IOException : 키보드 예외처리
		// 키보드의 입력을 받아서 제어하는 실행문
		// system.in.read()메서드 활용하여 유니코드 활용
		// 차량의 정속주행(크루즈)기능을 만들어 보겠다.
		// 1번을 누르면 가속, 2ㅓㅂㄴ을 누르면 감속, 3번을 누르면 중지
		
		boolean run = true; // while문 실행 여부
		int speed = 100; // 현재 시속
		int keyCode = 0; // 키보드로 입력되는 문자를 숫자로 판단
//		int time = (int)System.currentTimeMillis(), existTime = 0 , remainTime = 0, currentTime = 0;
		System.out.println("크루즈 기능을 시작합니다.");
		
		while (run) {
//			time = (int)System.currentTimeMillis();
//			System.out.println(existTime - time);
			if(keyCode != 13 && keyCode != 10) {
				System.out.println("--------------------------------");
				System.out.println("1. 액셀 \t 2. 브레이크 \t 3. 정지");
				System.out.println("--------------------------------");
				System.out.print("선택 : ");
			} // 엔터치기 전까지의 유니코드 값을 확인하는 단계
			
			keyCode = System.in.read();
			
				
			if (keyCode == 49) {
				speed += 10;
				if(speed >= 160 ) {
					System.out.println("속도가 너무 빠릅니다");
					System.out.println("제한속도 이내로 유지합니다");
					speed = 150 ;
					System.out.printf("현재 속도는 %dkm/h입니다.\n",speed);
				} else {
				System.out.printf("현재 속도는 %dkm/h입니다.\n",speed);
				}
			} else if (keyCode == 50) {
				speed -= 10;
				if(speed <= 50 ) {
					System.out.println("속도가 너무 느립니다");
					System.out.println("제한속도 이내로 유지합니다");
					speed = 50 ;
					System.out.printf("현재 속도는 %dkm/h입니다.\n",speed);
				} else {
				System.out.printf("현재 속도는 %dkm/h입니다.\n",speed);
				}
			} else if (keyCode == 51) {
				run = false;

				System.out.println("크루즈 기능이 종료되었습니다.");
				System.out.printf("현재 속도는 %dkm/h입니다.\n",speed);
				System.out.println("안전운행하세요!!");
			} 
//			else if (keyCode == 52) {
//				System.out.println("지속 운행을 시작합니다.");
//				System.err.print("운행 시간을 입력해 주세요(초) : ");
//				currentTime = System.in.read();
//				existTime = time;
//			}
			
		}

		System.out.println("프로그램을 종료합니다.");
		
	}
}
