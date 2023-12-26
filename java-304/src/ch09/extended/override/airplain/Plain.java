package ch09.extended.override.airplain;

public class Plain {
	public static void main(String[] args) {
		SuperSonicAirplain sa = new SuperSonicAirplain();
		
		sa.takeoff();
		
		sa.fly();
		
		sa.mode = SuperSonicAirplain.SUPERSONIC;
		
		sa.fly();
		
		sa.mode = SuperSonicAirplain.NORMAL;
		
		sa.fly();
		
		sa.land();
	}
}
