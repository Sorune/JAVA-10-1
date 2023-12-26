package ch09.extended.override;

public class OverrideExam {
	public static void main(String[] args) {
		Calculator ca = new Calculator();
		Computer cu = new Computer();
		int r = 10;
		System.out.println(ca.areaCircle(r));
		System.out.println(cu.areaCircle(r));
	}
}
