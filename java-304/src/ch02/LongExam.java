package ch02;

public class LongExam {

	public static void main(String[] args) {
		//long 타입의 특징을 알아본다.
		//21억 값이 넘어 갈 것으로 판단되면 무조건 long 타입으로 사용
		//long 타입으로 선언시 21억이 넘으면 뒤에 대문자 L을 써야한다
		long var1 = 10;
		long var2 = 20L;
		long var3 = 3000000000000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);

	}

}
