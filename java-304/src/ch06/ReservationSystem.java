package ch06;

import java.util.Scanner;

final class ResistInfo {
	
	public String[][] rooms;
	// 0 : 이름 1 : 연락처 2 : 예약 날짜 정보 3 : 예약 호실 정보 4 : 확인용 비밀번호
	public String[] USER_KEY = {"이름","연락처","예약 날짜 정보","예약 호실 정보"};
	public String[][] users;
}

 

public class ReservationSystem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//날짜 배열 만들기 위한 월별 일수 배열
		//날짜별 숙소 예약정보, 날짜 입력 받아서 연박 예약 기능 구현 예정
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[][] calander = new String[12][];
		for (int i = 0 ; i < calander.length ; i ++) {
			calander[i] = new String[month[i]];
		}
		
		ResistInfo info = new ResistInfo();
		
		//방 정보 배열 만들기
		info.rooms = new String[6][];
		for (int i = 0 ; i < info.rooms.length ; i ++) {
			int count = 8;
			if (i==0) count = 5;
			info.rooms[i] = new String[count];
		}
		info.users = new String[100][5];
		boolean mainloof = true;
		int selectMenu = 0;
		
		System.out.println("========================================");
		System.out.println("=============숙소 예약 프로그램==============");
		while(mainloof) {

		System.out.println("========================================");
		System.out.println("원하시는 메뉴를 선택해 주세요.");
		System.out.println("1. 숙소 현항\t2. 예약하기");
		System.out.println("3. 예약 확인\t4. 예약 변경/취소하기");
		System.out.println("5.프로그램 종료");
		System.out.print(">>> ");
		selectMenu = in.nextInt();
		switch(selectMenu) {
		case 1:

			System.out.println("========================================");
			System.out.println("현재 숙소 예약 목록입니다.");
			System.out.println("방 번호가 표시된 방은 예약 가능한 방입니다.");
			showResInfo(info.rooms,1);
			continue;
		case 2:

			System.out.println("========================================");
			info = reservationGenerator(info);
			continue;
		case 3:

			System.out.println("========================================");
			System.out.println("숙소 예약정보를 확인합니다.");
			String[] resInfo = userLogin(info.users);
			if (resInfo[0]!=null) {
				for (int i = 0 ; i < info.USER_KEY.length ; i ++) {
					System.out.printf("%s : %s\n",info.USER_KEY[i],resInfo[i]);
				}
			}
			continue;
		case 4:
			info = updateRes(info);
			continue;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			mainloof = false;
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
			continue;
		}
		
		
		}
//		
//		String[] test;
//		String t1 = "0,0,0,0,0,7,0,0";
//		test = t1.split(",");
//		for (int k = 0 ; k < test.length ; k++) {
//			System.out.printf("[%s]",test[k]);
//		}
//		
//		System.out.println();
//		
//		String t2 = "";
//		for (int k = 0 ; k < rooms.length ; k ++) {
//			for (int z = 0 ; z < rooms[k].length ; z++) {
//				t2 += rooms[k][z];
//				t2 += ",";
//			}
//			t2 += "/";
//		}
//		
//		System.out.println(t2);
//		
//		String [][] tt1 = new String[rooms.length][];
//		String [] tt2 = t2.split("/");
//		for (int k = 0 ; k <tt1.length ; k ++) {
//			tt1[k] = tt2[k].split(",");
//		}
//		
//		System.out.println();
//		showResInfo(tt1);
	}
	
	public static void showResInfo(String[][] rooms, int x) {
		System.out.println("========================================");
		switch(x) {
		case 1:
			for (int i = rooms.length ; i > 0 ; i --) {
				for (int j = 0 ; j<rooms[i-1].length;j++) {
					if (rooms[i-1][j]==null||rooms[i-1][j].isBlank()||rooms[i-1][j].isEmpty()||rooms[i-1][j].equals("null")||rooms[i-1][j].equals("-1")) {
						System.out.printf("[%03d]",(i*100)+(j+1));
					} else {
						System.out.printf("[ x ]");
					}
				}
				System.out.println();
			}	
			break;
		case 2:

			for (int i = rooms.length ; i > 0 ; i --) {
				for (int j = 0 ; j<rooms[i-1].length;j++) {	
					System.out.printf("[%03d]",(i*100)+(j+1));
				}
				System.out.println();
			}
		
			break;
		}	System.out.println("========================================");
	}
	
	public static String[][] getResInfo(String t, String[][]rooms){
		
		String [][] tt1 = new String[rooms.length][];
		String [] tt2 = t.split("/");
		for (int k = 0 ; k <tt1.length ; k ++) {
			tt1[k] = tt2[k].split(",");
		}
		rooms = tt1;
		return rooms;
	}
	
	public static String[][] saveUserRes (String[][] rooms, String roomNum, int id){
		int i = Integer.parseInt(roomNum.substring(0, 1));
		int j = Integer.parseInt(roomNum.substring(roomNum.length()-1, roomNum.length()));
		rooms[i-1][j-1] = Integer.toString(id);
		return rooms;
	}
	
	public static boolean checkUserRes (String[][] rooms,String roomNum) {
		boolean isIn = false;
		int i = Integer.parseInt(roomNum.substring(0, 1));
		int j = Integer.parseInt(roomNum.substring(roomNum.length()-1, roomNum.length()));
		if(!(rooms[i-1][j-1]==null||rooms[i-1][j-1].isBlank()||rooms[i-1][j-1].isEmpty()||rooms[i-1][j-1].equals("null")||Integer.parseInt(rooms[i-1][j-1])<0)) isIn = true;
		return isIn;
	}

	public static ResistInfo reservationGenerator(ResistInfo info){
		Scanner in = new Scanner(System.in);
		boolean accountCreate = false;
		int count = 0;
		for (int i = 0; i < info.users.length ; i ++) {
			if (info.users[i][0]==null || info.users[i][0].isEmpty() || info.users[i][0].isBlank()) {
				count++;
			}
		}
		for (int i = 0 ; i < info.users.length ; i ++) {
			if (info.users[i][0]==null ||info.users[i][0].isEmpty() || info.users[i][0].isBlank()) {
				//이름 생성
				System.out.println("예약자의 이름을 입력하세요");
				System.out.print(">>> ");
				info.users[i][0] = in.next();
				
				String roomNum = "";
				boolean reservation = false;
				do {
					showResInfo(info.rooms,1);
					
					System.out.println("예약할 호실을 입력하세요.");
					System.out.print(">>> ");
					roomNum = in.next();
					
					if(checkUserRes(info.rooms,roomNum)||!roomNum.substring(1,2).equals("0")) {
						System.out.println("예약할 수 없는 방입니다.");
						System.out.println("다른 방을 골라주세요.");
					} else {
						info.rooms = saveUserRes(info.rooms,roomNum,i);
						info.users[i][3] = roomNum;
						reservation = true;
					}
				} while (!reservation);
				//연락처 입력

				System.out.println("연락처를 입력하세요.");
				System.out.println("ex) 010-1234-5678");
				System.out.print(">>> ");
				info.users[i][1] = in.next();
				
				//예약 날짜
				
				
				
				//
				
				// 비밀번호 생성
				boolean checkProcess = true;
				do {
				
				System.out.println("사용할 PASSWORD릅 입력하세요");
				System.out.print(">>> ");
				String checkPass = in.next();
				System.out.println("PASSWORD릅 한번 더 입력하세요");
				System.out.print(">>> ");
				String tmp = in.next();
				
				if (tmp.equals(checkPass)) {
					info.users[i][4] = checkPass;
					checkProcess = false;
					accountCreate = true;
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}
				} while (checkProcess);
			}
			if(accountCreate) {
				System.out.println("예약자 정보 생성이 완료되었습니다.");
				break;
				}
			
		}
	return info;
	}

	public static String checkResInfo(String[][] idArray) {
		boolean isLogin = false;
		Scanner in = new Scanner(System.in);
		int count = 0 , index = 0 ;
		String checkPASS ="", indexID="";
		do {
			
			System.out.println("이름를 입력하세요");
			System.out.print(">>> ");
			String checkID = in.next();
			if (checkID == null || checkID.isBlank() || checkID.isEmpty()) {
				System.out.println("잘못 입력하셨습니다.");
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
									index = i;
								}
								
								if(count>5) break;
							} while (!checkPASS.equals(idArray[i][1]));
							
							break;
						}
					}
					
					if (!isLogin) {
						System.out.println("예약자 정보가 확인되지 않았습니다.");
						System.out.println("예약 정보를 다시 확인해 주세요.");
						indexID = "0";
					} else {
						indexID = Integer.toString(index);
					}
					count++;
			}
		} while (!isLogin && count < 5);
		
	return indexID;
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
			System.out.println("삭제할 예약정보가 없습니다.");
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
	

	public static String[] userLogin(String[][] idArray) {
		boolean isLogin = false;
		Scanner in = new Scanner(System.in);
		String[] result = new String[5];
		int count = 0 ;
		String checkPASS ="";
		do {
			
			System.out.println("이름 입력하세요");
			System.out.println("나가시려면 exit를 입력해 주세요.");
			System.out.print(">>> ");
			String checkID = in.next();
			if (checkID == null || checkID.isBlank() || checkID.isEmpty()) {
				System.out.println("이름이 잘못되었습니다. 다시 입력하세요.");
			} else if (checkID.equals("exit")) {
				break;
			} else {
					
					for (int i = 0; i<idArray.length ; i ++ ) {
						if(!(idArray[i][0]==null)&&idArray[i][0].equals(checkID)) {
							do {
								System.out.println("PASSWORD를 입력하세요.");
								System.out.print(">>> ");
								checkPASS = in.next();
								count++;
								if (idArray[i][0].equals(checkID) && idArray[i][4].equals(checkPASS)) {
									isLogin = true;
									for (int j = 0 ; j < result.length ; j ++) {
										result[j] = idArray[i][j];
									}
								}
								
								if(count>5) break;
							} while (!checkPASS.equals(idArray[i][4]));
							
							break;
						} else {}
					}
					count++;
					if (!isLogin) {
						System.out.println("예약자 정보가 없습니다.");
					}
			}
		} while (!isLogin && count < 5);
		
	return result;
	}

	public static ResistInfo updateRes(ResistInfo info) {
		boolean isLogin = false;
		Scanner in = new Scanner(System.in);
		String[] result = new String[5];
		int count = 0 ;
		String checkPASS ="";
		do {
			
			System.out.println("이름을 입력하세요");
			System.out.println("나가시려면 exit를 입력해 주세요.");
			System.out.print(">>> ");
			String checkID = in.next();
			if (checkID == null || checkID.isBlank() || checkID.isEmpty()) {
				System.out.println("이름이 잘못되었습니다. 다시 입력하세요.");
			} else if (checkID.equals("exit")) {
				break;
			} else {
					
					for (int i = 0; i<info.users.length ; i ++ ) {
						if(!(info.users[i][0]==null)&&info.users[i][0].equals(checkID)) {
							do {
								System.out.println("PASSWORD를 입력하세요.");
								System.out.print(">>> ");
								checkPASS = in.next();
								count++;
								if (info.users[i][0].equals(checkID) && info.users[i][4].equals(checkPASS)) {
									while (!isLogin) {
										System.out.println("작업을 선택해 주세요");
										System.out.println("1. 예약 변경\t2.예약 취소");
										int choiceMenu = in.nextInt();
										switch (choiceMenu) {
										case  1:
											System.out.println("변경할 내용을 선택하세요.");
											for (int j = 0 ; j < info.USER_KEY.length ; j++) {
												System.out.printf("%d. %s\t",j+1,info.USER_KEY[j]);
											}
											System.out.println();
											System.out.print(">>> ");
											int z = in.nextInt()-1;
											if (z==3){
												System.out.println("변경할 호실을 입력해 주세요");
												showResInfo(info.rooms,1);
												System.out.printf("기존 %s : %s\n",info.USER_KEY[z],info.users[i][z]);
												System.out.print(">>> ");
												String tmp = in.next();
												if(checkUserRes(info.rooms,tmp)||!tmp.substring(1,2).equals("0")) {
													System.out.println("예약할 수 없는 방입니다.");
													System.out.println("다른 방을 골라주세요.");
												} else {
													info.rooms = saveUserRes(info.rooms,info.users[i][z],-1);
													info.rooms = saveUserRes(info.rooms,tmp,i);
												}
											} else {
												System.out.printf("변경할 %s의 내용을 입력하세요.\n",info.USER_KEY[z]);
												System.out.printf("기존 %s : %s\n",info.USER_KEY[z],info.users[i][z]);
												System.out.print(">>> ");
												String tmp = in.next();
												info.users[i][z] = tmp;
											}
											isLogin = true;
											break;
										case 2:
											System.out.println("예약을 취소하시겠습니까?");
											System.out.println("취소하시려면 y를 눌러주세요");
											System.out.print(">>> ");
											String s = in.next();
											if (s.toLowerCase().equals("y")) {
												info.rooms = saveUserRes(info.rooms,info.users[i][3],-1);
												for (int w = 0 ; w < info.rooms[i].length ; w ++ ) {
													info.rooms[i][w] = null;
												}
											} else {
												System.out.println("잘못 입력하셨습니다.");
											}
												
											isLogin = true;
											break;
										default :
											System.out.println("잘못 입력하셨습니다.");
										}
									}

								}
								
								if(count>5) break;
							} while (!checkPASS.equals(info.users[i][4]));
							
							break;
						} else {}
					}
					count++;
					
					if (!isLogin) {
						System.out.println("예약자 정보가 없습니다.");
					}
			}
		} while (!isLogin && count < 5);
		
	return info;
	}
}

