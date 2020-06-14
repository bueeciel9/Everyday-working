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
				} catch (FileNotFoundException e) {;}
		return br;
	}
}









