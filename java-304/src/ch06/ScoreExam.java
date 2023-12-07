package ch06;

import java.util.Scanner;

public class ScoreExam {
	public static void main(String[] args) {
		// 초기 변수 선언
		
		Scanner in = new Scanner(System.in);
		String[] name;
		String[] subject ;
		int[] score = {};
		int[][] idScore;
		int menuSelect = 0;
		String exit = "n";
		
		System.out.println("===========성적 관리 프로그램입니다.===========");
		
		while (!(exit.toLowerCase().equals("y"))) {
			//학생 수 입력 : 학생 수로 배열 크기 선언
			
			System.out.print("학생 수를 입력해 주세요 : ");
			int count = in.nextInt();
			
			// 메인 메뉴 while 루프 활성화 코드
			int mainMenu = 1;
			
			
			// 입력된 학생 수 확인 
			System.out.println("=========================================");
			System.out.printf("현재 등록된 학생 수 : %d \n",count);

			in.nextLine();
			
			System.out.println("과목을 입력합니다. 과목은 쉼표(,)로 구분해서 입력해주세요.");
			System.out.print("과목을 입력해주세요. : ");
			String subjectName = in.nextLine();
			
			System.out.println("=========================================");
			System.out.printf("현재 등록된 과목 : %s \n",subjectName);
			subject = subjectName.split(",");
			
			// 학생 수에 따른 배열 생성
//			score = new int[count];
			

			// 학생 수, 과목에 따른 배열 생성
			// 이름 배열과 점수 배열은 타입이 다름
			// 따라서 점수 배열에 이름 배열과 매칭 될 id배열을 부여
			// 배열의 형태 (ex : 국어 영어 수학)
			// [[0, 75, 95, 66], [1, 85, 85, 55], [2, 95, 85, 44]]
			// idScore[점수][과목,0번 인덱스는 이름 배열로 매칭될 id로 설정]
			name = new String[count];
			idScore = new int[subject.length+1][count];
			
			//이름 배열 값 넣기
			System.out.println("=========================================");
			System.out.printf("학생의 이름을 작성해 주세요.\n");
			for (int i = 0 ; i<name.length;i++) {
				System.out.printf("%d번 학생의 이름을 입력하세요 : ",i+1);
				name[i] = in.next();
				}
			//과목별 성적 입력
			System.out.println("=========================================");
			for (int j = 0; j<subject.length;j++) {
				System.out.printf("학생의 %s성적을 입력합니다.\n",subject[j]);
				for (int i = 0 ; i<count;i++) {
					System.out.printf("%s 학생의 %s성적을 입력하세요 : ",name[i],subject[j]);
					idScore[j+1][i] = in.nextInt();
					}
				}
			for (int i = 0; i< count ; i ++) {
				idScore[0][i] = i;
			}
			
			
			
			showScore(idScore,name,subject,1);
			
			
			while (mainMenu == 1) {
				int selectSubject,selectStudent, selectPrint= 0;
				
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
				//총점 계산
				case 1 :
					System.out.println("======================================");
					System.out.println("총점을 계산할 방식을 선택하세요.");
					System.out.println("1. 학생별 \t2. 과목별");
					System.out.print(">>> ");
					//출력 방식 결정
					selectStudent = in.nextInt()-1;
					int[] result;
					double[] dbresult;
					if (selectStudent < 0 || selectStudent > 1) {
						System.out.println("메뉴 선택이 잘못되었습니다.");
						System.out.println("올바른 메뉴를 선택해주세요.");
						continue;
					}
					switch (selectStudent) {
					//학생별 총점
					case 0:
						System.out.println("학생별 총점을 계산합니다.");
						result = sum(idScore,subject,selectStudent);
						for (int i = 0; i < idScore[0].length;i++) {
							System.out.printf("%s학생의 총점은 %d점 입니다.\n",name[i],result[i]);
						}
						continue;
					//과목별 총점
					case 1:
						System.out.println("과목별 총점을 계산합니다.");
						result = sum(idScore,subject,selectStudent);
						for (int i = 0;i<subject.length;i++) {
							System.out.printf("%s의 총점은 %d점 입니다.\n",subject[i],result[i]);
						}
						continue;
					}
					continue;
				case 2 :
					System.out.println("======================================");
					System.out.println("평균을 계산할 방식을 선택하세요.");
					System.out.println("1. 학생별 \t2. 과목별");
					System.out.print(">>> ");
					//출력 방식 결정
					selectStudent = in.nextInt()-1;
					
					if (selectStudent < 0 || selectStudent > 1) {
						System.out.println("메뉴 선택이 잘못되었습니다.");
						System.out.println("올바른 메뉴를 선택해주세요.");
						continue;
					}
					switch (selectStudent) {
					//학생별 평균
					case 0:
						System.out.println("학생별 평균을 계산합니다.");
						dbresult = avg(idScore,subject,selectStudent);
						for (int i = 0; i < idScore[0].length;i++) {
							System.out.printf("%s학생의 평균은 %5.2f점 입니다.\n",name[i],dbresult[i]);
						}
						continue;
					//과목별 평균
					case 1:
						System.out.println("과목별 평균을 계산합니다.");
						dbresult = avg(idScore,subject,selectStudent);
						for (int i = 0;i<subject.length;i++) {
							System.out.printf("%s의 평균은 %5.2f점 입니다.\n",subject[i],dbresult[i]);
						}
						continue;
					}
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
						String minMaxString;
						if(minMax == 0) {minMaxString = "최고점";} else {minMaxString = "최저점";}
						System.out.printf("%s을 계산할 과목을 선택하세요.\n",minMaxString);
						for (int i = 0; i<subject.length;i++) {
							System.out.printf("%d. %s\t",i+1,subject[i]);
						}
						System.out.println();
						System.out.print(">>> ");
						selectSubject = in.nextInt()-1;
						
						if (selectSubject < 0 || selectSubject > subject.length) {
							System.out.println("메뉴 선택이 잘못되었습니다.");
							System.out.println("올바른 메뉴를 선택해주세요.");
							continue;
						} else {
							result = minMax(idScore,subject,minMax,selectSubject);
							System.out.printf("%s과목의 최고점은 %d점인 %s학생입니다.",subject[selectSubject],result[selectSubject+1],name[result[0]]);
						}
						
					}
					System.out.println();
					continue;
				case 4:
					System.out.println("학생들의 성적을 정렬합니다.");
					System.out.println("정렬할 방식을 선택해 주세요.");
					System.out.println("1. 오름차순 \t 2. 내림차순");
					
					int sort = in.nextInt() - 1;
					String orderBy;
					if(sort == 0) {orderBy = "오름차순";} else {orderBy = "내림차순";}
					if (sort < 0 || sort > 1) {
						System.out.println("선택이 잘못되었습니다.");
						System.out.println("올바른 정렬 방식을 선택해주세요.");
						continue;
					} else {
						System.out.printf("정렬할 과목을 선택하세요.\n");
						for (int i = 0; i<subject.length;i++) {
							System.out.printf("%d. %s\t",i+1,subject[i]);
						}
						System.out.println();
						System.out.print(">>> ");
						selectSubject = in.nextInt()-1;
						
						if (selectSubject < 0 || selectSubject > subject.length) {
							System.out.println("메뉴 선택이 잘못되었습니다.");
							System.out.println("올바른 메뉴를 선택해주세요.");
							continue;
						} else {
							int[][] sortResult = sort(idScore,sort,selectSubject);
							System.out.printf("%s과목 기준으로 %s한 결과는 다음과 같습니다.\n",subject[selectSubject],orderBy);
							for (int i = 0;i<idScore.length;i++) {
								System.out.printf("%s학생의 ",name[sortResult[0][i]]);
								for (int j = 0; j<subject.length;j++) {
									System.out.printf(" %s성적 : %d",subject[j],sortResult[j+1][i]);
								}
								System.out.println();
							}
						}
						
						
					}
					continue;
				case 5 :
					int select;
					showScore(idScore,name,subject,selectPrint);
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
								result = checkRange(score,range,rangeCount);
								System.out.printf("상위 학생들의 점수는 다음과 같습니다..\n");
								for (int i = 0; i < rangeCount;i++) {
									System.out.printf("상위 %d번 학생 : %d\n",i+1,result[i]);
									}
							}else {
								result = checkRange(score,range,rangeCount);
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
	
	
	
	public static void showScore(int[][] idScore,String[] name, String[] subject,int x) {
		System.out.println("=========================================");
		System.out.printf("현재 등록된 학생 수 : %d \n",name.length);
		System.out.printf("현재 등록된 과목 수 : %d \n",subject.length-1);
		System.out.println("=========================================");
		System.out.printf("입력된 학생들의 성적은 다음과 같습니다.\n");
		switch(x) {
		//인덱스 오류, 신경 쓸 것
		// 0 : 학생별 성적 나열, 1 : 과목별 성적 나열
		case 0:
			
			for (int i = 0; i<subject.length;i++) {
				for (int j = 0 ; j<name.length;j++) {
					System.out.printf("%s 학생의 %s성적 : %d\n",name[j],subject[i],idScore[i+1][j]);
				}
			}
			break;
		case 1:
			for (int i = 0; i<subject.length;i++) {
				for (int j = 0 ; j<name.length;j++) {
					System.out.printf("%s 학생의 %s성적 : %d\n",name[j],subject[i],idScore[i+1][j]);
				}
			}
			break;
		}
	}
	
	
	public static int sum(int arr[]) {
		int result = 0;
		for (int i = 0 ; i < arr.length;i++) {
			result += arr[i];
		}
		
		return result;
	}
	
	//2D Array 배열 합계
	public static int[] sum(int[][] arr,String[] subject,int x) {
		int[] result = new int[arr[0].length];
		int sum;
		switch(x) {
		// 학생별 총점
		case 0:
			for (int i = 0; i<arr[0].length;i++) {
				sum = 0;
				for (int j = 0 ; j<subject.length;j++) {
					sum += arr[j+1][i];
				}
				result[i]=sum;
			}
			break;
		// 과목별 총점
		case 1 :
			for (int i = 0; i<subject.length;i++) {
				sum = 0;
				for (int j = 0 ; j<arr[0].length;j++) {
					sum +=arr[i+1][j];
				}
				result[i]=sum;
			}		
			break;
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
	
	//2D Array 배열 평균
	public static double[] avg(int[][] arr, String[] subject, int x) {
		double[] result = new double[arr[0].length];
		int sum;
		switch(x) {
		// 학생별 평균
		case 0:
			for (int i = 0; i<arr[0].length;i++) {
				sum = 0;
				for (int j = 0 ; j<subject.length;j++) {
					sum += arr[j+1][i];
				}
				result[i]=sum/subject.length;
			}
			break;
		// 과목별 평균
		case 1 :
			for (int i = 0; i<subject.length;i++) {
				sum = 0;
				for (int j = 0 ; j<arr[0].length;j++) {
					sum +=arr[i+1][j];
				}
				result[i]=sum/arr[0].length;
			}		
			break;
		}
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
	
	public static int[] minMax(int[][] arr,String[] subject, int x, int y) {
		//최고 최저점 계산
		//초기 배열 생성
		int[] result = new int[arr.length];
		//기본 결과값 입력(arr 0번 배열 값)
		for (int i = 0 ; i < result.length;i++) {
			result[i] = arr[i][0];
		}
		//비교할 과목의 점수 초기값 설정
		int temp = result[y+1];
		switch(x) {
		//최대값 비교
		case 0:		
			for (int i = 0 ; i < arr.length ; i ++) {
				if(temp < arr[y+1][i]) {
					for (int j = 0 ; j < arr.length;j++)
						result[j] = arr[i][j];
				}
			}
			break;
		case 1:	
		//최소값 비교
			for (int i = 0 ; i < arr.length ; i ++) {
				if(temp > arr[i][y+1]) {
					for (int j = 0 ; j < arr.length;j++)
						result[j] = arr[j][y+1];
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
	
	public static int[][] sort(int[][] arr, int x, int y) {
		// 0 : 오름차순 / 1 : 내림차순
		int[] tempArr = new int[arr.length];
		switch(x) {
		case 0:
				for (int i = 0 ; i <arr.length-1;i++) {
					for (int j = 0; j<arr.length-1-i;j++) {
						if(arr[y+1][j]>arr[y+1][j+1]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[z][j+1];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j+1] = arr[z][j];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j] = tempArr[z];
								}
						}
					}
				}
				break;
			case 1:
				for (int i = 0 ; i <arr.length-1;i++) {
					for (int j = 0; j<arr.length-1-i;j++) {
						if(arr[y+1][j]<arr[y+1][j+1]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[z][j+1];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j+1] = arr[z][j];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j] = tempArr[z];
								}
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
