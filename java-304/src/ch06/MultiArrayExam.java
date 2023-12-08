package ch06;

public class MultiArrayExam {
	public static void main(String[] args) {
		//다차원 배열(2차원)은 행열구조로 되어있는 표
		// in[][] scores = new int[][];
		// 앞에 있는 대괄호는 행, 뒤에 있는 대괄호는 열로 삽입
		int[][] scores = new int [2][3];//2*3행렬
		
		
		System.out.println("행의 개수 : "+scores.length);
		System.out.println("0열의 개수 : "+scores[0].length);
		System.out.println("1열의 개수 : "+scores[1].length);
		
		int[][] scores1 = new int [2][];
		scores1[0] = new int [2];
		scores1[1] = new int [3];
		System.out.println("행의 개수 : "+scores1.length);
		System.out.println("0열의 개수 : "+scores1[0].length);
		System.out.println("1열의 개수 : "+scores1[1].length);
	}
}
