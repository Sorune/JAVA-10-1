package ch09.interfaceexam;

public class SmartTv extends Television implements RemoteControl, Searchable{

	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.printf("%s 검색을 시작합니다.\n",url);
	}

}
