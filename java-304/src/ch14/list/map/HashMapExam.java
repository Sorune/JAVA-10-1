package ch14.list.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExam {
	public static void main(String[] args) {
		// Map 인터페이스는 k,v의 쌍으로 구현된다.
		// key는 중복 안됨, v는 중복 가능
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("김기원", 100);
		map.put("이태훈", 99);
		map.put("이서준", 50);
		map.put("손희신", 80);
		map.put("이태훈", 100);
		
		System.out.println(map.size());
		System.out.println("---------------------------");
		Set<String> keyset = map.keySet();
		Iterator<String> keys = keyset.iterator();
		while(keys.hasNext()) {
			String tmp = keys.next();
			System.out.println(tmp + " : "+map.get(tmp));
		}
		
		map.remove("김기원");
		
		System.out.println("-----------------------------");
		Set<Map.Entry<String, Integer>> etset = map.entrySet();
		Iterator<Map.Entry<String, Integer>> etIt = etset.iterator();
		while(etIt.hasNext()) {
			Map.Entry<String, Integer> entry = etIt.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println(key + " : "+value);
		}
		
	}
}
