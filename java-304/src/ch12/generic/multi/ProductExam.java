package ch12.generic.multi;

public class ProductExam {
	public static void main(String[] args) {
		Product<Tv, String> p1 = new Product<Tv, String>();
		Product<Car, String> c1 = new Product<Car, String>();
		
		p1.setKind(new Tv());
		p1.setModel("Samsung");
		
		c1.setKind(new Car());
		c1.setModel("Hyundai");
		
		Tv tv = p1.getKind();
		String tvModel = p1.getModel();
		System.out.println(tvModel);
		
		Car car = c1.getKind();
		String carModel = c1.getModel();
		System.out.println(carModel);
	}
}
