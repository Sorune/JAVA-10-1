package ch06;

public class StringNullExam {
	public static void main(String[] args) {
		// 기본타입은 ==연산시 값이 같은지를 물어본다.(int, double, long)
		// 참조타입은 ==연산시 주소가 같은지를 물어본다.(기본형을 제외한 나머지는 다 참조타입)
		
		String name = "남태욱";
		String hobby = "볼링";
		
		 System.out.println("name의 총 문자수 : "+name.length());
		 System.out.println("hobby의 총 문자수 : "+hobby.length());
	}
}
