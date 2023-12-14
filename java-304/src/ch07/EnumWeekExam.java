package ch07;

import java.util.Calendar;

import ch07.Week;

public class EnumWeekExam {
	public static void main(String[] args) {
		/*
		Week today = Week.WEDNESDAY;
		
		System.out.println(today == Week.WEDNESDAY);
		
		Week week1 = Week.SUNDAY;
		Week week2 = Week.SUNDAY;
		
		System.out.println(week1 == week2);
		*/
		
		Week today = null;
		
		Calendar cal = Calendar.getInstance();// 달력 객체 생성 
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		int month =  cal.get(Calendar.MONTH)+1;
		System.out.println(month);
		int day = cal.get(Calendar.DATE);
		System.out.println(day);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		int monWeekDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println(weekDay);
		System.out.println(monWeekDay);
		
		switch(weekDay) {
		case 1:
			today = Week.SUNDAY;
			System.out.println(today);
			break;
		case 2:
			today = Week.MONDAY;
			System.out.println(today);
			break;
		case 3:
			today = Week.TUESDAY;
			System.out.println(today);
			break;
		case 4:
			today = Week.WEDNESDAY;
			System.out.println(today);
			break;
		case 5:
			today = Week.THIRSDAY;
			System.out.println(today);
			break;
		case 6:
			today = Week.FRIDAY;
			System.out.println(today);
			break;
		case 7:
			today = Week.SATURDAY;
			System.out.println(today);
			break;
			
		}
	}
}
