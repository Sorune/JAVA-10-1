package ch09.extended.promotion.exam;

public class ChildExam {
	public static void main(String[] args) {
		Child c = new Child();
		Parents p = new Child(); 
		
		
		c.method1();
		//부모 메서드
		c.method2();
		c.method3();
		//자식 메서드
		
		p.method1();
		p.method2(); //오버라이딩된 자식 메서드
		//부모 메서드
		
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
