package ch07;

public class CarRunGas {
	// 자동차 주행용 가스측적용
	
	int gas;
	
	CarRunGas(){
		
	}
	
	void setGas(int gas) {
		this.gas = gas;
		System.out.println("현재 가스량 : "+this.gas);
	}
	
	boolean isLeftGas() {
		if(this.gas != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	void run() {
		if(this.gas!=0) {
			System.out.println("차가 달립니다.");
			this.gas -= 1;
			System.out.println("현재 가스량 : "+this.gas);	
		}
		else {
			System.out.println("가스가 없습니다.");
			System.out.println("차가 멈춥니다.");
		}
	}
	
}
