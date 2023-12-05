package ch05;

public class SwitchNoBreakExam {
	public static void main(String[] args) {
		int num = (int)(Math.random()*6)+6;
		System.out.println("현재시간은 : "+num + "시");
		switch(num) {
		case 6:
			System.out.println("세수를 하고 조깅을 하고 아침을 먹습니다.");
		case 7:
			System.out.println("출근 준비를 합니다.");
		case 8:
			System.out.println("버스를 타고 출근을 합니다.");
		case 9:
			System.out.println("수업 준비를 합니다.");
		case 10:
			System.out.println("결석자에게 전화를 합니다.");
		default :
			System.out.println("자바를 열심히 가르칩니다.");
		}
	}
}
