package ch08.getter_setter;

import java.util.Date;

public class Reg {
	//회원 등록용 객체
	//필드
	private String name;
	private String id;
	private String pass;
	private String eMail;
	private String adress;
	private int age;
	private Date birth;
	private boolean getMarry;
	
	
	//생성자
	public Reg() {}
	
	public Reg(String name, String id, String pass, String eMail, String adress) {
		super();
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.eMail = eMail;
		this.adress = adress;
	}
	
	
	//메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean isGetMarry() {
		return getMarry;
	}
	public void setGetMarry(boolean getMarry) {
		this.getMarry = getMarry;
	}
	
}
