package ch15.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadExam2 {
	public static void main(String[] args) throws Exception {
		//read(byte[3]); -> 3개씩 읽어오기
		
		InputStream is = new FileInputStream("D:/temp/test.txt");
		
		int readByte;
		byte[] readBytes = new byte[26];
		String data = "";
		while(true) {
			readByte = is.read(readBytes);
			if (readByte == -1) break;
			else {
				data += new String(readBytes,0,readByte);
				System.out.println(data);
			}
		}
		
	}
}
