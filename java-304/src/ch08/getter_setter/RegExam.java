package ch08.getter_setter;

import java.util.Date;

public class RegExam {
	public static void main(String[] args) {
		Reg reg = new Reg();
		Reg regAll = new Reg("남태욱", "TaeUk","123","zksktldl125@naver.com", "경기 수원시");
		reg.setName("이태훈");
		reg.setId("leeth");
		reg.setPass("1234");
		System.out.println(regAll.getName());
		System.out.println(reg.getName());
	}
}
