package ch09.interfaceexam;

public class AnnonymousExam {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("전원을 켭니다.");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("전원을 끕니다.");
			}
			
			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				System.out.println("볼륨 설정 : "+volume);
			}
		};
		
		rc.turnOn();
		rc.turnOff();
		rc.setMute(true);
		rc.setVolume(8);
	}
}
