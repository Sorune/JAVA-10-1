package ch12.threadtest.beep;

import java.awt.Toolkit;

public class BeepMainExam {
	public static void main(String[] args){
		// 스레드 없는 소리와 자막 연출하기
		BeepTask bk = new BeepTask();
		Thread th = new Thread(bk);
		th.start();

		
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("띠리링~");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
