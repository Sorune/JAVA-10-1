package ch06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dummy2 {
	public static void main(String[] args) throws ParseException {
        String date1 = "12/25"; //날짜1
        String date2 = "12/02"; //날짜2
       
        Date format1 = new SimpleDateFormat("MM/dd").parse(date1);
        Date format2 = new SimpleDateFormat("MM/dd").parse(date2);
        
        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24*60*60);
        
        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");
        
        

		String[][] rooms = new String[6][];
		for (int i = 0 ; i < rooms.length ; i ++) {
			int count = 8;
			if (i==0) count = 5;
			rooms[i] = new String[count];
		}
		String n = "========================================";
        System.out.println(n);
        System.out.println(n.length());
		for (int i = rooms.length ; i > 0 ; i --) {
			for (int j = 0 ; j<rooms[i-1].length;j++) {
				if (rooms[i-1][j]==null||rooms[i-1][j].equals("0")||rooms[i-1][j].isBlank()||rooms[i-1][j].isEmpty()||rooms[i-1][j].equals("null")) {
					System.out.printf("[%03d]",(i*100)+(j+1));
				} else {
					System.out.printf("[ x ]");
				}
			}
			System.out.println();
		}
	}
}
