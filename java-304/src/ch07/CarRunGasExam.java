package ch07;

import java.util.Scanner;

public class CarRunGasExam {
	public static void main(String[] args) throws InterruptedException {
		CarRunGas myCar = new CarRunGas();
		Scanner in = new Scanner(System.in);
		myCar.setGas(10);
		myCar.isLeftGas();
		
		while (myCar.isLeftGas()) {
			
			Thread.sleep(500);
			
			if (myCar.isLeftGas()) {
				myCar.run();
				if(myCar.gas <= 3) {
					System.out.println("가스가 모자랍니다. 주유소로 갈까요?");
					String answer = in.next();
					if(answer.equals("y")) {
						int gas = in.nextInt();
						myCar.setGas(gas);
					}
				}
			} else {
				myCar.run();
				break;
			}
		}
		myCar.run();
	}
}
