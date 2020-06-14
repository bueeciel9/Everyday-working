package day23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest {
	// throws �����̸�
	// �ش� �޼ҵ忡�� �߻��ϴ� Ư�� ���ܸ�
	// �߻���Ű�� �ʱ� ���� ����Ѵ�.
	public static void main(String[] args) throws IOException {
		// 1. ������ �ִ� ���뿡 �߰��ϱ� ���ؼ���
		// FileWriter������ ��� �ڿ� true�� �ۼ����ش�.
		// default�� false(�����)
		// 2. �ڵ�� �ۼ��� ���ڿ��� ���Ͽ� �Է��ϱ� ���ؼ���
		// write("���ڿ�")�� ����ϰ� �ݵ�� close()�� ������ش�.
//		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true));
//		
//		/*
//		 * JAVA�� �ü���� ������ �°� �ڵ����� �ٹٲ� ���ڸ� �������ش�.
//		 * ��������� �ؽ�Ʈ������ �ٹٲ��� \r\n�̴�.
//		 * \n���� �ۼ��ص� JVM�� \r\n���� �ٲ��ش�.
//		 */
//		
//		bw.write("���\n");
//		bw.write("����\n");
//		bw.write("���\n");
//		bw.close();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			String data = null;
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
			while(true) {
				data = br.readLine();
				if(data == null) {
					break;
				}
				System.out.println(data);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("�߸��� �����Դϴ�.");
		}finally {
//			br.close();
		}
	}
}






