package ch04;

public class LogicalExam {

	public static void main(String[] args) {
		// |는 or연산을 진행하며 ~이거나, ~또는 이라는 뜻
		// &&는 값이 모두 true일 때 true(숫자 포함)
		// |는 값이 하나라도 true 일 경우 true (문자 찾을 때)
		
		int value = 6;
		
		if((value%2==0) | (value%3==0)) {
			System.out.println("2 또는 3의 배수입니다. : " + value);
		} else {
			System.out.println("2 또는 3의 배수가 아닙니다. : " + value);
		}
		
		if((value%2==0) && (value%3==0)) {
				System.out.println("2 와 3의 배수입니다. : " + value);
		} else {
			System.out.println("2 와 3의 배수가 아닙니다. : " + value);
		}
	}

}
