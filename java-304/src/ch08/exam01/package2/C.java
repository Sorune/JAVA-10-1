package ch08.exam01.package2;

import ch08.exam01.package1.*;

public class C {

	A a1 = new A(true);		//public
	A a2 = new A(1);		//default
	A a3 = new A("hello");	//private
	
	A a = new A();
	B b = new B();

	public C() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 2;
		a.field3 = 3;
		
		a.method1();
		a.method2();
		a.method3();
	}
}
