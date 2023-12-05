package ch01;

public class RunStateExam {

	public static int add(int x, int y) {
		int result = x+y;
		return result;
	}
	
	public static void main(String[] args) {
		//x와 y값을 더해서 출력하는 프로그램
		
		int x = 1;
		int y = 2;
		int result = x+y;
		System.out.println("x+y="+result);
		System.out.println("x+y="+add(x,y));
	}
}
