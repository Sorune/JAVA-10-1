package ch09.interfaceexam.car;

public class Car {
	Tire[] tires = new Tire[5];
	
	Car(){
		tires[0] = new HankookTire();
		tires[1] = new KumhoTire();
		tires[2] = new HankookTire();
		tires[3] = new KumhoTire();
		tires[4] = new Tire() {

			@Override
			public void roll() {
				System.out.println("비상용 스페어 타이어 입니다.");
				
			}
			
		};
	}
	
	void run() {
		for (int i = 0 ; i < 4 ; i ++) {
			tires[i].roll();
		}
	}
}
