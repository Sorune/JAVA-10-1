package ch09.extended;

public class ExtendedChildExam extends ExtendedTest {
	
	int 필드3;
	
	
	void 메서드3() {}
	
	public static void main(String[] args) {
		ExtendedChildExam ex = new ExtendedChildExam();
		
		//부모 필드
		ex.부모필드1 = 10;
		ex.부모필드2 ="김기원";
		//자식 필드 
		ex.필드3 = 20;
		//부모 메서드
		ex.메서드1();
		ex.메서드2();
		//자식 메서드
		ex.메서드3();
		
		
		
	}
}
