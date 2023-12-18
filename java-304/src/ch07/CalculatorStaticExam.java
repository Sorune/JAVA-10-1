package ch07;

public class CalculatorStaticExam {
	public static void main(String[] args) {
		// 정적 메서드를 호출하는 주 메서드
		CalculatorStatic myCalc = new CalculatorStatic(); //인스턴스용
		
		double result1 = 10*10*myCalc.pi;
		
		System.out.println(result1);
		int result5 = myCalc.plus(20, 30);
		System.out.println(result5);
		// 인스턴스 없이 바로 실행
		
		double result2 = 10*10*CalculatorStatic.pi;
		
		System.out.println(result2);
		CalculatorStatic.pi = 4;
		double result3 = 10*10*CalculatorStatic.pi;
		System.out.println(result3);
		double result4 = 10*10*CalculatorStatic.PI;
		System.out.println(result4);
		int result6 = CalculatorStatic.plus(20, 30);
		System.out.println(result6);
	}
}
