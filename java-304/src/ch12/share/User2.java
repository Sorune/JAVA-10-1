package ch12.share;

public class User2 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator ) {
		this.setName("User2");
		this.calculator = calculator;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.calculator.setMemory(50);
	}
	
	
}
