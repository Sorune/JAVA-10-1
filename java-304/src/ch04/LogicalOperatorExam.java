package ch04;

public class LogicalOperatorExam {
	public static void main(String[] args) {
		//논리곱 테스트(!&,&&,&)
		//논리곱은 and라는 뜻으로 ~이고 로 파악
		//100~90 사이 값을 판단 a<=100 & a>= 90
		
		int charCode = 'k';
		
		//유니코드표에 있는 대문자 인지 판단
		
		if((charCode >= 65) & (charCode <= 90)) {
			//true일 때
			//대문자는 65~90값
			System.out.println("대문자입니다. : "+charCode);
		} else if((charCode >= 97) && (charCode <= 122)) {
			//소문자는 97~122
			System.out.println("소문자입니다. : "+charCode);
		} else if (!(charCode < 48) && !(charCode > 57)) {
			//숫자 범위 48~57
			System.out.println("숫자입니다. : "+charCode);
		}
		
	}
}
