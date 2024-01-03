package ch12.threadtest.beep;

import java.awt.Toolkit;

public class BeepTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Toolkit tk = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i < 10 ; i ++) {
			tk.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
