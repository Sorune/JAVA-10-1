package ch06;

public class Test01 {
	public static void main(String[] args) {
		 String[] name = {"남태욱","이서준"};
		 int[][] score = {{0,1},{70,80},{80,90},{100,100}};
		 
		 for (int i = 1 ; i < score.length ; i ++) {
			 for ( int j = 0; j < score[i].length ; j ++) {
				 if ( score[i][j] == 80) {
					 System.out.println(name[j]+"의 점수는 "+score[i][j]+"점 입니다");
				 }
			 }
		 }
	}
}
