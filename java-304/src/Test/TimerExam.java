package Test;

import java.util.*;

public class TimerExam {
	public static void main(String[] args) throws InterruptedException {
		Date date = new Date();
		long now = date.getTime(), time = date.getTime(),temp = 0;
		Scanner in = new Scanner(System.in);
		
		int apply = 0, setTime = 0, count = 0;
		String keepGoing = "y";
		
		System.out.println("---------------------------------------------");
		System.out.println("타이머를 실행합니다");
		while (keepGoing.equals("y")) {
			long remain = Math.floorDiv((now - time),1000);
			System.out.println("원하시는 기능을 선택해 주세요");
			System.out.println("---------------------------------------------");
			System.out.println("1. 분 타이머 \t 2. 초 타이머 \t 3. 종료");
			System.out.println("---------------------------------------------");
			System.out.print(">>>");
			apply = in.nextInt();
			if (apply == 3) {break;}
			System.out.println("---------------------------------------------");
			System.out.println("표시 방식을 선택해 주세요");			
			System.out.println("---------------------------------------------");
			System.out.println("1. MM:SS \t 2. S \t 3. 종료");
			System.out.print(">>>");
			setTime = in.nextInt();
			System.out.println("---------------------------------------------");
			System.out.println("시간을 설정해주세요");
			System.out.println("---------------------------------------------");
			System.out.print(">>> ");
			count = in.nextInt();
			
			System.out.println("시작합니다!");
			System.out.println("3!");
			temp = 0;
			time = System.currentTimeMillis();
			do {
				now = System.currentTimeMillis();
				remain = Math.floorDiv((now - time),1000);
				if (remain != temp) {
					System.out.printf("%d! \n",3 - remain);
					temp = remain;
				}
				Thread.sleep(100);
			} while(((3 - remain) > 0));
			temp = 0;
			
			if (apply == 1) {count = count * 60;}
			

			time = System.currentTimeMillis();
			do {
				now = System.currentTimeMillis();
				remain = Math.floorDiv((now - time),1000);
				if (setTime == 1) {
					if (remain != temp) {
						System.out.printf("시간이 %02d:%02d 남았습니다.\n",Math.floorDiv(count-remain,60),(count-remain)%60);
						temp = remain;
					}
				} else if(setTime == 2) {
					if (remain != temp) {
						System.out.printf("시간이 %d초 남았습니다.\n",count-remain);
						temp = remain;
					}
				}
				Thread.sleep(100);
			} while((count - remain) > 0);

			temp = 0;
			
			System.out.println("시간이 다 되었습니다. 계속하시겠습니까?");
			System.out.print("계속하시려면 y를 눌러주세요 : ");
			keepGoing = in.next();
		}
		System.out.println("타이머를 종료합니다");
	}
}

