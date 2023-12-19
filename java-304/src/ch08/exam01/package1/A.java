package ch08.exam01.package1;

public class A { //default 접근 제한
	// public을 삭제하면 default 접근 제한을 같는다.
	// default는 같은 패키지 내에서만 접근 가능하다.
	public int field1;
	int field2;
	private int field3;
	
	
	A a1 = new A(true);		//public
	A a2 = new A(1);		//default
	A a3 = new A("hello");	//private
	
	
	
	
	public A(boolean b) {}// 공용 생성자
	A(int b) {} // 디폴트 생성자
	private A(String s) {} // 개인 생성자
	
	
	public A() {
		field1 = 1;
		field2 = 2;
		field3 = 3;
	
		method1();
		method2();
		method3();
	}
	
	public void method1() {}
	void method2() {}
	private void method3() {}
}
