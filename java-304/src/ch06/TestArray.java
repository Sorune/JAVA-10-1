package ch06;

public class TestArray {
	public static void main(String[] args) {
		String[][] test = new String[10][2];
		
		test[0] = new String[] {"1","2"};
		int count = 0;
		for (int i = 0 ; i < test.length ; i ++) {
			System.out.println(test[i]);
			if (test[i][0]==null||test[i][0].isEmpty()) {
				count++;
			}
		}
		int[][] test2 = new int[20][3];
		System.out.println(test2);
		
		System.out.println(test.length);
		System.out.println(count);
	}
}
