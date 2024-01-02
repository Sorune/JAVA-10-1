package ch10.trycatch;

public class TryWithExam {
	public static void main(String[] args) {
		try (FileInputStExam file = new FileInputStExam("Hello.txt")) {
			file.read(); //메서드 호출
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
