package collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArListTest {
	public static void main(String[] args) {
		ArrayList<Integer> dataList = new ArrayList<>();
		dataList.add(10);
		dataList.add(80);
		dataList.add(90);
		dataList.add(30);
		dataList.add(20);
		dataList.add(50);
		dataList.add(40);
		
		System.out.println(dataList.size());
//		for (int i = 0; i < dataList.size(); i++) {
//			System.out.println(dataList.get(i));
//		}
//		for(int data : dataList) {
//			System.out.println(data);
//		}
		//90을 900으로 수정
		int index = dataList.indexOf(90);
		if(index != -1) {
			System.out.println(dataList.set(index, 900));
			System.out.println(dataList);
		}else {
			System.out.println("찾는 값이 없습니다.");
		}
		//30 삭제
		index = dataList.indexOf(30);
		if(dataList.remove(new Integer(30))) {
			System.out.println("삭제 성공");
			System.out.println(dataList);
		}
//		if(index != -1) {
//			System.out.println(dataList.remove);
//		}
		
		Collections.shuffle(dataList);
		
		System.out.println("===섞은 후===");
		System.out.println(dataList);
		
		System.out.println("===정렬===");
		Collections.sort(dataList);
		System.out.println(dataList);
		
		System.out.println("===좌우 반전===");
		Collections.reverse(dataList);
		System.out.println(dataList);
		
		//50 뒤에 있는 정수 출력
		index = dataList.indexOf(50);
		if(index != -1) {
			if(index+1 != dataList.size()) {
				System.out.println(dataList.get(index + 1));
			}
		}
	}
}






