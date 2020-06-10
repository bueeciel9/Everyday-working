package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTask {
	public static void main(String[] args) {
		//상품명, 가격을 관리해주는 ArrayList 선언(2차원)
		ArrayList<ArrayList> products = new ArrayList<>();
		ArrayList product = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		//1.상품등록
		System.out.print("상품명 : ");
		product.add(sc.next());

		System.out.print("상품가격 : ");
		product.add(sc.nextInt());
		
		products.add(product);
		for(ArrayList prod : products) {
			System.out.println(prod);
		}
		//2.상품수정
		//3.상품검색
		//4.상품삭제
		//5.상품목록
		//6.나가기
	}
}
