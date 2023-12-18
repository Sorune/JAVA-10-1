package ch07;

public class CalculatorStatic {
	//계산기를 정적필드와 정적메서드로 구현 해본다.
	// 필드와 메서드 앞에 Static을 붙이면 정적으로 동작한다.
	//정적으로 동작하는 필드와 메서드는 new 없이 사용한다.
	
	// 정적 필드
	static double pi = 3.14159;//정적 필드 선언
	final static double PI = 3.14159;
	// 생성자 -> static 멤버에는 생성자가 없다. (new 연산자 미사용)
	
	
	// 정적 메서드
	static int plus (int x , int y ) {
		return x + y;
	}
	
	static double plus (double x , double y ) {
		return x+y;
	}
	
	static int minus (int x , int y) {
		return x - y;
	}
	
	static double minus (double x , double y ) {
		return x - y;
	}
}
