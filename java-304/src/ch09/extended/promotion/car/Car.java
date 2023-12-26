package ch09.extended.promotion.car;

public class Car {
	//필드
	Tire frontLeft = new Tire("FrontLeft",10);
	Tire frontRight = new Tire("FrontRight",12);
	Tire rearLeft = new Tire("RearLeft",15);
	Tire rearRight = new Tire("RearRight",17);
	//생성자
	
	
	
	//메서드
	public int run() {
		int result = 0;
		if(!frontLeft.roll()) {
			stop();
			result = 1;
		} else if (!frontRight.roll()) {
			stop();
			result = 2;
		} else if (!rearLeft.roll()) {
			stop();
			result = 3;
		} else if(!rearRight.roll()) {
			stop();
			result = 4;
		} else {
			result = 0;
		}
		
		return result;
		
	}
	private void stop() {
		System.out.println("stop메서드 실행 - 자동차가 멈춥니다.");
	}
}
