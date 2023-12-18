package ch07;

public class Calculator {
	//계산기 객체용
	//필드
	
	
	
	//생성자
	
	
	//메서드
	void powerOn() {
		System.out.println("계산기의 전원을 켭니다.");
	}
	void powerOff() {
		System.out.println("계산기의 전원을 끕니다.");
	}
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	double add(double num1, double num2) {
		return num1+num2;
	}
	int add(int ... values) {
		int result =0;
		for (int i : values) {
			result+=i;
		}
		return result;
	}
	double add(double ... values) {
		double result =0;
		for (double i : values) {
			result+=i;
		}
		return result;
	}
	int min(int num1, int num2) {
		return num1-num2;
	}
	double min(double num1, double num2) {
		return num1-num2;
	}
	int mul(int num1, int num2) {
		return num1*num2;
	}
	double mul(double num1, double num2){
		return num1*num2;
	}
	double div(int num1, int num2) {
		return num1/num2;
	}
	double div(double num1,double num2) {
		return num1/num2;
	}
	int remain(int num1, int num2) {
		return num1%num2;
	}
	int remain(double num1, double num2) {
		return (int) (num1%num2);
	}
}
