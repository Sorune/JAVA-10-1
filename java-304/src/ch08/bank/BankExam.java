package ch08.bank;

import java.util.Scanner;

public class BankExam {

	private static Account[] accountArr = new Account[100];
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true; //메뉴용 변수
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 계좌 생성 | 2.계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료 ");
			System.out.println("-------------------------------------------------");
			System.out.print(">>> ");
			int selectNo = in.nextInt();
			System.out.println("-------------------------------------------------");
			switch (selectNo) {
			case 1: // 계좌 생성
				createAccount();
				break;
			case 2: // 계좌 목록
				showAccount();
				break;
			case 3: // 예금
				addAccountBalance(selectNo);
				break;
			case 4: // 출금
				minAccountBalance(selectNo);
				break;
			case 5: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴 선택입니다.");
			}
			
		} // while문 종료(메뉴용)
		
	}

	private static void minAccountBalance(int selectNum) {
		// TODO Auto-generated method stub
		System.out.println("---------------------예금 출금---------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("출금하실 계좌번호를 입력해 주세요.");
		System.out.print(">>> ");
		String ano = in.next();
		System.out.println("예금주명을 입력해 주세요.");
		System.out.print(">>> ");
		String owner = in.next();
		boolean flag = false;
		for (int i = 0 ; i < accountArr.length ; i ++) {
			if (accountArr[i].getAno().equals(ano) && accountArr[i].getOwner().equals(owner) ) {
				System.out.println("출금할 금액을 입력해 주세요.");
				System.out.print(">>> ");
				int balance = in.nextInt();
				int tmp = accountArr[i].getBalance();
				accountArr[i].setBalance(balance, selectNum);
				if (tmp == accountArr[i].getBalance()) {
					break;
				} else {
					System.out.printf("계좌번호 : %s 계좌주 : %s 계좌잔액 : %d 출금금액 : %d\n",
							accountArr[i].getAno(),
							accountArr[i].getOwner(),
							accountArr[i].getBalance(),
							balance);
					flag = true;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("출금이 완료되었습니다.");
		} else {
			System.out.println("출금에 실패하였습니다.");
		}
	}

	private static void addAccountBalance(int selectNum) {
		// 계좌번호를 찾아 키보드로 입력된 금액을 누적한다.
		System.out.println("---------------------예금 입금---------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("입금하실 계좌번호를 입력해 주세요.");
		System.out.print(">>> ");
		String ano = in.next();
		System.out.println("예금주명을 입력해 주세요.");
		System.out.print(">>> ");
		String owner = in.next();
		boolean flag = false;
		for (int i = 0 ; i < accountArr.length ; i ++) {
			if (accountArr[i].getAno().equals(ano) && accountArr[i].getOwner().equals(owner) ) {
				System.out.println("입금할 금액을 입력해 주세요.");
				System.out.print(">>> ");
				int balance = in.nextInt();
				accountArr[i].setBalance(balance, selectNum);
				System.out.printf("계좌번호 : %s 계좌주 : %s 계좌잔액 : %d 입금금액 : %d\n",
						accountArr[i].getAno(),
						accountArr[i].getOwner(),
						accountArr[i].getBalance(),
						balance);
				flag=true;
				break;
			}
		}
		if (flag) {
			System.out.println("입금이 완료되었습니다.");
		} else {
			System.out.println("계좌번호를 찾을 수 없습니다.");
		}
		
	}

	private static void showAccount() {
		// TODO Auto-generated method stub
		System.out.println("---------------------계좌 목록---------------------");
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < accountArr.length ; i ++) {
			if (accountArr[i]==null) break;
			System.out.printf("%d. 계좌번호 : %s 계좌주 : %s 계좌잔액 : %d\n",
					i+1,
					accountArr[i].getAno(),
					accountArr[i].getOwner(),
					accountArr[i].getBalance());
		}
	}

	public static void createAccount() {
		for (int i = 0 ; i < accountArr.length ; i ++) {
			if ( accountArr[i]==null) {
				System.out.println("---------------------계좌 생성---------------------");
				System.out.println("-------------------------------------------------");
				System.out.println("계좌번호를 입력해 주세요.");
				System.out.print(">>> ");
				String ano = in.next();
				System.out.println("계좌 소유자의 이름을 입력해 주세요.");
				System.out.print(">>> ");
				String owner = in.next();
				System.out.println("초기 입금액을 입력해 주세요.");
				System.out.print(">>> ");
				int balance = in.nextInt();
				accountArr[i] = new Account(ano,owner,balance);
				System.out.printf("계좌번호 : %s 계좌주 : %s 계좌잔액 : %d\n",
						accountArr[i].getAno(),
						accountArr[i].getOwner(),
						accountArr[i].getBalance());
				System.out.println("계좌 생성이 완료되었습니다.");
				break;
			}
		}
		
	}
	
}
