package ch05;

public class BreakOutterExam {
	public static void main(String[] args) {
		for (char upper = 'A' ; upper <= 'Z'; upper++) {
			Outter : for (char lower = 'a' ; lower <= 'z' ; lower++) {
				System.out.printf("%s-%s\n",upper,lower);
				if (lower == 'c') {
					break Outter;
				}
			}
				
		}
	}
}
