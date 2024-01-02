package ch09.nestedclass;

public class A {
	//new 연산자를 사용해야 하는 인스턴스(객체)
	//필드
	public class B {
		//필드
		int field1;
		static int field2; //17버전 이후로 가능
		
		//생성자
		B(){}
		
		
		//메서드
		void method1() {
			System.out.println("B클래스 인스턴스 메소드입니다.");
		}
		static void method2() {
			System.out.println("B클래스 정적 메소드입니다.");
		}//17버전 이후로 가능
	}//내부 클래스(이너 클래스)
	
	static class C {
		C(){}
		int field1;
		static int field2;
		void method1() {
			System.out.println("C정적클래스 인스턴스 메소드입니다.");
		}
		static void method2() {
			System.out.println("C정적클래스 정적 메소드 입니다.");
		}
	}//new 연산자 없이 사용하는 클래스
	
	
	//생성자
	
	
	
	//메서드
	void method1() {
		class D {
			D(){}
			int field1;
			static int field2;
			
			void method1() {
				System.out.println("D클래스 인스턴스 메소드입니다.");
			}
			static void method2() {
				System.out.println("D클래스 정적 메소드입니다.");
			}
		}
		//메서드 안쪽에 있는 클래스이기 때문에 내부에서만 호출 가능
		
		D.field2 = 20;
		D.method2();
		
		D d = new D();
		
		d.field1 = 30;
		d.method1();
		
	}
}
