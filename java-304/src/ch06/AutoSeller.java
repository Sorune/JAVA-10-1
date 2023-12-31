package ch06;

import java.util.Scanner;

final class Menu {
	public String[] menuName;
	public int[][] menuList;
	// 0 : name, 1 : 수량, 2 : 원가, 3 : 판매가, 4 : 판매 개수
}

public class AutoSeller {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int ACCESS_CODE = 3917;
		boolean isFirstStart = true, loginProcess = false, administorMode = false;
		String[][] idArray = new String[10][2];
		String checkPass = "";
		Menu menu = new Menu();
		int menuCount = 0;
		//자판기 프로그램 변수
		int selectMode = 0;
		int runProcess = 1;
		int selectAdminMode = 0;
		//자판기 운영에 필요한 변수
		int cash = 0;
		
		
		while(isFirstStart) {
			System.out.println("자판기 관리 시스템을 시작합니다.");
			System.out.println("최초 사용자 등록이 필요합니다.");
			accountGenerator(idArray);
			isFirstStart = false;
			}
		
		while(runProcess == 1) {
			// Administor Login
			loginProcess = accountLogin(idArray);
			
			if(menu.menuList == null && menu.menuName == null) {
				System.out.println("자판기 메뉴를 등록합니다.");
				System.out.println("최대로 등록할 수 있는 자판기 메뉴 개수를 입력해 주세요.");
				System.out.print(">>> ");
				menuCount = in.nextInt();
				menu = addMenuList(menu,menuCount);
			} else {
				System.out.println("사용자 프로그램을 실행합니다.");
			}
			while (loginProcess) {
				//UserMenu Load
				System.out.println("사용할 메뉴를 선택해주세요");
				System.out.println("1. 요금 투입 \t2. 메뉴 선택\t3. 잔돈 반환");
				System.out.print(">>> ");
				selectMode = in.nextInt();
				switch(selectMode) {
				case 1:
					System.out.println("투입할 금액을 입력하세요.");
					System.out.print(">>> ");
					int cashCheck = in.nextInt();
					if (cashCheck < 0) {
						System.out.println("금액을 잘못 입력하셨습니다.");
						continue;
					}else { 
						cash += cashCheck;
						System.out.printf("현재 잔액은 %d원 입니다.\n",cash);
					}
					continue;
				case 2:
					System.out.println("구매할 상품을 선택하세요");
					for (int i = 0 ; i < menu.menuList.length ; i++) {
						if (menu.menuName[i]==null) break;
						if (menu.menuList[i][1]==0) {
							System.out.printf("%d. %s : SoldOut\n",i+1,menu.menuName[menu.menuList[i][0]]);
						} else {
							System.out.printf("%d. %s : %d원\n",i+1,menu.menuName[menu.menuList[i][0]],menu.menuList[i][3]);	
						}
					}
					System.out.print(">>> ");
					int choiceProduct = in.nextInt()-1;
					if (choiceProduct < 0 || choiceProduct > menu.menuList.length) {
						System.out.println("잘못된 번호입니다.");
						continue;
					} else {
						if(menu.menuList[choiceProduct][1]==0) {
							System.out.println("구매할 수 없습니다.");
							continue;
						}
						System.out.printf("구매할 개수를 입력하세요.(구매 가능한 개수 : %d개)\n",menu.menuList[choiceProduct][1]);
						System.out.print(">>> ");
						int productCount = in.nextInt();
						
						if (productCount < 0 || productCount>menu.menuList[choiceProduct][1]) {
							System.out.println("개수를 잘못 입력 하셨습니다.");
							continue;
						} else {
							if ((productCount*menu.menuList[choiceProduct][3])>cash) {
								System.out.println("잔액이 부족합니다.");
								System.out.println("금액을 더 투입하고 진행해 주세요");
							} else {
								cash -= productCount*menu.menuList[choiceProduct][3];
								menu.menuList[choiceProduct][1] -= productCount;
								menu.menuList[choiceProduct][4] += productCount;
								System.out.printf("%s %d개를 구매하였습니다.\n",menu.menuName[menu.menuList[choiceProduct][0]],productCount);
								System.out.printf("남은 잔액은 %d원입니다.\n",cash);
							}
							
						}
					}
					continue;
				case 3:
					System.out.println("잔돈을 반환합니다.");
					System.out.printf("반환된 금액은 %d원 입니다.\n",cash);
					cash = 0;
					System.out.printf("현재 잔액은 %d원 입니다.\n",cash);
					continue;
				case ACCESS_CODE:
					administorMode = accountLogin(idArray);
					if (administorMode) {
						System.out.println("관리자 모드로 진입합니다.");
					}
					else {
						System.out.println("로그인에 실패하였습니다. 메인메뉴로 돌아갑니다.");
					}
					while(administorMode) {
						System.out.println("관리자 모드입니다.");
						System.out.println("사용할 메뉴를 선택하세요");
						System.out.println("1. 관리자 계정 추가 \t2. 관리자 계정 삭제");
						System.out.println("3. 음료 수량 추가 \t\t4. 메뉴 변경");
						System.out.println("5. 판매 통계/수익 분석 \t\t6. 관리자 메뉴 종료");
						System.out.print(">>> ");
						selectAdminMode = in.nextInt();
						switch(selectAdminMode) {
						case 1:
							accountGenerator(idArray);
							continue;
						case 2:
							deleteAccount(idArray);
							continue;
						case 3:
							updateMenu(menu,0);
							continue;
						case 4:
							System.out.println("메뉴 변경 작업을 선택하세요.");
							System.out.println("1. 메뉴 변경 \t2. 메뉴 추가");
							int select = in.nextInt();
							updateMenu(menu,select);
							continue;
						case 5:

							int[][] soldData = existMenu(menu);
							int selectSort = 0,selectGuide = 0, selectMenu;
							// selectSort 0 : 오름차순 / 1 : 내림차순
							// selectGuide 2 : 원가, 3 : 판매가, 4 : 판매량
							
							
							boolean calculateProcess = true;
							while(calculateProcess) {

								System.out.println("분석할 내용을 선택하세요.");
								System.out.println("1. 총매출/순수익 분석\t2.판매량 순위 분석 \t3. 메뉴별 수익 분석 \t4. 분석 종료");
								System.out.print(">>> ");
								selectMenu = in.nextInt();
								switch(selectMenu) {
								case 1 :
									int totalCount = 0, totalPrice = 0, totalCost = 0;
									for (int i = 0 ; i < soldData.length ; i ++) {
										if(menu.menuName[i]==null) break;
										totalCount += soldData[i][4];
										totalPrice += soldData[i][4]*soldData[i][3];
										totalCost += soldData[i][4]*soldData[i][2];
									}
									System.out.printf("총 판매수 : %d 총 판매가 : %d 총 원가 : %d 총 순수익 : %d \n",totalCount,totalPrice,totalCost,totalPrice-totalCost);
									continue;
								case 2 :
									System.out.println("순위 기준을 선택하세요");
									System.out.println("1. 하위\t2. 상위");
									System.out.print(">>> ");
									selectSort = in.nextInt()-1;

									System.out.println("분석할 내용을 선택하세요");
									System.out.println("1. 원가\t2. 판매가\t3.판매량");
									System.out.print(">>> ");
									selectGuide = in.nextInt()+1;
									soldData = sort(soldData,selectSort, selectGuide);
									
									soldData = sort(soldData,selectSort, selectGuide);
									for (int i = 0 ; i < soldData.length ; i ++) {
										if(menu.menuName[i]==null) break;
										System.out.printf("%d. %s 원가 : %d 판매가 : %d 판매량 : %d 총매출 : %d 순수익 : %d\n",i+1,menu.menuName[soldData[i][0]],soldData[i][2],soldData[i][3],soldData[i][4],soldData[i][4]*soldData[i][3],(soldData[i][4]*soldData[i][3])-(soldData[i][4]*soldData[i][2]));
									}
									continue;
								case 3 :
									for (int i = 0 ; i < soldData.length ; i ++) {
										if(menu.menuName[i]==null) break;
										System.out.printf("%d. %s 원가 : %d 판매가 : %d 판매량 : %d 총매출 : %d 순수익 : %d\n",i+1,menu.menuName[soldData[i][0]],soldData[i][2],soldData[i][3],soldData[i][4],soldData[i][4]*soldData[i][3],(soldData[i][4]*soldData[i][3])-(soldData[i][4]*soldData[i][2]));

									}
									continue;
								case 4 :
									System.out.println("분석을 종료합니다.");
									calculateProcess = false;
								default:
									System.out.println("잘못된 메뉴 선택입니다.");
									continue;
								}
							}
							continue;
						case 6:
							System.out.println("관리자 모드를 종료합니다.");
							administorMode = false;
							break;
						default:
							System.out.println("잘못된 메뉴 선택입니다.");
							continue;
						}
					}
				default:
					System.out.println("잘못된 메뉴 선택입니다.");
				}
			}
		}
		
		
			
			
			
		
		
			
			
		}
	
	
	public static String[][] accountGenerator(String[][] idArray){
		Scanner in = new Scanner(System.in);
		boolean accountCreate = false;
		int count = 0;
		for (int i = 0; i < idArray.length ; i ++) {
			if (idArray[i][0]==null || idArray[i][0].isEmpty() || idArray[i][0].isBlank()) {
				count++;
			}
		}
		System.out.printf("현재 등록 가능한 관리자 계정은 %d개입니다.\n",count);
		for (int i = 0 ; i < idArray.length ; i ++) {
			if (idArray[i][0]==null ||idArray[i][0].isEmpty() || idArray[i][0].isBlank()) {
				System.out.println("사용할 ID릅 입력하세요");
				System.out.print(">>> ");
				idArray[i][0] = in.next();
				boolean checkProcess = true;
				do {
				
				System.out.println("사용할 PASSWORD릅 입력하세요");
				System.out.print(">>> ");
				String checkPass = in.next();
				System.out.println("PASSWORD릅 한번 더 입력하세요");
				System.out.print(">>> ");
				String tmp = in.next();
				
				if (tmp.equals(checkPass)) {
					idArray[i][1] = checkPass;
					checkProcess = false;
					accountCreate = true;
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}
				} while (checkProcess);
			}
			if(accountCreate) {
				System.out.println("사용자 등록을 완료하였습니다. 로그인 해주세요.");
				break;
				}
			
		}
	return idArray;
	}

	public static boolean accountLogin(String[][] idArray) {
		boolean isLogin = false;
		Scanner in = new Scanner(System.in);
		int count = 0 ;
		String checkPASS ="";
		do {
			
			System.out.println("ID를 입력하세요");
			System.out.print(">>> ");
			String checkID = in.next();
			if (checkID == null || checkID.isBlank() || checkID.isEmpty()) {
				System.out.println("ID가 잘못되었습니다. 다시 입력하세요.");
			} else {
					
					for (int i = 0; i<idArray.length ; i ++ ) {
						if(idArray[i][0].equals(checkID)) {
							do {
								System.out.println("PASSWORD를 입력하세요.");
								System.out.print(">>> ");
								checkPASS = in.next();
								count++;
								if (idArray[i][0].equals(checkID) && idArray[i][1].equals(checkPASS)) {
									isLogin = true;
								}
								
								if(count>5) break;
							} while (!checkPASS.equals(idArray[i][1]));
							
							break;
						}
					}
					count++;
			}
		} while (!isLogin && count < 5);
		
	return isLogin;
	}

	public static String[] addMenuName(String[] menuName,int x,int y) {
		if (menuName == null) {
			menuName = new String[x];
		}
		Scanner in = new Scanner(System.in);
		System.out.println("메뉴 이름을 입력하세요");
		System.out.print(">>> ");
		menuName[y] = in.next();
		
		return menuName;
	}
	
	public static Menu addMenuList(Menu menu, int x){
		// 1. 메뉴 수량 등록 2. 메뉴 이름 입력 3. 원가 입력 4. 판매가 입력
		if (menu.menuList == null) {
			menu.menuList = new int [x][5];
		}
		Scanner in = new Scanner(System.in);
		String input;
		for (int i = 0 ; i < menu.menuList.length ; i ++) {
			menu.menuList[i][0] = i;
			System.out.println("메뉴 수량을 입력하세요");
			System.out.println("입력을 종료하려면 exit를 입력해주세요");
			System.out.print(">>> ");
			input = in.next();
			if(input.equals("exit")) break;
			menu.menuList[i][1] = Integer.parseInt(input);
			menu.menuName = addMenuName(menu.menuName, x, i);
			System.out.println("메뉴 원가를 입력하세요");
			System.out.print(">>> ");
			input = in.next();
			menu.menuList[i][2] = Integer.parseInt(input);
			System.out.println("판매 단가를 입력하세요");
			System.out.print(">>> ");
			input = in.next();
			menu.menuList[i][3] = Integer.parseInt(input);
		}
		
		return menu;
	}
	
	public static String[][] deleteAccount(String[][] idArray){
		Scanner in = new Scanner(System.in);
		int count = 0 ;
		for (int i = 1 ; i < idArray.length ; i ++) {
			if(idArray[i][0]==null) {
				count ++;
			}
		}
		
		if (count == idArray.length-1) {
			System.out.println("삭제할 계정이 없습니다.");
		}else {
			System.out.println("삭제할 계정을 선택해 주세요.");
			
			if (count <10)
			for (int i = 1 ; i < idArray.length ; i ++) {
				if(idArray[i][0]==null) {
					break;
				} else {
					System.out.printf("%d. %s\t",i+1,idArray[i][0]);
				}
			}
			System.out.println();
			System.out.print(">>> "); 
			int delNum = in.nextInt()-1;
			if (delNum<0||delNum>idArray.length) {
				System.out.println("잘못된 번호입니다.");
				System.out.println("메인메뉴로 돌아갑니다.");
			}else {
				System.out.printf("선택한 아이디 %s를 삭제합니다.\n",idArray[delNum][0]);
				idArray[delNum][0] =null;
				idArray[delNum][1] =null;
			}
		}
		return idArray;
	}
	
	public static Menu updateMenu(Menu menu, int x) {
		Scanner in = new Scanner(System.in);
		String input;
		int choice = 0, count = 0;
		System.out.println("현재 재고는 다음과 같습니다.");
		for (int i = 0; i < menu.menuName.length;i++) {
			if(menu.menuName[i]==null) break;
			System.out.printf("%d. %s : %d개 ",i+1,menu.menuName[i],menu.menuList[i][1]);
		}
		System.out.println();
		switch(x) {
		case 0:
			//수량 추가
			int select = 0;
			System.out.println("수량 추가 방법을 선택하세요.");
			System.out.println("1. 메뉴 선택, 2. SoldOut 일괄 입고");
			select = in.nextInt();
			switch (select) {
			case 1:
				System.out.println("수정할 메뉴를 선택하세요.");
				for (int i = 0 ; i < menu.menuList.length ; i++) {
					if (menu.menuName[i]==null) break;
					System.out.printf("%d. %s\t",i+1,menu.menuName[i]);
				}
				System.out.print(">>> ");
				choice = in.nextInt()-1;
				System.out.println();
				System.out.println("메뉴 수량을 입력하세요");
				System.out.print(">>> ");
				input = in.next();
				menu.menuList[choice][1] += Integer.parseInt(input);
				System.out.printf("선택한 메뉴 %s 의 수량은 %d 입니다.\n",menu.menuName[choice],menu.menuList[choice][1]);
				break;
			case 2:
				System.out.println("추가할 수량을 입력하세요");
				count = in.nextInt();
				for (int i = 0 ; i < menu.menuList.length ; i++) {
					if (menu.menuName[i]==null) break;
					if (menu.menuList[i][1]==0) {
						menu.menuList[i][1] = count;
						System.out.printf("%d. %s : %d개\t",i+1,menu.menuName[i],menu.menuList[i][1]);
					}
				}
				System.out.println("추가 입고를 완료하였습니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
			}
			
			break;
		case 1:
			//메뉴 수정
			System.out.println("수정할 메뉴를 선택하세요.");
			for (int i = 0 ; i < menu.menuList.length ; i++) {
				if (menu.menuName[i]==null) break;
				System.out.printf("%d. %s\t",i+1,menu.menuName[i]);
			}
			System.out.println();
			System.out.print(">>> ");
			choice = in.nextInt()-1;
			System.out.println();
			menu.menuName = addMenuName(menu.menuName, x, choice);
			System.out.println("메뉴 원가를 입력하세요");
			System.out.print(">>> ");
			input = in.next();
			menu.menuList[choice][2] = Integer.parseInt(input);
			System.out.println("판매 단가를 입력하세요");
			System.out.print(">>> ");
			input = in.next();
			menu.menuList[choice][3] = Integer.parseInt(input);
			menu.menuList[choice][4] = 0;
			break;
		case 2:
			int countMenu = 0;
			for (int i = 0 ; i < menu.menuList.length ; i++) {
				if (menu.menuName[i]==null) countMenu++;
			}
			System.out.printf("현재 추가 가능한 메뉴는 %d개 입니다.\n",countMenu);
			if (countMenu == 0) {
				System.out.println("추가 가능한 자리가 없습니다.");
			} else {
				for (int i = 0 ; i < menu.menuList.length ; i ++) {
					if (menu.menuName[i]==null) {
						menu.menuList[i][0] = i;
						System.out.println("메뉴 수량을 입력하세요");
						System.out.println("입력을 종료하려면 exit를 입력해주세요");
						System.out.print(">>> ");
						input = in.next();
						if(input.equals("exit")) break;
						menu.menuList[i][1] = Integer.parseInt(input);
						menu.menuName = addMenuName(menu.menuName, x, i);
						System.out.println("메뉴 원가를 입력하세요");
						System.out.print(">>> ");
						input = in.next();
						menu.menuList[i][2] = Integer.parseInt(input);
						System.out.println("판매 단가를 입력하세요");
						System.out.print(">>> ");
						input = in.next();
						menu.menuList[i][3] = Integer.parseInt(input);
						}
					}
			}
			break;
		default:
			System.out.println("번호를 잘못 입력하였습니다.");
		}
		return menu;
	}
	
	public static int[][] sort(int[][] arr, int x, int y) {
		// 0 : 오름차순 / 1 : 내림차순
		int[] tempArr = new int[arr[0].length];
		switch(x) {
		case 0:
				for (int i = 0 ; i <arr.length-1;i++) {
					for (int j = 0; j<arr.length-1-i;j++) {
						if(arr[j][y]>arr[j+1][y]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[j+1][z];
									arr[j+1][z] = arr[j][z];
									arr[j][z] = tempArr[z];
								}
						}
					}
				}
				break;
			case 1:
				for (int i = 0 ; i <arr.length-1;i++) {
					for (int j = 0; j<arr.length-1-i;j++) {
						if(arr[j][y]<arr[j+1][y]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[j+1][z];
									arr[j+1][z] = arr[j][z];
									arr[j][z] = tempArr[z];
								}
						}
					}
				}
				break;
			}
		return arr;
	
	}
	
	public static int[][] existMenu(Menu menu){
		int[][] result;
		int count = 0;
		for (int i = 0; i< menu.menuName.length;i++) {
			if(menu.menuName[i]!= null) count++;
		}
		result = new int[count][menu.menuList[0].length];
		
		for(int i = 0 ; i < count ; i ++) {
			for (int j = 0 ; j < menu.menuList[i].length;j++) {
				result[i][j] = menu.menuList[i][j];
			}
		}
		return result;
	}
}