package ch09.interfaceexam.vehicle;

public class Bus implements Vehicle{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare(int select) {
		if(select == 1) {
			System.out.println("버스카드로 결제됩니다.");
		} else if(select == 2) {
			System.out.println("핸드폰으로 결제됩니다.");
		} else {
			System.out.println("현금으로 결제됩니다.");
		}
	}

}
