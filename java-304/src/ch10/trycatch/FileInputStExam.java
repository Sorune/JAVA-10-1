package ch10.trycatch;

public class FileInputStExam implements AutoCloseable {
	//implements AutoCloseable 내장된 자동닫기 인터페이스 구현 객체
	//필드
	private String file;
	
	//생성자
	public FileInputStExam(String file) {
		this.file = file;
	}
	//메서드
	
	public void read() {
		System.out.println(file+"을 읽습니다.");
	}
	
	
	public static void main(String[] args) {
		
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(file +"을 닫습니다");
	}
}
