package ch09.extended.override;

public class Computer extends Calculator{

	@Override
	double areaCircle(double r) {
		// TODO Auto-generated method stub
		System.out.println(super.areaCircle(r));
		System.out.println("Computer객체의 areaCircle메서드 실행");
		double result = Math.PI*r*r; 
		return result;
	}
	//자식 클래스
	
	
	
//	double areaCirCle(double r) {
//		System.out.println("Computer객체의 areaCircle메서드 실행");
//		return Math.PI * r * r;
//	}
//	

}
