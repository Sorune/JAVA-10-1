package ch05;

import java.util.Scanner;

public class ExSwithchExam {
	public static void main(String[] args) {
		// 향상된 switch문은 같은 조건을 동시에 처리하기 위한 기법
		// case 뒤의 값이 여러개 존재할 수 있음
		// case에 해당하는 값 처리는 -> 람다식으로 처리
		
		Scanner in = new Scanner(System.in);
		System.out.print("동물의 이름을 입력하세요 : ");
		String monster = in.nextLine();
			
		
		System.out.printf("%s는 %s 입니다. \n",monster,whoIsIt(monster));
	}
	
	// 추가 메서드 활용(동작 부분을 별개로 만듬 -> 관심사의 분리(oop의 핵심)
	
	public static String whoIsIt(String bio) {
		String kind = "미지으 생물";
		switch (bio) {
		case "호랑이","사자","강아지","고양이","고래" -> kind = "포유류";
		case "독수리","참새","까마귀","비둘기","닭","까치" -> kind = "조류";
		case "고등어","연어","참치","광어","우럭","갈치","다금바리" -> kind ="어류";
		//break;
		//향상된 스위치 문에는 break 사용 불가
		default -> kind = "사전에 등록되지 않은 몬스터";
		}
		
		return kind;
	}
	
	
}
