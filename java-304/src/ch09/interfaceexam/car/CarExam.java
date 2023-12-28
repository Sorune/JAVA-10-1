package ch09.interfaceexam.car;

public class CarExam {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.tires[0] = new KumhoTire();
		myCar.tires[1] = new HankookTire();
		myCar.run();
	}
}
