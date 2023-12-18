package ch07;

public class Computer {
	//배열 테스트용 코드 객체
	
	
	
	
	
	int sum1(int ... values) {
		int result=0;
		for(int i : values) {
			result+=i;
		}
		return result;
	}
	
}
