package ch09.extended.promotion.car;

public class Tire {
	//필드
	public int maxRotation; // 최대 회전수
	public int accRotation;
	public String location;
	
	
	//생성자
	public Tire (String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메서드
	public boolean roll() {//주행중 마일리지 감소용
		++this.accRotation;
		if (this.accRotation < this.maxRotation) {
			System.out.println(location +"부모 타이어수명 : "+(maxRotation-accRotation) + " 마일리지가 남았습니다.");
			return true;
		} else {
			System.out.println("Warnning! "+location +"부모 타이어 펑크.");
			return false;
		}
	}
	
}
