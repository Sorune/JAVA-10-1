package ch07;

public class CalculatorExam {
	public static void main(String[] args) {
		Calculator myCal = new Calculator();
		
		myCal.powerOn();

		System.out.println(myCal.add(1,2,3,4,5,6,7,8,9));
		System.out.println(myCal.add(12.5, 0.5));
		System.out.println(myCal.min(12.5, 0.5));
		System.out.println(myCal.mul(12.5, 0.5));
		System.out.println(myCal.div(12.5, 0.5));
		System.out.println(myCal.remain(12.5, 0.5));
		
		myCal.powerOff();
	}
}
