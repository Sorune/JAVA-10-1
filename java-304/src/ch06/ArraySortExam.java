package ch06;

public class ArraySortExam {
	public static void main(String[] args) {
		int[] scores = new int[] {79,88,91,33,100,55,95};
		
		System.out.print("입력값 확인 : ");
		for(int i = 0 ; i < scores.length;i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
		
		scores = sort(scores,0);
		
		System.out.print("출력값 확인 : ");
		for(int i = 0 ; i < scores.length;i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] sort(int[] arr, int x) {
		// 0 : 오름차순 / 1 : 내림차순
		switch(x) {
		case 0:
			for (int i = 0 ; i <arr.length-1;i++) {
				for (int j = 0; j<arr.length-1-i;j++) {
					if(arr[j]>arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			break;
		case 1:
			for (int i = 0 ; i <arr.length-1;i++) {
				for (int j = 0; j<arr.length-1-i;j++) {
					if(arr[j]<arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			break;
		}
		return arr;
	}
}
