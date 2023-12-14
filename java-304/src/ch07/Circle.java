package ch07;

public class Circle { // 라이브러리 클래스로 인스턴스(객체용)
	//필드 : 클래스에서 사용될 변수
	public int radius; // main메서드에서 Circle.radius = 10;
	public String name; // Circle.name = "김기원";
	
	
	//생성자 : 클래스를 호출할때 new 연산자를 사용
	public Circle() {//생성자는 클래스명과 같은 메서드
		
	}//main 메서드에서 Circle circle = new Circle();
	
	
	
	//메서드 : 동작 부분
	public double getArea() {//원의 면적을 계산
		double result ;
		result = radius*radius*3.14;
		return result;
	}
}
