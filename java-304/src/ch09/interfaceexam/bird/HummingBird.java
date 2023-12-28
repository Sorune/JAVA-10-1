package ch09.interfaceexam.bird;

public class HummingBird implements Bird{

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("위로 올라갑니다.");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("아래로 내려갑니다.");
	}

	@Override
	public void hobbering() {
		// TODO Auto-generated method stub
		System.out.println("떠 있습니다.");
	}

	@Override
	public void floating() {
		// TODO Auto-generated method stub
		System.out.println("물 위에 떠다닙니다.");
	}

	@Override
	public void front() {
		// TODO Auto-generated method stub
		System.out.println("앞으로 헤엄칩니다.");
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		System.out.println("뒤로 헤엄칩니다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("먹이를 먹습니다.");
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("부우우웅-");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("잠을 잡니다.");
	}

}
