package ch09.extended.abstractexam;

public class SmartPhone extends Phone {//실체 클래스
	//조원이 추가로 만듦
	
	public SmartPhone(String owner) {
		super(owner);
		//부모(추상)클래스에서 강제로 만들어 놓은 생성자
	}
	
	
	public void internetSearch() {
		System.out.println("인터넷 검색 시작.");
	}
}
