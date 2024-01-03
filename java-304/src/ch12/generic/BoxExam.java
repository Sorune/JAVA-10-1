package ch12.generic;

import java.util.ArrayList;
import java.util.HashMap;

public class BoxExam {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("홍길동");
		String name = box.get();
		
		
		
		Box<Integer> box1 = new Box<Integer>();
		box1.set(11);
		int number = box1.get();
		double db = box1.get();
		
		Box<Apple> box2 = new Box<Apple>();
		box2.set(new Apple());
		Apple a = box2.get();
		
		
		
		ArrayList arr1 = new ArrayList();
		
		HashMap hash = new HashMap();
	}
}
