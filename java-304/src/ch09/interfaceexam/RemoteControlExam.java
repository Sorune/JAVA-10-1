package ch09.interfaceexam;

import java.util.Scanner;

public class RemoteControlExam {
	public static void main(String[] args) {
		//인터페이스 구현체의 실행 실습
//		RemoteControl rc = new RemoteControl();
		RemoteControl rc1 = new Television();
		RemoteControl rc2 = new Audio();
		Television tv = new Television();
//		Television tv1 = new Audio();
		Audio av = new Audio();
		
		rc1.turnOn();
		rc1.turnOff();
		rc1.setMute(true);
		rc1.setMute(false);
		rc1.setVolume(5);
		rc2.setVolume(6);
		tv.turnOn();
		tv.turnOff();
		tv.setMute(true);
		tv.setMute(false);
		tv.setVolume(8);
		
		System.out.println("==============다형성==============");
		Scanner in = new Scanner(System.in);
		System.out.println("=================================");
		System.out.println("1. TV 2. 오디오");
		System.out.print(">>> ");
		int select = in.nextInt();
		if (select == 1) {
			rc1 = new Television();
		} else if(select ==2) {
			rc1 = new Audio();
		}
		rc1.turnOn();
		rc1.setVolume(15);
		rc1.setVolume(-15);
		rc1.setVolume(5);
	}
	
}
