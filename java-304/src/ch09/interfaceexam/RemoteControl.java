package ch09.interfaceexam;

public interface RemoteControl {
	//인터페이스는 대부분 api용으로 사용
	//객체를 요청하면 객체를 전달하는 용도
	//구성 멤버는 상수와 메서드만 존재
	//메서드는 추상메서드, 디폴트 메서드, 정적 메서드로 만들 수 있음
	
	//상수
		//데이터를 저장할 수 ㅣㅇㅆ는 필드를 선언할 수 없다.(고정값)
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0 ; //static final 생략 가능
	
	
	
	
	//메서드
		//추상메서드 : 조장이 강제로 만드는 {}없는 메서드
		//디폴트메서드 : 같은 패키지만 허용
		//정적 메서드 : static으로 선언한 객체없이 사용하는 메서드
//	abstract void method1(); //생략시 기본
//	default void method2() {}; //default 필수
//	static void method3() {}
	public abstract void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("음소거가 활성화 됩니다.");
		} else {
			System.out.println("음소거가 비활성화 됩니다.");
		}
	};
	
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}//static메서드는 기본적으로 public 접근제한자 보유
}
