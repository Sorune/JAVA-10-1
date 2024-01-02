package ch10.clientexception;

public class Account {
	//필드
	private long balance ; //잔액
	
	
	//생성자
	public Account() {
		
	}
	
	
	//메서드
	public long getBalance() {
		return balance;
	}//잔액 조회
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int money) throws BalanceException {
		if (balance - money < 0) {
			throw new BalanceException("잔고 부족 : " + (money-balance) +"원 부족합니다.");
		} else {
			this.balance -= money;
		}
	}
}
