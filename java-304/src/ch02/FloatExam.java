package ch02;

public class FloatExam {

	public static void main(String[] args) {
		// 실수형처리용 double과 float의 차이점 분석
		// 실수처리에 기본은 double이다.
		// float은 처리범위가 32bit이기 때문에 정확성이 떨어진다.
		// float은 실수 뒤에 F를 써야한다.
		
		double var1 = 3.14;
		float var2 = 3.14F;
		
		//정밀도 테스트
		
		double var4 = 0.123456789123456789;
		float var5 = 0.123456789123456789F;
		
		System.out.println(var1);
		System.out.println(var2);

		System.out.println(var4);
		System.out.println(var5);

	}

}
