package ch09.extended.abstractexam.overriding;

import java.util.Scanner;

public class AnimalExam {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		System.out.println(cat.kind);
		cat.sound();
		
		System.out.println(dog.kind);
		dog.sound();
		
		Animal an = null;
		
		an = new Cat();
		System.out.println(an.kind);
		an.sound();
		
		Cat cat2 = (Cat)an;
		System.out.println(cat2.kind);
		cat2.sound();
		
		an = new Dog();
		System.out.println(an.kind);
		an.sound();
		
		Dog dog2 = (Dog)an;
		System.out.println(dog2.kind);
		dog2.sound();
		
		Animal an2 = null;
		Scanner in = new Scanner(System.in);
		System.out.println("동물을 선택하세요");
		System.out.println("1. 강아지  2. 고양이");
		System.out.print(">>> ");
		int select = in.nextInt();
		if(select == 1) {
			an2 = new Dog();
		} else {
			an2 = new Cat();
		}
		
		an2.sound();
		
		animalSound(new Dog());
		animalSound(new Cat());
		
	}
	
	private static void animalSound(Animal an) {
		an.sound();
	}
}
