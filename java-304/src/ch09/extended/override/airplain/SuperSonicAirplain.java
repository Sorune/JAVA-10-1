package ch09.extended.override.airplain;

public class SuperSonicAirplain extends Airplain{
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int mode = NORMAL;
	
	public void fly() {
		if (this.mode == NORMAL) {
			super.fly();
		} else if (this.mode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		}
	}
	
}
