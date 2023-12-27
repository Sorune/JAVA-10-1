package ch09.extended.abstractexam.overriding;

public class Dog extends Animal {

	Dog(){
		super();
		this.kind = "Dog";
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}
