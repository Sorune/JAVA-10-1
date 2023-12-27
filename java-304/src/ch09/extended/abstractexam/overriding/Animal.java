package ch09.extended.abstractexam.overriding;

public abstract class Animal {//추상메서드(조장이 만듦)
	//필드
	public String kind;
	
	
	
	
	//생성자
	public Animal() {};
	
	
	
	
	//메서드
	public abstract void sound();
	//추상메서드, 중괄호 블럭 없이 세미클론으로 마무리

}
