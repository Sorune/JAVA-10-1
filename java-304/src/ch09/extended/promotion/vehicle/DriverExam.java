package ch09.extended.promotion.vehicle;

public class DriverExam {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Bus();
		Vehicle v3 = new Texi();
		
		driver.drive(v1);
		driver.drive(v2);
		driver.drive(v3);
	}
}
