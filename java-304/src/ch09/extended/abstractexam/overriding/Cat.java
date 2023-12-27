package ch09.extended.abstractexam.overriding;

public class Cat extends Animal {

	Cat(){
		super();
		this.kind = "Cat";
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");
	}

}
