package ch06;

import java.util.Scanner;

public class ScoreExam {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] score ;
		int menuSelect = 0;
		String exit = "n";
		
		System.out.println("===========성적 관리 프로그램입니다.===========");
		
		while (!(exit.toLowerCase().equals("y"))) {
			System.out.print("학생 수를 입력해 주세요 : ");
			int count = in.nextInt();
			int mainMenu = 1;
			
			System.out.println("=========================================");
			System.out.printf("현재 등록된 학생 수 : %d \n",count);
			
			score = new int[count];
			
			for (int i = 0 ; i<score.length;i++) {
				System.out.printf("%d번 학생의 성적을 입력하세요 : ",i+1);
				score[i] = in.nextInt();
				}
			
//			do {
//			System.out.println("=========================================");
//			System.out.printf("현재 등록된 학생 수 : %d \n",count);
//			System.out.printf("입력된 학생들의 성적은 다음과 같습니다.\n");
//			
			showScore(score,count);
//			} while (true);
			
			
			while (mainMenu == 1) {

				System.out.println("==============메뉴를 선택하세요===========");
				System.out.println("1. 총점 계산 \t3. 최고/최저 점수 조회");
				System.out.println("2. 평균 계산 \t4. 성적 정렬");
				System.out.println("5. 학점 확인 \t6. 특정 범위 확인");
				System.out.println("7. 초기 화면 \t8. 프로그램 종료");
				System.out.println("======================================");
				System.out.print(">>> ");
				
				menuSelect = in.nextInt();
				
				if (menuSelect < 1 || menuSelect > 8) {
					System.out.println("메뉴 선택이 잘못되었습니다.");
					System.out.println("올바른 메뉴를 선택해주세요.");
					continue;
				}
				
				switch(menuSelect) {
				case 1 :
					System.out.println("학생들의 총점을 계산합니다.");
					System.out.printf("학생들의 총점은 %d점 입니다.\n",sum(score));
					continue;
				case 2 :
					System.out.println("학생들의 평균을 계산합니다.");
					System.out.printf("학생들의 평균은 %5.2f점 입니다.\n",avg(score));
					continue;
				case 3:
					System.out.println("최고점 혹은 최저점을 알아봅니다.");
					System.out.println("알아볼 메뉴를 선택해 주세요.");
					System.out.println("1. 최고점 \t 2. 최저점");
					
					int minMax = in.nextInt() - 1;
					
					if (minMax < 0 || minMax > 1) {
						System.out.println("메뉴 선택이 잘못되었습니다.");
						System.out.println("올바른 메뉴를 선택해주세요.");
						continue;
					} else {
						if (minMax == 0) {
							System.out.println("최고점을 알아봅니다.");
							System.out.printf("학생들 중 최고점은 %d점 입니다.\n",minMax(score,minMax));
						} else {
							System.out.println("최저점을 알아봅니다.");
							System.out.printf("학생들 중 최저점은 %d점 입니다.\n",minMax(score,minMax));
						}
					}
					continue;
				case 4:
					System.out.println("학생들의 성적을 정렬합니다.");
					System.out.println("정렬할 방식을 선택해 주세요.");
					System.out.println("1. 오름차순 \t 2. 내림차순");
					
					int sort = in.nextInt() - 1;
					
					if (sort < 0 || sort > 1) {
						System.out.println("선택이 잘못되었습니다.");
						System.out.println("올바른 정렬 방식을 선택해주세요.");
						continue;
					} else {
						if (sort == 0) {
							System.out.println("오름차순 정렬을 시행합니다.");
							score = sort(score,sort);
							showScore(score,count);
						} else {
							System.out.println("내림차순 정렬을 시행합니다.");
							score = sort(score,sort);
							showScore(score,count);
						}
					}
					continue;
				case 5 :
					int select;
					showScore(score,count);
					System.out.println("확인할 학생을 선택해 주세요.");
					System.out.print(">>> ");
					select = in.nextInt()-1;
					
					if (select<0 || select > count) {
						System.out.println("잘못된 번호입니다.");
						System.out.println("정확한 학생의 번호를 입력해 주세요.");
						continue;
					}
					
					System.out.printf("%d번 학생의 학점은 %s입니다.\n",select+1,gradeCheck(score[select]));
					continue;
				case 6 :
					int range = 0;
					
					System.out.println("확인할 범위를 선택해 주세요");
					System.out.println("1. 상위 \t2. 하위");
					System.out.print(">>> ");
					range = in.nextInt()-1;
					
					if (range < 0 || range > 1) {
						System.out.println("선택이 잘못되었습니다.");
						System.out.println("올바른 정렬 방식을 선택해주세요.");
						continue;
					} else {
						int rangeCount = 0;
						System.out.println("확인할 학생의 수를 입력해 주세요.");
						System.out.print(">>> ");
						rangeCount = in.nextInt();
						
						if (rangeCount < 0 || rangeCount > count) {
							System.out.println("학생의 수를 잘못 입력하셨습니다.");
							System.out.println("정확한 수를 입력해 주세요");
							continue;
						} else {
							if (range == 0) {
								int[] result = checkRange(score,range,rangeCount);
								System.out.printf("상위 학생들의 점수는 다음과 같습니다..\n");
								for (int i = 0; i < rangeCount;i++) {
									System.out.printf("상위 %d번 학생 : %d\n",i+1,result[i]);
									}
							}else {
								int[] result = checkRange(score,range,rangeCount);
								System.out.printf("하위 학생들의 점수는 다음과 같습니다..\n");
								for (int i = 0; i < rangeCount;i++) {
									System.out.printf("하위 %d번 학생 : %d\n",i+1,result[i]);
									}
							}
						}
					}
				
					continue;
				case 7 :
					System.out.println("초기화면으로 돌아갑니다.");
					mainMenu = 0;
					continue;
				case 8 :
					System.out.println("프로그램을 종료하시겠습니까? 종료하시려면 y를 눌러주세요.");
					System.out.print(">>> ");
					exit = in.next();
					mainMenu = 0;
					continue;
				}
				
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	
	
	public static void showScore(int[] score, int count) {
		System.out.println("=========================================");
		System.out.printf("현재 등록된 학생 수 : %d \n",count);
		System.out.println("=========================================");
		System.out.printf("입력된 학생들의 성적은 다음과 같습니다.\n");
		for (int i = 0; i < score.length;i++) {
			System.out.printf("%d번 학생 : %d\n",i+1,score[i]);
		}
		
	}
	
	
	public static int sum(int arr[]) {
		int result = 0;
		for (int i = 0 ; i < arr.length;i++) {
			result += arr[i];
		}
		
		return result;
	}
	
	public static double avg(int[] arr) {
		double result = 0;
		int sum = 0;
		for (int i = 0 ; i < arr.length;i++) {
			sum += arr[i];
		}
		
		result = sum / arr.length;
		
		return result;
	}
	
	public static double avg(int x, int y) {
		double result = x /y;
		return result;
	}
	
	public static int minMax(int[] arr, int x) {
		int result = arr[0];
		switch(x) {
		case 0:		
			for (int i = 0 ; i < arr.length ; i ++) {
				if(result < arr[i]) {
					result = arr[i];
				}
			}
			break;
		case 1:	
			for (int i = 0 ; i < arr.length ; i ++) {
				if(result > arr[i]) {
					result = arr[i];
				}
			}
			break;
		}
		return result;
	}

	public static int[] sort(int[] arr, int x) {
		// 0 : 오름차순 / 1 : 내림차순
		switch(x) {
		case 0:
			for (int i = 0 ; i <arr.length-1;i++) {
				for (int j = 0; j<arr.length-1-i;j++) {
					if(arr[j]>arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			break;
		case 1:
			for (int i = 0 ; i <arr.length-1;i++) {
				for (int j = 0; j<arr.length-1-i;j++) {
					if(arr[j]<arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			break;
		}
		return arr;
	
	}

	public static String gradeCheck(int x) {
		String result = "";
		if (x>90) {
			result = "A";
		} else if (x>80) {
			result = "B";
		} else if (x > 70) {
			result = "C";
		} else if (x > 60) {
			result = "D";
		} else {
			result = "F";
		}
		
		return result;
	}

	public static int[] checkRange(int[] arr, int x,int y) {
		int[] result = new int[y];
		switch(x) {
		case 1:
			for (int i = 0 ; i <arr.length-1;i++) {
				for (int j = 0; j<arr.length-1-i;j++) {
					if(arr[j]>arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			break;
		case 0:
			for (int i = 0 ; i <arr.length-1;i++) {
				for (int j = 0; j<arr.length-1-i;j++) {
					if(arr[j]<arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			break;
		}
		for (int i = 0;i<y;i++) {
			result[i] = arr[i];
		}
		return result;
	}
}
