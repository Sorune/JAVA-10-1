package ch06;

public class MainStringArgusExam {
	public static void main(String[] args) {
		//String[] args 는 cmd에서 MainStringArgsExam.java를 실행할 때 값을 받을 수 있는 매개값
		// 문자열의 배열타입으로 값을 받아 저장한다. args[0] , args[1]...
		//cmd에서 javac로 컴파일 후에 MainStringArgsExam 10 20을 입력하면
		// args[0] = 10 , args[1] = 20;
		// 이클립스는 Run Configurations에 Arguments에 값을 넣으면 위와 같다.
		
		if(args.length != 2) {//args값이 2개가 아니면 --> 사용법을 출력
			System.out.println("프로그램 사용법");
			System.out.println("java MainStringArgusExam num1 num2");
			System.exit(0);
		}
		
		String str1 = args[0];
		String str2 = args[1];
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		int result = num1 + num2;
		
		System.out.println(num1 + "+" + num2 +"="+result );
		
		
	}
}
