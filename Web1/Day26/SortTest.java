package sorting;

import java.io.IOException;

public class SortTest {

	public static void main(String[] args) throws IOException {

		System.out.println("정렬 방식을 선택하세요");
		System.out.println("B : BubbleSort");
		System.out.println("Q : QuickSort");
		System.out.println("H : HeapSort");
		
	int ch = System.in.read();	
	Sort sort = null;
	
	if(ch == 'B' || ch =='b') {
		sort = new BubbleSort();
	}
	else if(ch == 'H' || ch =='h') {
		sort = new HeapSort();
	}
	else if(ch == 'Q' || ch =='q') {
		sort = new QuickSort();
	}
	else {
		System.out.println("지원되지 않는 기능입니다.");
		return;
	}
	int[] arr = new int[0]; 		//왜 배열로 했는지 이해가 안되넴. 배열안에 들어가는 숫자는 0,1,10 다 상관없던데 왜 그렇냐..?
	sort.ascending(arr);
	sort.descending(arr);
	sort.description();
	
			
	}
}
