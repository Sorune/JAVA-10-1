package ch14.functinalinterface;

public class MyFunctionExam {
	public static void main(String[] args) {
		MyFunction fi;
		fi= () -> {
			System.out.println("람다식 실행");
		};
		
		fi.method1();
	}
	
}
