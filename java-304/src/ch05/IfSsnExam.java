package ch05;

import java.util.*;

public class IfSsnExam {
	public static void main(String[] args) {
		// 주민등록 번호를 활용하는 예제
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("주민등록번호 13자리를 입력하세요(- 생략 가능합니다) : ");
		String ssn = in.next();
		boolean isIn = ssn.contains("-");
		int ssnLen = ssn.length();
		
		if (!((ssnLen == 13 | ssnLen == 14) && isIn)) {
			System.out.println("주민등록번호 입력이 잘못되었습니다. 주민등록번호 13자리를 입력하세요. ");
		}
		
		char ssn2;
		
		if (isIn) {
			ssn2 = ssn.charAt(7);
			ssn = ssn.substring(0,6)+ssn.substring(7);
		} else {
			ssn2 = ssn.charAt(6);
		}
		
		int sum = 0;

		int num2 = 1;
		for (int i = 0 ; i <12 ; i ++) {
			num2 += 1;
			if (num2 > 9) {num2 = 2;}
			sum += Character.getNumericValue(ssn.charAt(i))*num2;
		}
	
		if (Character.getNumericValue(ssn.charAt(12)) == 11 - (sum%11)) {
			System.out.println("유효한 주민등록번호입니다.");
		} else {
			System.out.println("유효하지 않은 주민등록번호입니다.");
		}
		
		int num = Character.getNumericValue(ssn2);
		
		if (num%2==0) {
			System.out.println("여자입니다");
		} else if (num%2==1) {
			System.out.println("남자입니다");
		} else {
			System.out.println("주민등록번호가 잘못되었습니다. 다시 입력해주세요");
		}
		
		
		int year = Integer.parseInt(ssn.substring(0,2));
		int fullYear = 0;
		
		if(num == 1 || num == 2 || num == 5 || num == 6) {
			System.out.printf("나이는 %d 입니다.\n",(2023-(1900+year)));
			fullYear = 1900+year;
		} else if (num == 3 || num == 4 || num == 7 || num == 8) {
			System.out.printf("나이는 %d 입니다.\n",(2023-(2000+year)));
			fullYear = 2000+year;
		} else {
			System.out.println("주민등록번호가 잘못되었습니다. 다시 입력해주세요");
		}
		
		switch(fullYear%12) {
		case 0 :
			System.out.printf("%d년생으로 원숭이띠입니다.\n",year);
			break;
		case 1 :
			System.out.printf("%d년생으로 닭띠입니다.\n",year);
			break;
		case 2 :
			System.out.printf("%d년생으로 개띠입니다.\n",year);
			break;
		case 3 :
			System.out.printf("%d년생으로 돼지띠입니다.\n",year);
			break;
		case 4 :
			System.out.printf("%d년생으로 쥐띠입니다.\n",year);
			break;
		case 5 :
			System.out.printf("%d년생으로 소띠입니다.\n",year);
			break;
		case 6 :
			System.out.printf("%d년생으로 호랑이띠입니다.\n",year);
			break;
		case 7 :
			System.out.printf("%d년생으로 토끼띠입니다.\n",year);
			break;
		case 8 :
			System.out.printf("%d년생으로 용띠입니다.\n",year);
			break;
		case 9 :
			System.out.printf("%d년생으로 뱀띠입니다.\n",year);
			break;
		case 10 :
			System.out.printf("%d년생으로 말띠입니다.\n",year);
			break;
		case 11 :
			System.out.printf("%d년생으로 양띠입니다.\n",year);
			break;
		}
		
		System.out.printf("생일은 %s월 %s일 입니다.\n",ssn.substring(2,4),ssn.substring(4,6));
		
		int month = Integer.parseInt(ssn.substring(2, 4));
		
		if (month <= 0 || month > 12) {
			System.out.println("주민등록번호가 잘못되었습니다. 다시 입력해주세요");
		} else if(month >=3 && month <= 5) {
			System.out.println("봄에 태어났습니다.");
		} else if(month >=6 && month <= 8) {
			System.out.println("여름에 태어났습니다.");
		} else if(month >=9 && month <= 11) {
			System.out.println("가을에 태어났습니다.");
		} else {
			System.out.println("겨울에 태어났습니다.");
		}
		
		
		
	}
}
