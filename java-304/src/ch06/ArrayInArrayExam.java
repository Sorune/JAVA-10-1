package ch06;

public class ArrayInArrayExam {
	public static void main(String[] args) {
		// 행열구조의 입력은 행부터 열까지 입력
		
		int [][] mathScores = new int[][] {{60,70,80},{70,80,90}};
		// 출력하려면 행 반복, 열 반복을 진행
		
		for(int i = 0 ; i < mathScores.length ; i++) {
			for (int j = 0 ; j < mathScores[i].length ; j ++) {
				System.out.print(mathScores[i][j]+" ");
			} // 열반복 종료
			System.out.println();
			System.out.println("---------");
		}// 행반복 종료
		
		
		
	}
}
