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
		
		//�����̸�
//		BufferedWriter bw = new BufferedWriter(
//				new FileWriter("animals.txt", true));
		Scanner sc = new Scanner(System.in);
		//�߰�
//		System.out.print("�߰��Ͻ� �����̸� : ");
//		bw.write(sc.next() + "\n");
//		bw.close();
		
		
		//����
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.print("�����Ͻ� �����̸� : ");
//		name = sc.next();
//		
//		while(true) {
//			line = br.readLine();
//			if(line == null) {break;}
//			
//			if(line.equals(name)) {
//				System.out.print("���ο� �����̸� : ");
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
//			System.out.println("���� ����");
//		}else {
//			System.out.println("���� ����");
//		}
		//����
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		System.out.print("�����Ͻ� �����̸� : ");
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
//			System.out.println("���� ����");
//		}else {
//			System.out.println("���� ����");
//		}
		//�˻�
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		ArrayList<String> resultList = new ArrayList<>();
//		
//		System.out.print("�˻��Ͻ� �����̸� : ");
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
//			System.out.println("�˻� ��� ����");
//		}else {
//			System.out.println("�˻� ���");
//			for(String data : resultList) {
//				System.out.println(data);
//			}
//		}
		//���
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






