package ch06;

public class ArrayPrint2DExam {
	public static void main(String[] args) {
		String[] name = {"김기원", "남태욱", "홍길동"};
		String[] subject = {"국어","영어"};
		int[][] score = {{0,1,2},{75,85,95},{35,55,45}};
		
//		for (int i = 0 ; i < score.length;i++) {
//			System.out.println(score[2][i]);
//			System.out.println(name[i]);
//		}
//		
////		과목별 출력
//		for (int i = 0; i<subject.length;i++) {
//			for (int j = 0 ; j<score.length;j++) {
//		System.out.printf("%s 학생의 %s성적 : %d\n",name[j],subject[i],score[i+1][j]);
//			}
//		}
//		
//		//학생별 출력
//		for (int i = 0; i<score.length;i++) {
//			for (int j = 0 ; j<subject.length;j++) {
//				System.out.printf("%s 학생의 %s성적 : %d\n",name[i],subject[j],score[j+1][i]);
//			}
//		}
		int[]result = minMax(score,subject,0,1);

		System.out.println(name[result[0]]+" "+subject[1]+" "+result[1+1]);
		for (int i = 0 ; i < result.length ; i ++) {
			System.out.print(name[i]+" ");
			System.out.println(result[i]);
		}
		int[][] score2 = sort(score,0,1);
		
		
	}
	public static int[] minMax(int[][] arr,String[] subject, int x, int y) {
		int[] result = new int[arr.length];
		int temp = arr[y+1][0];
		for (int i = 0 ; i < result.length;i++) {
			result[i] = arr[i][0];
		}
		switch(x) {
		case 0:		
			for (int i = 0 ; i < arr.length ; i ++) {
				if(temp < arr[y+1][i]) {
					for (int j = 0 ; j < arr.length;j++)
						result[j] = arr[j][i];
				}
			}
			break;
		case 1:	
			for (int i = 0 ; i < arr.length ; i ++) {
				if(temp > arr[y+1][i]) {
					for (int j = 0 ; j < arr.length;j++)
						result[j] = arr[j][i];
				}
			}
			break;
		}
		
		return result;
	}

	public static int[][] sort(int[][] arr, int x, int y) {
		// 0 : 오름차순 / 1 : 내림차순
		int[] tempArr = new int[arr.length];
		switch(x) {
		case 0:
				for (int i = 0 ; i <arr.length-1;i++) {
					for (int j = 0; j<arr.length-1-i;j++) {
						if(arr[y+1][j]>arr[y+1][j+1]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[z][j+1];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j+1] = arr[z][j];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j] = tempArr[z];
								}
						}
					}
				}
				break;
			case 1:
				for (int i = 0 ; i <arr.length-1;i++) {
					for (int j = 0; j<arr.length-1-i;j++) {
						if(arr[y+1][j]<arr[y+1][j+1]) {
								for (int z = 0;z<tempArr.length;z++) {
									tempArr[z] = arr[z][j+1];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j+1] = arr[z][j];
								}
								for (int z = 0;z<tempArr.length;z++) {
									arr[z][j] = tempArr[z];
								}
						}
					}
				}
				break;
			}
		return arr;
	
	}
}
