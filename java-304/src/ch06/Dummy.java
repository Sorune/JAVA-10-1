package ch06;


final class CusInfo {
	String name;
	String phone;
	String date;
	String pass;
}

final class ResInfo {

	public int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
	public CusInfo[][] reserve = new CusInfo[12][];
	//예약 날짜 정보를 담을 배열
	public int[][] calander = new int[12][];
	//예약자 정보를 담을 배열
	public String[][] whoIs;
	// 0 : 이름 1 : 연락처 2 : 예약 날짜 정보 4 : 예약 호실 정보 5 : 확인용 비밀번호 
}

public class Dummy {
	public static void main(String[] args) {

//		String t = in.next();
//		t += "/" + in.next();
//		System.out.println(t);
		
		String test3 = "남태욱/010-1234-5678/12-24,12-26/701/1234";
		String[] test4 = test3.split("/");
		for (int i = 0 ; i < test4.length ; i ++) {
			System.out.println(test4[i]);
		}
		double test = 1.701702703;
		String tmp = Double.toString(test);
		String[] test1 = tmp.split("\\.");
		for (int i = 0 ; i < test1.length ; i ++) {
			System.out.println(test1[i]);
		}		
		
		int count = 100,roomNum = 1;;
		for (int i = 0 ; i < 30 ; i++) {
			roomNum ++;
			System.out.printf("[ %02d. %02d ]",i+1,roomNum+count);
			if ((i+1)%5 == 0) {
				System.out.println();
				count+=100;
				roomNum = 1;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		roomNum = 1;
		count = 41;
		for (int i = 700 ; i > 100 ; i -=100) {
			for (int j = 1 ; j < 8 ;j++) {

				if (i == 200 && j >5) break;
			count -= 1;
			int floorcount = i;
			if (i <= 400) { floorcount -= 100; }  
			System.out.printf("[ %02d. %03d]",count,floorcount+j);
			}
			System.out.println();
			
		}
	}
}
