package ch09.interfaceexam;

public class Television implements RemoteControl{
	private int volume;
	
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
	public void setMute(boolean mute) {
		// TODO Auto-generated method stub
		if (mute) {
			this.volume = 0;
			System.out.println("tv의 음량이 음소거 됩니다.");
			System.out.println("현재 tv의 볼륨 : "+this.volume);
		} else {
			System.out.println("tv의 음량이 음소거 취소됩니다.");
		}
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if (volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume <RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		
		System.out.println("현재 tv의 볼륨 : "+this.volume);
	}

}
