package ch07;

public class ComputerExam {
	public static void main(String[] args) {
		Computer com = new Computer();
		
		int[] values1 = new int[] {1,2,3};
		
		System.out.println(com.sum1(1,2,3,4,5,6,7,8,9,10));
		System.out.println(com.sum1(values1));
	}
}
