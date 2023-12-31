package Test;

import java.util.Scanner;

public class ArrayGrade {
	
	public static void main(String[] args) {
		// 총점, 평균, 최소값, 최대값
		// 내림차순
		// 학생 조회
		// 석차 조회
		// 로그인
		boolean mid = true;
		boolean mid2 = true;

		boolean school = true;
		String idj = null; // 회원가입 시 정하는 아이디
		String pwj = null; // 회원가입 시 정하는 비밀번호
		String id; // 저장된 아이디
		String pw; // 저장된 비밀번호
		int codes = 907886; // 정해져있는 학교 코드
		String teacherName = null; // 회원가입 시 입력하는 이름
		int year; // 회원가입 학년
		int classClass; // 회원가입 반
		Scanner in = new Scanner(System.in);
		
		while (mid2) { // 비밀번호 틀렸을 때 다시 돌아옴
		System.out.println("1. 회원가입 | 2. 로그인 ");
		System.out.print("선택: ");
		int login = in.nextInt();
		
		if (login == 1) { // 회원가입 선택
			System.out.println("회원가입 창으로 이동합니다.");
			System.out.println();
			System.out.println("*****************************************");
			System.out.println("회원가입 페이지입니다.");
			System.out.println("*****************************************");
			System.out.println();
			System.out.println("가입하실 본인의 이름을 입력하세요.");
			System.out.print("이름: ");
			teacherName = in.next();
			System.out.println("--------------------------------------");
			System.out.println("사용하실 아이디를 입력하세요.");
			System.out.print("아이디: ");
			idj = in.next(); // 중복 아이디 확인 만들어보기
			System.out.println("사용하실 비밀번호를 입력하세요.");
			System.out.print("비밀번호: ");// 영어 소문자, 대문자, 숫자, 특수문자 배열 조건 만들어보기
			pwj = in.next();
			
			while (mid) { // 코드 틀렸을 때 다시 코드 인증 뜨게 하기 위해 while 설정
				System.out.println("--------------------------------------");
				System.out.println("성적처리 시스템 사용을 위하여 교사 인증이 필요합니다.");
				System.out.println("해당 학교 코드 6자리를 입력하세요.");
				System.out.println("(코드 입력 시 학교 교사 명단과 정보 동기화가 진행되어 개인정보가 공유됩니다)");
				int schoolCode = in.nextInt();
					if (schoolCode != codes) {
					System.out.println("해당하지 않는 코드입니다. 다시 입력하세요.");	
					} else {
						mid = false; // 다시 while로 되돌아감!!!
						schoolCode = codes;
						System.out.println("교사 인증이 완료되었습니다.");
					}
			} // while 종료
				System.out.println("--------------------------------------");
				System.out.println("담당 학년 및 학급을 입력하세요.");
				System.out.print("학년: ");
				year = in.nextInt();
				System.out.print("반: ");
				classClass = in.nextInt();
				
				System.out.println("회원가입이 성공적으로 완료되었습니다.");
				System.out.println("처음 화면으로 이동합니다.");
		} // if login1 종료
		
		if (login == 2) { // 로그인 선택
			System.out.println("로그인 창으로 이동합니다.");
			System.out.print("아이디: ");
			id = in.next();
			System.out.print("비밀번호: ");
			pw = in.next();
			
			if (!(id.equals(idj)) || !( pw.equals(pwj))) { // 입력값과 저장값이 일치하지 않을 때
				System.out.println("아이디 또는 비밀번호 오류입니다. 다시 입력하세요."); // 가입되지 않은 아이디입니다.도 나중에 만들어보자.
				System.out.println("아이디: ");
				String ida = in.next(); // 재입력
				System.out.println("비밀번호: ");
				String pwa = in.next(); // 재입력
				
				if (!(ida.equals(idj)) || !(pwa.equals(pwj))) { // 재입력값과 저장값이 일치하지 않을 때
					System.out.println("로그인을 2회 이상 실패하였습니다. 24시간 동안 로그인이 불가능합니다.");
					return; // 로그인 불가하게 되돌아가지 않도록 막음
				} else {
					System.out.println("로그인이 성공적으로 완료되었습니다."); // 입력값과 저장값이 일치할 때
 				}
			} else {
				mid2 = false; // 튕겨서 다시 while로 되돌아감!!!!
				id = idj;
				pw = pwj;
				System.out.println("로그인이 성공적으로 완료되었습니다.");
				school = true;

			}// 아이디 판단 if문 종료
		} // if login2
		
		String greeting = "선생님, 안녕하십니까? OO고등학교 학사 관리 시스템입니다.";
		int studentNum = 0; // 학생 수
		String[] name = null;
		int[] mathScore = null;
		int[] englishScore = null;
		String search = null; // 조회용
		int[] sum = null; // 개인 총점용
		double[] avg = null; // 개인 평균용
		char[] grade = null; // 개인 등급용
		int[] rank = null; // 개인 석차용
		
		System.out.println("**********************************");
		System.out.println(teacherName + greeting);
		System.out.println("**********************************");
		
		while(school) {
			checkingGrade(); // 카테고리 호출
			System.out.println("업무를 진행 하시려면 순차적으로 숫자를 선택해주세요: ");
			System.out.print("선택: ");
			int choice = in.nextInt(); // 카테고리 번호 입력1
			
			
			if (choice == 1) { // 1번 눌렀을 때 (학생 수 입력)
				System.out.println("학생 수 입력 페이지로 이동합니다.");
				System.out.print("학생 수를 입력해주세요: ");
				studentNum = in.nextInt();
				mathScore = new int[studentNum]; // 키보드로 입력된 학생 수를 새로 만든 scores 변수 배열에 대입
				englishScore = new int[studentNum];
				name = new String[studentNum];
				sum = new int[studentNum];
				avg = new double[studentNum];
				grade = new char[studentNum];
				rank = new int[studentNum];
			
			} else if (choice == 2) { // 2번 눌렀을 때 (점수 입력)
				System.out.println("성적 입력 페이지로 이동합니다.");
				System.out.println("학생 이름을 입력하세요.");
				for (int i=0; i<name.length; i++) {
					System.out.println("*********************");
					System.out.print((i+1) + "번 이름 >> ");
					name[i] = in.next();
					System.out.print("   *수학 점수 >> ");
					mathScore[i] = in.nextInt();
					System.out.print("   *영어 점수 >> ");
					englishScore[i] = in.nextInt();
				} // 성적 입력 for문 종료
				gradeRank(sum, avg, mathScore, englishScore, grade, rank, studentNum);
				
			} else if (choice == 3) { // 3번 눌렀을 때
				System.out.println("1. 개인 성적 분석 | 2. 학급 성적 분석");
				System.out.print("선택: ");
				int num = in.nextInt(); //***
				
				if (num == 1) { // 1번 눌렀을 때 
					System.out.println("개인 성적 분석창으로 이동합니다.");
					System.out.print("조회할 학생의 이름을 입력해주세요 : ");
					search = in.next();
					
					for (int i=0; i<studentNum; i++) {
						
						if (search.equals(name[i])) {
							System.out.println(name[i]+" 의 조회 결과 >>");
							System.out.println("수학 점수 : " + mathScore[i]);
							System.out.println("영어 점수 : " + englishScore[i]);
							System.out.println("총점 : " + sum[i]);
							System.out.println("평균 점수 : " + avg[i]);
							System.out.println(">> " + grade[i] + "등급");
							System.out.println(">> " + (rank[i] + 1) + "등");
						}
					} // for문 종료
					
				} else if (num == 2) { // 2번 눌렀을 때
					System.out.println("학급 성적 분석창으로 이동합니다.");
					order(sum, name, studentNum);
					
					int classSum = total(sum); // 총점 호출
					System.out.println("학급 총점: " + classSum);

					double classAvg = classAvg(classSum, sum); // 평균 호출
					System.out.println("학급 평균: " + classAvg);
				
					minMax(sum); // 최고점수 및 최저점수 호출
				} // 개인 및 학급 성적 분석 종료
					
			} else if (choice == 4 ) {
				school = false;
				mid2 = true;
				System.out.println("로그아웃 하였습니다.");
				System.out.println("로그인 화면으로 돌아갑니다.");
			} else if (choice == 5) { // 4번 눌렀을 때
				school = false; // 프로그램 종료
				mid2= false;
				} else if (choice != 1 && choice != 2 && choice != 3 && choice != 4){
				System.out.println("입력값을 초과하였습니다. 다시 선택해주세요.");
			} // if문 종료
		} // while문 종료
		
		
		
		
		
		
		
		
		
	} // while mid2
		
		
		System.out.println("학사 관리 시스템을 종료합니다.");
	} // main 메서드 종료

	public static void checkingGrade() {
		
		System.out.println("=============================================");
		System.out.println("1. 학생 수 | 2. 성적 입력 | 3. 성적 분석 | 4. 로그아웃  | 5. 종료 ");
		System.out.println("=============================================");
	} // main 메서드 종료
	
	public static void gradeRank(int[] sum, double[] avg, int[] mathScore, int[] englishScore, char[] grade, int[] rank, int studentNum) {
		
		for (int i=0; i<studentNum; i++) {
			sum[i] = mathScore[i] + englishScore[i];
			avg[i] = (double) (sum[i]/2);
			if (avg[i] >= 90) {
				grade[i] = 'A';
			} else if (avg[i] >= 80) {
				grade[i] = 'B';
			} else if (avg[i] >= 70) {
				grade[i] = 'C';
			} else {
				grade[i] = 'F';
			} // grade if문 종료
		} // 성적 계산 for문 종료
		
		for (int i=0; i<studentNum; i++) {
			for (int j=0; j<studentNum; j++) {
				if (sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		} // 등수 계산 for문 종료
	} // main 메서드 종료
	
	public static void order(int[] sum, String[] name, int studentNum) { // 개인별 성적(수학+영어) 리스트: 성적 배열이 필요하다
		
		for (int j=0; j<sum.length-1; j++) {
			for (int k=0; k<sum.length-1-j; k++) {
				if (sum[k] < sum[k+1]) {
					int sumTemp = sum[k];
					sum[k] = sum[k+1];
					sum[k+1] = sumTemp;
				}
				String nameTemp = name[k];
				name[k] = name[k+1];
				name[k+1] = nameTemp;
			}
		} // for문 종료
		System.out.println("---------전체 등수(내림차순)----------");
		for (int i=0; i<name.length; i++) {
			System.out.println(name[i] + ": " + sum[i]);
		} // for문 종료
		System.out.println("---------------------------------");
	} // main 메서드 종료

	public static int total(int[] sum) { // 총점: 점수가 필요하다
		
		int classSum = 0;
		for (int i=0; i<sum.length; i++) {
			classSum += sum[i];
		} // for문 종료
		return classSum;
	} // main 메서드 종료
	
	public static double classAvg(int classSum, int[] sum) { // 평균: 총점과 점수 배열이 필요하다
		
		double classAvg = (double) classSum / sum.length;
		return classAvg;
	} // main 메서드 종료
	
	public static void minMax(int[] sum) { // 최대값, 최소값: 점수 배열과 점수가 필요하다
		
		int max = sum[0];
		int min = sum[0];
	
		for (int i=0; i<sum.length; i++) {
			if (sum[i] > max) {
				max = sum[i];
			}else if (sum[i] < min) {
				min = sum[i];
			} // if문 종료
	} // for문 종료
		System.out.println("학급 최고점수: " + max);
		System.out.println("학급 최저점수: " + min);

	} // main 메서드 종료
} // class 종료