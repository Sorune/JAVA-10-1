import java.io.UnsupportedEncodingException;

public class Hello {
	public static void main (String[] args) throws UnsupportedEncodingException {
		String korean = "자바지옥에 오신걸 환영합니다.";
		byte[] bytes = korean.getBytes("UTF-16");
		String string = new String(bytes);		
		System.out.println(string);		
	};
};