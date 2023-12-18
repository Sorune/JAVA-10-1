package ch07;

public class Television {
	// 정적 필드는 선언과 동시에 초기값을 주는 것이 관례
	static String company = "samsung";
	static String model = "LED";
	static String info;
	
	static { // 정적 블록, 생성자 대신 사용, 정적 멤버는 구동시 자동으로 만들어짐
		info = company+"-"+model;
	}
}
