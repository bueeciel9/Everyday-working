package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Connection {
	public BufferedWriter connect_file_for_writing(String fileName) throws IOException{
		BufferedWriter bw = 
				new BufferedWriter(new FileWriter(fileName));
		return bw;
	}
	
	public BufferedWriter connect_file_for_appending(String fileName) throws IOException{
		BufferedWriter bw = 
				new BufferedWriter(new FileWriter(fileName, true));
		return bw;
	}
	
	public BufferedReader connect_file_for_reading(String fileName) throws IOException {
		BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(fileName));
				} catch (FileNotFoundException e) {
					//파일이 없으면 새로 만들어 준 후 br객체에 담아준다.
					BufferedWriter bw = connect_file_for_writing(fileName);
					bw.close();
					br = new BufferedReader(new FileReader(fileName));
				}
		return br;
	}
}









