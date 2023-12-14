package ch07;

public class CircleExam {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.name = "원";
		circle.radius = 20;
		System.out.println(circle.getArea());
	}
}
