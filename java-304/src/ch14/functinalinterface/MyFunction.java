package ch14.functinalinterface;

@FunctionalInterface
public interface MyFunction {
	//구현 객체를 클래스로 만들어 사용
	// 함수로 만들기 위해서는 메서드 1개만 가지고 있어야 한다.
	public void method1();
//	public void otherMethod();
}
