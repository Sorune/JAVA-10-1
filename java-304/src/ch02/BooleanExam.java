package ch02;

public class BooleanExam {

	public static void main(String[] args) {
		//boolean은 true나 false의 값만 갖는 타입
		// true 는 참 / false는 거짓
		// 조건문에 해당하는 분기를 담당한다.
		
		boolean stop = true ;
		boolean start = false ;
		
		if(stop){
			System.out.println("차를 멈춥니다.");
		} else {
			System.out.println("차가 달립니다.");
		}
		
		System.out.println(stop);
		System.out.println(start);
	}

}
