package ch08.bank;

public class Account {
	private String ano;
	private String owner;
	private int balance;
	
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance, int selectNum) {
		switch (selectNum) {
		case 3:
			this.balance += balance;	
			break;
		case 4:
			if (this.balance - balance > 0) this.balance -= balance;
			else System.out.println("잔액이 부족합니다.");
			break;
		}
		
	}
	
	
}
