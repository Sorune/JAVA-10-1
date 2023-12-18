package ch07;

public class Car {
	//필드 -> 값을 보관하는 멤버변수
	// ------고유 데이터-------
	String company = "Ford";
	String model = "Mustang";
	String color = "Black";	
	int maxSpeed = 320;
	
	//-----------상태-----------
	int speed;
	int rpm;
	boolean stop;
	int drivenDistance;
	boolean handbreak;
	Gear gear;
	
	//-----------부품------------
	Tire tire;
	Engine engine;
	Body body;
	
	
	//생성자 -> 객체 생성할 때 매개값을 관리하는 메서드(new 연산자용)
	
	Car(){//기본 생성자, 생략가능(이클립스 기능)
		this.speed = 0;
		this.rpm = 600;
		this.stop = false;
		this.gear = Gear.Parking;
		this.handbreak = true;
	}
	
	Car(String company, String model, String color){
		this.company =company;
		this.model = model;
		this.color = color;
		this.speed = 0;
		this.rpm = 600;
		this.stop = false;
		this.gear = Gear.Parking;
		this.handbreak = true;
	}
	
	
	//메서드 -> 동작, 처리를 담당하는 부분
	void start() {
		this.handbreak = false;
		this.gear = Gear.Drive;
		this.speed = 0;
		this.rpm = 800;
		this.stop = true;
	}
	
	void addSpeed() {
		if (speed <= maxSpeed) {
		speed += 10;
		rpm += 100;
		stop = true;
		}
		else {
			System.out.println("더 이상 속도를 올릴 수 없습니다.");
		}
	}
	
	void minSpeed() {
		if ( speed >= 0) {
		speed-=10;
		rpm-=100;
		stop = false;
		} else {
			System.out.println("차량이 정지하였습니다.");
		}
		
	}
	
	void stop() {
		this.handbreak = true;
		this.gear = Gear.Parking;
		speed = 0;
		rpm = 600;
		stop = false;
	}
}//Car 클래스 종료

class Tire { //Car.java에 이너클래스로 public 선언시 오류
	//필드
	//생성자
	//메서드
	
}
