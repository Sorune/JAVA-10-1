package ch09.extended.promotion.car;

import java.util.Scanner;

public class CarExam {
	public static void main(String[] args) throws InterruptedException {
		//자동차 주행 및 타이어 교환 코드
		
		
		
		Car myCar = new Car();
		Scanner in = new Scanner(System.in);
		int result = 0 ;
		do {
			Thread.sleep(500);
			int problemLocation = myCar.run();

			switch(problemLocation) {
			case 1:
				System.out.println("교체할 타이어를 선핵하세요");
				System.out.println("1. 한국타이어(20만원) 2. 금호타이어(15만원) 3. OEM타이어(13만원)");
				System.out.print(">>> ");
				int selectTire = in.nextInt();
				if (selectTire == 1) {
					myCar.frontLeft = new HankookTire("FrontLeft",30);
				} else if (selectTire == 2) {
					myCar.frontLeft = new KumhoTire("FrontLeft",30);
				} else {
					myCar.frontLeft = new Tire("FrontLeft",30);
				}
				break;
			case 2:
				System.out.println("교체할 타이어를 선핵하세요");
				System.out.println("1. 한국타이어(20만원) 2. 금호타이어(15만원) 3. OEM타이어(13만원)");
				System.out.print(">>> ");
				selectTire = in.nextInt();
				if (selectTire == 1) {
					myCar.frontRight = new HankookTire("FrontRight",30);
				} else if (selectTire == 2) {
					myCar.frontRight = new KumhoTire("FrontRight",30);
				} else {
					myCar.frontRight = new Tire("FrontRight",30);
				}
				break;
			case 3:
				System.out.println("교체할 타이어를 선핵하세요");
				System.out.println("1. 한국타이어(20만원) 2. 금호타이어(15만원) 3. OEM타이어(13만원)");
				System.out.print(">>> ");
				selectTire = in.nextInt();
				if (selectTire == 1) {
					myCar.rearLeft = new HankookTire("RearLeft",30);
				} else if (selectTire == 2) {
					myCar.rearLeft = new KumhoTire("RearLeft",30);
				} else {
					myCar.rearLeft = new Tire("RearLeft",30);
				}
				break;
			case 4:
				System.out.println("교체할 타이어를 선핵하세요");
				System.out.println("1. 한국타이어(20만원) 2. 금호타이어(15만원) 3. OEM타이어(13만원)");
				System.out.print(">>> ");
				selectTire = in.nextInt();
				if (selectTire == 1) {
					myCar.rearRight = new HankookTire("RearRight",30);
				} else if (selectTire == 2) {
					myCar.rearRight = new KumhoTire("RearRight",30);
				} else {
					myCar.rearRight = new Tire("RearRight",30);
				}
				break;
			}
		} while(result==0);
		
	}
}
