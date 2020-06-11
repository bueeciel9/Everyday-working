package day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> fruitMap = new HashMap<>();
		ArrayList<Integer> prices = new ArrayList<>();
		
		fruitMap.put("사과", 1500);
		fruitMap.put("배", 2000);
		fruitMap.put("자두", 500);
		fruitMap.put("수박", 8000);
		
		System.out.println(fruitMap);
		fruitMap.put("자두", 1000);
		System.out.println(fruitMap.get("자두"));
		System.out.println(fruitMap.containsKey("자두"));
		
		Set<String> set = fruitMap.keySet();
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		for(int data : fruitMap.values()) {
//			System.out.println(data + "원");
//		}
		
		//Collection타입에서는 forEach()메소드를 제공해준다.
		//forEach(변수명 -> 실행할 문장);
		//실행할 문장에서 화살표 뒤에 있는 변수를 사용할 수 있다.
		//값이 더 이상 없을 때까지 반복한다.
		fruitMap.values().forEach(price -> prices.add(price));
		System.out.println(prices);
		
		//Key, Value 한 쌍이 필요할 때에는 keySet(), values() 2개를 사용하지 않고
		//entrySet()을 사용하여 한 번에 다 가지고 올 수 있다.
		Iterator<Entry<String, Integer>> iter_entry = fruitMap.entrySet().iterator();
		
		while(iter_entry.hasNext()) {
			//안에 있는 객체가 Entry<String, Integer>타입이므로
			//해당 객체에 넣어주고 사용한다.
			Entry<String, Integer> entry = iter_entry.next();
			System.out.println(entry.getKey() + "-" + entry.getValue() + "원");
		}
	}
}






