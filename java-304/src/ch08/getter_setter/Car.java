package ch08.getter_setter;

public class Car { //인스턴스용 객체
	//필드(앞으로 무조건 private
	private int speed;
	private int max_speed;
	
	
	
	//생성자 -> 기본생성자, 자동 생성
	
	
	//메서드 (값을 입력받는 setter, 값을 출력하는 getter)

	public double getSpeed() {
		double km = speed*1.6;
		return km;
	}
	public void setSpeed(int speed) {
		if (speed < 0) {this.speed = 0;}
		else {this.speed = speed;}
	}
	public int getMax_speed() {
		return max_speed;
	}
	public void setMax_speed(int max_speed) {
		this.max_speed = max_speed;
	}
}
