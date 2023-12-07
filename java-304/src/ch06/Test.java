package ch06;

public class Test {
	public static void main(String[] args) {
		int [][] test1 = {{1,2,3},{2,3,4},{4,5,6}};
		int [][] test2 = {{1,2},{3,4},{5,6},{7,8}};
		
		System.out.println(test1[1][1]);
		System.out.println(test2[1][1]);
		System.out.println(test1.length);
		System.out.println(test1[1].length);
		System.out.println(test2[1].length);
		//2차원 배열의 길이는 가장 바깥 배열의 길이를 리턴
		// test1 = 3, test2 = 4
		
	}
}
