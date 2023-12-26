package ch09.extended.casting;

public class ChildExam {
	public static void main(String[] args) {
		//강제 타입 변환 실습
		Parent pr = new Child();
		
		pr.field1 = "김기원";
		pr.field2 = 50;
//		pr.field3 = "자식필드값";
		
		pr.method1();
		pr.method2();
		
		Child ch = (Child)pr;
		
		ch.field3 = "자식필드값";
		ch.method3();
		
		
		
	}
}
