package ch09.extended.abstractexam;

public abstract class Phone {
	//조장이 가이드라인 제시
	//필드
	public String owner;
	
	
	//생성자
	public Phone(String owner) {
		this.owner = owner;
	};
		
		
	//메서드
	public void turnOn() {
		System.out.println("폰의 전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("폰의 전원을 끕니다.");
	}

}
