package ch02;

public class CharExam {

	public static void main(String[] args) {
		//char unicode 매핑 테스트
		// char타입은 음수 없다. 0~65535범위 매핑테이플 사용
		char c1 = 75;
		char c2 = 105;
		char c3 = 109;
		System.out.print(c1);
		System.out.print(c2);
		System.out.println(c3);
		
		char han1 = '가';
		char han2 = 44032;
		char han3 = '\uac00';
		System.out.println(han1);
		System.out.println(han2);
		System.out.println(han3);
		
		int uniCode1 = '남';
		int uniCode2 = '태';
		int uniCode3 = '욱';
		System.out.println(uniCode1);
		System.out.println(uniCode2);
		System.out.println(uniCode3);
		System.out.println(Integer.toHexString(uniCode3).toUpperCase());
	}

}
