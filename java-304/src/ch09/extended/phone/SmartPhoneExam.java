package ch09.extended.phone;

public class SmartPhoneExam {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("사과폰", "스페이스 그레이","홍길동");
		
		sp.powerOn();
		
		sp.musicStart("Cookie");
		sp.musicStart("손오공");
		sp.musicStart("Beliver");
		sp.randomMusicStart();
		sp.randomMusicStart();
		sp.randomMusicStart();
		
		sp.setAdress("남태욱");
		sp.setAdress("김기원");
		
		sp.recieveMessgae("홍길순","학원 안가냐");
		sp.sendMessage();
		
	}
}
