package ch14.list.map.properties;

import java.io.File;
import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExam {
	public static void main(String[] args) throws Exception {
		// 프로퍼티로 만든 텍스트를 k,v형식으로 붏러오는 기법
		Properties p = new Properties();
		String path = PropertiesExam.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path,"utf-8");
		p.load(new FileReader(path));
		
		
		
		String driver = p.getProperty("driver");
		System.out.println(driver);
		String url = p.getProperty("url");
		System.out.println(url);
		String id = p.getProperty("username");
		System.out.println(id);
		String pw = p.getProperty("password");
		System.out.println(pw);
				
		
	}
}
