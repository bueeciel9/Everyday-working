package day23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest3 {
	public static void main(String[] args) throws IOException {
		String fileName = "names.txt";
//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//		bw.close();
		
		String contents = new String(Files.readAllBytes(Paths.get(fileName)), "EUC-KR");
//		System.out.println(contents);
		for(String data : contents.split("\r\n")) {
			System.out.println(data + "ดิ");
		}
	}
}





