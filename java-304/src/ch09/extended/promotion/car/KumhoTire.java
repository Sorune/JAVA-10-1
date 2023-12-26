package ch09.extended.promotion.car;

import java.sql.Date;

public class KumhoTire extends Tire{
	public String name = "Snow Tire";
	public int Rim;
	public Date CreateDate;
	
	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean roll() {
		++this.accRotation;
		if (this.accRotation < this.maxRotation) {
			System.out.println(location +"금호 타이어수명 : "+(maxRotation-accRotation) + " 마일리지가 남았습니다.");
			return true;
		} else {
			System.out.println("Warnning! "+location +"금호 타이어 펑크.");
			return false;
		}
	}
	
	public boolean maxSpeed() {
		System.out.println("타이어 최고 속도 초과 경고!!!!");
		
		return true;
	}
	
}
