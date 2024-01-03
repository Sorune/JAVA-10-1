package ch14.list;

import java.util.ArrayList;

public class ArrayListExam {
	public static void main(String[] args) {
		//list는 배열과 유사하지만 초기배열값을 청하지 않음
		//기본은 10칸이지만 자동으로 추가 된다.
		//처음에 30칸으로 만들고 싶으면 객체 생성시 (30)로 활용 됨
		// 제네릭을 사용하기 때문에 같은 타입으로 생성 해야한다.
		ArrayList<String> list = new ArrayList<String>();
		int count = list.size();
		System.out.println(count);
		
		list.add("JAVA");
		list.add("JDVBC");
		list.add("Servlet");
		list.add("JSP");
		list.add("Spring");
		list.add("Spring Boot");
		list.add(2,"Oracle");
		list.add("MyBatis");
		list.add("JPA");
		
		count = list.size();
		System.out.println(count);
		
		for (int i = 0; i < count ; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.contains("JPA"));
		System.out.println(list.indexOf("JPA"));
		list.set(3,"TomCat");
		System.out.println("--------------------------------");
		for (int i = 0; i < count ; i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(3);
		
		list.sort(null);
		count = list.size();
		System.out.println("--------------------------------");
		for (int i = 0; i < count ; i++) {
			System.out.println(list.get(i));
		}
		
		
	}
}
