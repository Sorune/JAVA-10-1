package ch08.exam01.package1;

public class B {  //public 접근제한
	//public은 아무나 모두 접근 가능

	A a1 = new A(true);		//public
	A a2 = new A(1);		//default
	A a3 = new A("hello");	//private
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 2;
		a.field3 = 3;
		
		a.method1();
		a.method2();
		a.method3();
	}
}
