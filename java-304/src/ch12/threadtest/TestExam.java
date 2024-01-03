package ch12.threadtest;

public class TestExam {
	public static void main(String[] args) {
		Runnable tk = new Task();
		
		Thread th = new Thread(tk);
		// 작업 스레드 생성
		
		
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		th1.start();
		th1.stop();
		th1.suspend();
		
	}
}
