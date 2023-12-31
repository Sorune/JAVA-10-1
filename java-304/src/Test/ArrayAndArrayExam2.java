package Test;

import java.util.Scanner;

public class ArrayAndArrayExam2 {
	
	public static void main(String[] args) {
		
		boolean run = true;
		int numStudent = 0;
		String[] name = null;
		int[] mathScore = null;
		int[] englishScore = null;
		int[] sum = null;
		double[] avg = null;
		char[] grade = null;
		int[] rank = null;
		Scanner in = new Scanner(System.in);

		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 성적조회 | 4. 종료 |");
			System.out.println("-------------------------------------------");
			System.out.println("메뉴 선택(1~4까지의 숫자를 입력하세요 >> ");
			int selectNo = in.nextInt();
			
			switch(selectNo) {
			
			case 1 :
				// 학생 수를 입력 받아 해당 크기만큼 배열 생성
				System.out.println("학생수를 입력하세요 >> ");
				numStudent = in.nextInt();
				
				mathScore = new int[numStudent];
				englishScore = new int[numStudent];
				name = new String[numStudent];
				sum = new int[numStudent];
				avg = new double[numStudent];
				grade = new char[numStudent];
				rank = new int[numStudent];
				
				break;
			
			case 2 :
				// 이름 입력 후 점수 입력
				theEnterScore(name, mathScore, englishScore, numStudent, sum, avg, grade, rank);
				break;
			
			case 3 :
				// 이름 조회하여 일치하면 결과 출력
				theGradeInquiry(numStudent, name, mathScore, englishScore, sum, avg, grade, rank);
				break;
			case 4 :
				System.out.println("프로그램 종료");
				run = false;
				break;
			
			default :
				System.out.println("잘못된 입력입니다. ");
				System.out.println("메뉴를 다시 선택해주세요");
				
			} //switch 종료
			
		} //while종료

	}
	public static void theEnterScore(String[] name, int[] mathScore, int[] englishScore,
			int numStudent, int[] sum, double[] avg, char[] grade, int[] rank) {// 학생정보 입력 메소드
		// 이름 입력 후 점수 입력
		

		System.out.println("학생 이름을 입력하세요 >>");
		Scanner in = new Scanner(System.in);
		
		for(int i =0; i < name.length; i++) { //학생의 이름, 수학, 영어 점수 입력
			System.out.println("*************");
			System.out.println("학생 " + (i + 1) + " 이름 >> ");
			name[i] = in.next();
			System.out.println("수학 점수 >> ");
			mathScore[i] = in.nextInt();
			System.out.println("영어 점수 >> ");
			englishScore[i] = in.nextInt();
		} // 성적입력 for문 종료
		
		for(int i = 0; i < numStudent; i++) { // 등급 입력
			sum[i] = mathScore[i] + englishScore[i];
			avg[i] = (double) (sum[i] / 2);
			if(avg[i] >= 90) {
				grade[i] = 'A';
			} else if(avg[i] >= 80) {
				grade[i] = 'B';
			} else if(avg[i] >= 70) {
				grade[i] = 'C';
			} else {
				grade[i] = 'F';
			} // grade if문 종료
		} // 성적 계산 for문 종료
		
		for(int i=0; i < numStudent; i++) { // 등수 정렬
			for(int j =0; j < numStudent; j++) {
				if(sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		} // 등수 계산 for문 종료
	}
	
	
	public static void theGradeInquiry(int numStudent, String[] name, int[] mathScore, 
			int[] englishScore, int[] sum, double[] avg, char[] grade, int[] rank ) {// 조회결과 메소드
		
		Scanner in = new Scanner(System.in);
		System.out.println("조회할 학생 이름을 입력해주세요 >> ");
		String search = in.next();
		for(int i=0; i < numStudent; i++) {
			
			if(search.equals(name[i])) {
				System.out.println(name[i] + "의 조회 결과 >>");
				System.out.println("수학 점수 : " + mathScore[i] + "    ");
				System.out.println("영어 점수 : " + englishScore[i]);
				System.out.println("총점 : " + sum[i]);
				System.out.println("평균 점수 : " + avg[i]);
				System.out.println(">> " + grade[i] + " 등급");
				System.out.println(">> " + (rank[i] + 1) + "등 ");
			}
		}//for end

	}	//theGradeInquiry end
}