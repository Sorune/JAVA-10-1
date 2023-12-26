package ch09.extended.promotion.car;

public class HankookTire extends Tire{
	// 필드 -> 부모 필드 + @
	public int maxSpeed;
	public int size;
	public int radius;
	public String name = "eco Tire";
	double accR;
	
	
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
		//부모 객체 생성자
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean roll() {
		this.accR += 0.5;
		this.accRotation = (int) accR;
		if (this.accRotation < this.maxRotation) {
			System.out.println(location +"한국 타이어수명 : "+(maxRotation-accRotation) + " 마일리지가 남았습니다.");
			return true;
		} else {
			System.out.println("Warnning! "+location +"한국 타이어 펑크.");
			return false;
		}
	}
	
	public int tpms() {
		int tpm = 45;
		// 공기압 측정용 시스템 적용
		
		return tpm;
	}
	
}
