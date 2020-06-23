package execute;

import java.util.Scanner;

public class Just {
public static void main(String[] args) {
	
	// 5개의 정수를 입력받고 최대값과 최소값 출력하기
	
	int[] a = new int[5];
	int input =0;
	
	Scanner sc = new Scanner(System.in);
	
	for(int i = 0; i<a.length;i++) {
		a[i] = sc.nextInt();
	}
	int max =0;
	int min =0;
	for(int i =1;i<5;i++){
		max = a[i-1]<a[i]?a[i]:a[i-1];
		min = a[i-1]>a[i]?a[i]:a[i-1];
		
	}
	System.out.println(max);
	System.out.println(min);
}
}
