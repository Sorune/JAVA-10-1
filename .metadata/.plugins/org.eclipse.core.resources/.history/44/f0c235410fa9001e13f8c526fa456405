package ch09.nestedclass;

public class AExam {
	public static void main(String[] args) {
		// 이너 클래스
		A a = new A();
		
		A.B.field2 = 50;
		A.B.method2();
		
		A.B b = a.new B();
		
//		A.B b1 = new A.B();
		
		b.field1 = 10;
		b.method1();
		
		a.method1();
		
		A.C.method2();
		A.C.field2 = 20;
		
		A.C c = new A.C();
//		A.C c1 = a.new C();
		
		c.field1 = 30;
		c.method1();
		
	}
}
