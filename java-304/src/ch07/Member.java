package ch07;

public class Member {
	public String name;
	public int age;
	public String id;
	public String pass;
	public String phone;
	public String adress;
	
	public Member() {
		
	}
	
	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	public void checkAge() {
		if (age >= 20) {
			System.out.println("성인입니다.");
		}
		else {
			System.out.println("성인이 아닙니다.");
		}
	}
	
}
