package ch15.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Paths;

public class ReadExam1 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("D:/temp/test.txt");
		
		//InputStream은 byte를 이용하여 데이터를 자바로 입력받는다.
		//read(); 메서드는 int(32bit)타입의 byte(8bit)객체로 읽어 옴
		//read()메서드는 int 타입의 1바이트씩 읽고 결과를 출력
		InputStream is = new FileInputStream("D:/temp/test.txt");
		int readByte;
		while(true) {
			readByte = is.read();
			if (readByte == -1) break;
			else {
				System.out.print((char)readByte);
//				System.out.println("\t"+(char)readByte);
			}
			
		}
		is.close();
	}
}
