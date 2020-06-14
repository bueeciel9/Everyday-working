package day23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTest2 {
	public static void main(String[] args) throws IOException{
		String fileName = "animals.txt";
		String name = null;
		String line = null;
		String temp = "";
		boolean check = false;
		
		//동물이름
//		BufferedWriter bw = new BufferedWriter(
//				new FileWriter("animals.txt", true));
		Scanner sc = new Scanner(System.in);
		//추가
//		System.out.print("추가하실 동물이름 : ");
//		bw.write(sc.next() + "\n");
//		bw.close();
		
		
		//수정
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.print("수정하실 동물이름 : ");
//		name = sc.next();
//		
//		while(true) {
//			line = br.readLine();
//			if(line == null) {break;}
//			
//			if(line.equals(name)) {
//				System.out.print("새로운 동물이름 : ");
//				name = sc.next();
//				temp += name + "\n";
//				check = true;
//				continue;
//			}
//			temp += line + "\n";
//		}
//		br.close();
//		
//		if(check) {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//			bw.write(temp);
//			bw.close();
//			System.out.println("수정 성공");
//		}else {
//			System.out.println("수정 실패");
//		}
		//삭제
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.print("삭제하실 동물이름 : ");
//		name = sc.next();
//		
//		while(true) {
//			line = br.readLine();
//			if(line == null) {break;}
//			
//			if(line.equals(name)) {
//				check = true;
//				continue;
//			}
//			temp += line + "\n";
//		}
//		br.close();
//		
//		if(check) {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//			bw.write(temp);
//			bw.close();
//			System.out.println("삭제 성공");
//		}else {
//			System.out.println("삭제 실패");
//		}
		//검색
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		ArrayList<String> resultList = new ArrayList<>();
//		
//		System.out.print("검색하실 동물이름 : ");
//		name = sc.next();
//		line = null;
//		while(true) {
//			line = br.readLine();
//			
//			if(line == null) {break;}
//			
//			if(line.contains(name)) {
//				resultList.add(line);
//			}
//		}
//		if(resultList.size() == 0) {
//			System.out.println("검색 결과 없음");
//		}else {
//			System.out.println("검색 결과");
//			for(String data : resultList) {
//				System.out.println(data);
//			}
//		}
		//목록
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		line = null;
		while(true) {
			line = br.readLine();
			
			if(line == null) {break;}
			
			System.out.println(line);
		}
		br.close();
	}
}






