package ch09.extended.abstractexam;

public class PhoneExam {
	public static void main(String[] args) {
//		Phone ph = new PHone("김기원");
		SmartPhone sh = new SmartPhone("김기원");
		
		sh.turnOn();
		sh.internetSearch();
		sh.turnOff();
	}
}
