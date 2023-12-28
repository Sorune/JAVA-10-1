package ch09.interfaceexam.vehicle;

import java.util.Scanner;

public class VehicleExam {
	public static void main(String[] args) {

		Driver d = new Driver();
		Vehicle bus = new Bus();
//		Texi texi = new Texi();
		
		Scanner in = new Scanner(System.in);
		System.out.println("______________________________________");
		System.out.println("출근길에 탈 것을 선택하세요.");
		System.out.println("1. 버스 \t2.택시");
		System.out.println("______________________________________");
		System.out.print(">>> ");
		int select = in.nextInt();
		switch(select) {
		case 1:
			d.run(new Bus());
			Bus tmp = (Bus) bus;

			System.out.println("______________________________________");
			System.out.println("결제수단을 선택하세요.");
			System.out.println("1. 버스카드 \t2. 핸드폰 \t3. 현금");
			System.out.println("______________________________________");
			System.out.print(">>> ");
			tmp.checkFare(in.nextInt());
			break;
		case 2:
			d.run(new Texi());
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
		
		
	}
}
