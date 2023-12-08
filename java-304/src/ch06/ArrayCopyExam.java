package ch06;

public class ArrayCopyExam {
	public static void main(String[] args) {
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		String[] newStrArray = new String[6];
		System.arraycopy(strArray, 0, newStrArray, 0, strArray.length);
		
		System.out.println("strArray0번과 1번의 동등비교 : " +( strArray[0]==strArray[1]));
		System.out.println("strArray1번과 2번의 동등비교 : " +( strArray[1]==strArray[2]));
		System.out.println("strArray0번과 2번의 내용비교 : " +( strArray[0].equals(strArray[1])));
		for(int i = 0 ; i < newStrArray.length;i++) {
			System.out.println(newStrArray[i]);
		}
		
	}
	
}
