package ch06;

public class StringEqualsExam {
	public static void main(String[] args) {
		// 기본타입에 동등 비교는 ==
		// 참조타입의 동등 비교는 주소값을 비교
		
		String str1 = "김기원";
		String str2 = "김기원";
		String str3 = new String("김기원");
		
		
		if (str1 == str3) {
			System.out.println("str1과 str3는 참조가 같습니다.");
		} else {
			System.out.println("str1과 str3는 참고자 같지 않습니다.");
		}// 참조 비교
		
		if (str1.equals(str3)) {
			System.out.println("str1과 str3는 문자열이 같습니다.");
		} else {
			System.out.println("str1과 str3는 문자열이 같지 않습니다.");
		}// 문자열 비교 .equals() 메서드                                                          
		
		
		
	}
}
