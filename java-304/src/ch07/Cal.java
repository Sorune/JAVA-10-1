package ch07;

public class Cal {
	
	double avg(int x, int y) {
		int sum = plus(x,y);
		return sum/2;
	}
	
	int plus(int x , int y) {
		return x+y;
	}
	
	void execute() {
		double result = avg(7,8);
		println("실행결과 : "+result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
}
