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
			
			if (count < 1) {
				System.out.println("학생 수가 너무 적습니다.");
				System.out.println("1명 이상의 학생을 입력해 주세요 적습니다.");
				continue;
			}
			
			
			
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
			// [[0, 1,2,3,4], [75, 85, 85, 55,85], [65, 95, 85, 44,95],{75,65,85,75,35]
			// idScore[과목][점수,0번 인덱스는 이름 배열로 매칭될 id로 설정]
			// idScore[0][i] = name[i]
			// idScore[i+1][0] = subject[i]
			// idScore[i+1][j] = name[j] 학생의 subject[i]과목 점수
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
				System.out.println("7. 수정 모드 \t8. 성적표 출력 ");
				System.out.println("9. 초기 화면 \t10. 프로그램 종료");
				System.out.println("======================================");
				System.out.print(">>> ");
				
				menuSelect = in.nextInt();
				
				if (menuSelect < 1 || menuSelect > 10) {
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
				//평균 계산
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
				// 최고, 최저 찾기
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
						selectSubject = in.nextInt();
						
						if (selectSubject < 0 || selectSubject > subject.length) {
							System.out.println("메뉴 선택이 잘못되었습니다.");
							System.out.println("올바른 메뉴를 선택해주세요.");
							continue;
						} else {
							result = minMax(idScore,subject,minMax,selectSubject);
							System.out.printf("%s과목의 %s은 %d점인 %s학생입니다.",subject[selectSubject-1],minMaxString,result[selectSubject],name[result[0]]);
						}
						
					}
					System.out.println();
					continue;
				// 버블정렬
				case 4:
					System.out.println("학생들의 성적을 정렬합니다.");
					System.out.println("정렬할 방식을 선택해 주세요.");
					System.out.println("1. 오름차순 \t 2. 내림차순");
					//정렬 방식 설정, 0 : 오름차순, 1 : 내림차순
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
						selectSubject = in.nextInt();
						
						if (selectSubject < 0 || selectSubject > subject.length) {
							System.out.println("메뉴 선택이 잘못되었습니다.");
							System.out.println("올바른 메뉴를 선택해주세요.");
							continue;
						} else {
							int[][] sortResult = sort(idScore,sort,selectSubject);
							System.out.printf("%s과목 기준으로 %s한 결과는 다음과 같습니다.\n",subject[selectSubject-1],orderBy);
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
					
				// 학점 확인
				// 선택된 학생으 평균을 학점으로 변환
				case 5 :
					int select;
					showScore(idScore,name,subject,selectPrint);
					System.out.println("확인할 학생을 선택해 주세요.");
					for (int i = 0; i<name.length;i++) {
						System.out.printf("%d. %s\t",i+1,name[i]);
					}
					System.out.println();
					System.out.print(">>> ");
					select = in.nextInt()-1;
					
					if (select<0 || select > name.length) {
						System.out.println("잘못된 번호입니다.");
						System.out.println("정확한 학생의 번호를 입력해 주세요.");
						continue;
					}
					dbresult = avg(idScore,subject,0);
					
					System.out.printf("%s학생의 학점은 %s입니다.\n",name[select],gradeCheck(dbresult[select]));
					continue;

				// 상위/하위 학생 출력
				// 출력 방식은 버블 정렬 실행 후 인덱스 0부터 입력한 숫자까지 끊어서 출력
				case 6 :
					int range = 0;
					
					System.out.println("확인할 범위를 선택해 주세요");
					System.out.println("1. 상위 \t2. 하위");
					System.out.print(">>> ");
					range = in.nextInt()-1;
					
					if(range == 0) {orderBy = "상위";} else {orderBy = "하위";}
					
					if (range < 0 || range > 1) {
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
						selectSubject = in.nextInt();
						
						if (selectSubject < 0 || selectSubject > subject.length) {
							System.out.println("메뉴 선택이 잘못되었습니다.");
							System.out.println("올바른 메뉴를 선택해주세요.");
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

									int[][] result2D = checkRange(idScore,range,selectSubject);
									System.out.printf("%s과목 기준으로 %s한 결과는 다음과 같습니다.\n",subject[selectSubject-1],orderBy);
									for (int i = 0; i < rangeCount;i++) {
										System.out.printf("하위 %d번 %s학생의 %s점수 : %d\n",i+1,name[result2D[0][i]],subject[selectSubject-1],result2D[selectSubject][i]);
										}
								}else {
									int[][] result2D = checkRange(idScore,range,selectSubject);
									System.out.printf("%s과목 기준으로 %s한 결과는 다음과 같습니다.\n",subject[selectSubject-1],orderBy);
									for (int i = 0; i < rangeCount;i++) {
										System.out.printf("하위 %d번 %s학생의 %s점수 : %d\n",i+1,name[result2D[0][i]],subject[selectSubject-1],result2D[selectSubject][i]);
										}
								}

							}
						}
					
					}
					continue;
				case 7:
					int selectMod = 0;
					System.out.println("======================================");
					System.out.println("수정할 항목을 선택하세요.");
					System.out.println("1. 학생명 \t2. 성적");
					System.out.print(">>> ");
					selectMod = in.nextInt();
					switch(selectMod) {
					case 1:
						System.out.println("======================================");
						System.out.println("수정할 학생을 선택하세요");
						for (int i = 0 ; i < idScore[0].length;i++) {
							System.out.printf("%d. %s\t",i+1,name[idScore[0][i]]);
						}
						System.out.println();
						System.out.print(">>> ");
						int selectName;
						selectName = in.nextInt()-1;
						String t = in.nextLine();
						if (selectName < 0 || selectName>idScore[0].length) {
							System.out.println("잘못된 학생을 입력하셨습니다.");
							System.out.println("정확한 학생을 입력해 주세요");
						} else {
							System.out.println("수정할 이름을 입력하세요.");
							System.out.print(">>> ");
							name[idScore[0][selectName]] = in.nextLine();
						}
						System.out.println();
						System.out.println("수정된 학생 목록은 다음과 같습니다.");
						for (int i = 0 ; i < idScore[0].length;i++) {
							System.out.printf("%d. %s\n",i+1,name[idScore[0][i]]);
						}
						continue;
					case 2:
						System.out.println("======================================");
						System.out.println("수정할 학생을 선택하세요");
						for (int i = 0 ; i < idScore[0].length;i++) {
							System.out.printf("%d. %s\t",i+1,name[idScore[0][i]]);
						}
						System.out.println();
						System.out.print(">>> ");
						selectName = in.nextInt()-1;
						t = in.nextLine();
						if (selectName < 0 || selectName>idScore[0].length) {
							System.out.println("잘못된 학생을 입력하셨습니다.");
							System.out.println("정확한 학생을 입력해 주세요");
						} else {
							System.out.println("======================================");
							System.out.println("수정할 과목을 선택하세요");
							for (int i = 0 ; i < subject.length;i++) {
								System.out.printf("%d. %s\t",i+1,subject[i]);
							}
							System.out.print(">>> ");
							selectSubject = in.nextInt();
							
							if (selectSubject < 0 || selectSubject>subject.length) {
								System.out.println("잘못된 과목을 입력하셨습니다.");
								System.out.println("정확한 과목을 입력해 주세요");
							} else {
								System.out.println("수정할 점수를 입력하세요.");
								System.out.print(">>> ");
								idScore[selectSubject][selectName] = in.nextInt();
							}
							System.out.println();
							System.out.println("수정된 과목 점수 목록은 다음과 같습니다.");
							for (int i = 0 ; i < idScore[0].length;i++) {
								System.out.printf("%s학생의 %s점수 : %d\n",name[idScore[0][i]],subject[selectSubject-1],idScore[selectSubject][i]);
							}
						}
					}
					continue;
				case 8:
					selectMod = 0;
					System.out.println("======================================");
					System.out.println("출력할 항목을 선택하세요.");
					System.out.println("1. 학생별 \t2. 과목별");
					System.out.print(">>> ");
					selectMod = in.nextInt();
					switch(selectMod) {
					case 1:
						System.out.println("======================================");
						System.out.println("출력할 학생을 선택하세요");
						for (int i = 0 ; i < idScore[0].length;i++) {
							System.out.printf("%d. %s\t",i+1,name[idScore[0][i]]);
						}
						System.out.println();
						System.out.print(">>> ");
						int selectName;
						selectName = in.nextInt()-1;
						String t = in.nextLine();
						if (selectName < 0 || selectName>idScore[0].length) {
							System.out.println("잘못된 학생을 입력하셨습니다.");
							System.out.println("정확한 학생을 입력해 주세요");
						} else {
							System.out.println("======================================");
							System.out.printf("%s학생의 성적표 입니다.\n",name[selectName]);
							System.out.println("======================================");
							for (int i = 0 ; i < subject.length;i++) {
								System.out.printf("%d.%s : %d 학점 : %s\n",i+1,subject[i],idScore[i+1][selectName],gradeCheck(idScore[i+1][selectName]));
							}
						}
						continue;
					case 2:
						System.out.println("======================================");
						System.out.println("출력할 과목을 선택하세요");
						for (int i = 0 ; i < subject.length;i++) {
							System.out.printf("%d. %s\t",i+1,subject[i]);
						}
						System.out.println();
						System.out.print(">>> ");
						selectSubject = in.nextInt();
						t = in.nextLine();
						if (selectSubject < 0 || selectSubject>subject.length) {
							System.out.println("잘못된 과목을 입력하셨습니다.");
							System.out.println("정확한 과목을 입력해 주세요");
						} else {
							System.out.println("======================================");
							System.out.printf("%s과목의 성적표 입니다.\n",subject[selectSubject-1]);
							System.out.println("======================================");
							for (int i = 0 ; i < idScore[0].length;i++) {
								System.out.printf("%d.%s : %d 학점 : %s\n",i+1,name[idScore[0][i]],idScore[selectSubject][i],gradeCheck(idScore[selectSubject][i]));
							}
						}
					}
					continue;
				case 9 :
					System.out.println("초기화면으로 돌아갑니다.");
					mainMenu = 0;
					continue;
				case 10 :
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
			
			for (int j = 0; j<name.length;j++) {
				for (int i = 0 ; i<subject.length;i++) {
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
		int[] result;
		if (x==0) { result = new int[arr[0].length];}
		else {result = new int[subject.length];}
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
		double[] result;
		if (x==0) { result = new double[arr[0].length];}
		else {result = new double[subject.length];}
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
		int temp = result[y];
		switch(x) {
		//최대값 비교
		case 0:		
			for (int i = 0 ; i < arr[y].length ; i ++) {
				if(temp < arr[y][i]) {
					for (int j = 0 ; j < arr.length;j++) {
						result[j] = arr[j][i];
						temp = arr[y][i];
					}
				}
			}
			break;
		case 1:	
		//최소값 비교
			for (int i = 0 ; i < arr[y].length ; i ++) {
				if(temp > arr[y][i]) {
					for (int j = 0 ; j < arr.length;j++) {
						result[j] = arr[j][i];
						temp = arr[y][i];
					}
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
				for (int i = 0 ; i <arr[y].length-1;i++) {
					for (int j = 0; j<arr[y].length-1-i;j++) {
						if(arr[y][j]>arr[y][j+1]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[z][j+1];
									arr[z][j+1] = arr[z][j];
									arr[z][j] = tempArr[z];
								}
						}
					}
				}
				break;
			case 1:
				for (int i = 0 ; i <arr[y].length-1;i++) {
					for (int j = 0; j<arr[y].length-1-i;j++) {
						if(arr[y][j]<arr[y][j+1]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[z][j+1];
									arr[z][j+1] = arr[z][j];
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
	
	public static String gradeCheck(double x) {
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

	public static int[][] checkRange(int[][] arr, int x, int y) {
	// 0 : 오름차순 / 1 : 내림차순
	int[][] result = new int[arr.length][arr[0].length];
	int[] tempArr = new int[arr.length];
	switch(x) {
	case 1:
			for (int i = 0 ; i <arr[y].length-1;i++) {
				for (int j = 0; j<arr[y].length-1-i;j++) {
					if(arr[y][j]>arr[y][j+1]) {
							for (int z = 0;z<tempArr.length;z++) {
								tempArr[z] = arr[z][j+1];
								arr[z][j+1] = arr[z][j];
								arr[z][j] = tempArr[z];
							}
					}
				}
			}
			break;
		case 0:
			for (int i = 0 ; i <arr[y].length-1;i++) {
				for (int j = 0; j<arr[y].length-1-i;j++) {
					if(arr[y][j]<arr[y][j+1]) {
							for (int z = 0;z<tempArr.length;z++) {
								tempArr[z] = arr[z][j+1];
								arr[z][j+1] = arr[z][j];
								arr[z][j] = tempArr[z];
							}
					}
				}
			}
			break;
		}
	for (int i = 0 ; i< arr.length ; i++) {
		for (int j = 0; j <arr[0].length ; j++ ) {
			result[i][j] = arr[i][j];
		}
	}
	return result;
	}
}