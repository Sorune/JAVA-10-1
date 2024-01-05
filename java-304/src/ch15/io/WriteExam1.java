package ch15.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam1 {
	public static void main(String[] args) throws Exception {
		//write 저장
		OutputStream os = new FileOutputStream("D:/temp/text2.txt");
		byte[] data = "가나다".getBytes();
		for (byte b : data) {
			os.write(b);
		}
		os.flush();//찌꺼기 버퍼 비우기
		os.close();//전송 완료 후 파일 닫기)
	}
}
