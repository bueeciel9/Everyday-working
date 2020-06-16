package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import vo.ProductDTO;

public class ProductDAO {
	Connection conn = new Connection();
	public final String FILE_NAME = "products.txt";

	
	//상품번호 중복검사
	public boolean check_duplicating_num(int num) {
		BufferedReader br = null;
		String line = "";
		boolean check = false;
		try {
			br = conn.connect_file_for_reading(FILE_NAME);
			while(true) {
				line = br.readLine();
				if(line == null) {break;}
				if(num == Integer.parseInt(line.split(",")[0])) {
					check = true;
					break;
				}
			}
			br.close();
		} catch (IOException e) {;}
		return check;
	}
	//추가
	public boolean insert(int num, String name, int price, String description) {
	
		boolean check = false;
		if(!check_duplicating_num(num)) {
			BufferedWriter bw = null;
			try {
				bw = conn.connect_file_for_appending(FILE_NAME);
				bw.write(num + ",");
				bw.write(name + ",");
				bw.write(price + ",");
				bw.write(description + "\n");
				bw.close();
				check = true;
			} catch (IOException e) {;}
		}
		return check;
	}
	//수정
	//			번호, 이름, 가격, 설명
	//idx			   0		  1		  2
	//arTemp	0	  1	      2		  3
	public int update(int idx, int num, String new_data) {
		int result = -1;
		try {
			BufferedReader br = conn.connect_file_for_reading(FILE_NAME);
			String line = null;
			String temp = "";
			String[] arTemp = null;
			while(true) {
				line = br.readLine();
				if(line == null) {break;}
				
				//각 줄마다 ,로 값들을 분리해준다(4칸 배열)
				arTemp = line.split(",");
				
				//Integer.parseInt(arTemp[0]) : 메모장에 있는 각 줄의 상품번호
				//num : 수정할 상품의 번호
				if(Integer.parseInt(arTemp[0]) == num) {
					//수정할 상품이 있다면 들어옴
					result = 1;
					if(idx == 0) {
						//사용자가 상품명을 수정할 때
						//외부에서 새로운 상품번호, 새로운 상품명이 전달된다.
						//따라서 ,로 나누어 준다.
						String[] new_datas = new_data.split(",");
						//새로운 상품번호 중복검사
						if(!check_duplicating_num(Integer.parseInt(new_datas[0]))) {
							//중복이 없을 때 들어옴
							arTemp[0] = new_datas[0];
							arTemp[1] = new_datas[1];
						}else {
							//새로운 상품번호가 중복이 있을 때
							result = 0;
							break;
						}
					}else {
						//사용자가 가격 또는 설명을 수정할 때
						
						//외부에서 이름(0)을 수정한다면 arTemp의 0,1번째 방에 값이 들어간다.
						//따라서 가격(1),설명(2)을 수정한다면 +1을 해주어야
						//맞는 인덱스(가격(2), 설명(3))에 넣을 수 있다.
						idx++;
						
						arTemp[idx] = new_data;
					}
					for(int i = 0; i < arTemp.length; i++) {
						//arTemp는 이미 수정된 값들을 가지고 있다.
						
						//수정된 값들을 ,와 \n으로 연결하여 temp에 연결해준다.
						temp += arTemp[i];
						temp += i == arTemp.length - 1 ? "\n" : ","; 
					}
					continue;
				}
				//만약 수정할 데이터가 아니라면 그대로 temp에 연결해준다.
				temp += line + "\n";
			}
			if(result == 1) {
				//수정 성공시 수정된 데이터를 저장한 temp를 기존 메모장에 덮어씌워준다.
				BufferedWriter bw = conn.connect_file_for_writing(FILE_NAME);
				bw.write(temp);
				bw.close();
			}
		} catch (IOException e) {;}
		//[result]
		//0 : 새로운 상품 번호 중복
		//1 : 수정 성공
		//-1 : 수정할 상품 없음
		return result;
	}
	//삭제
	public boolean delete(int num) {
		BufferedReader br = null;
		String line = null;
		String temp = "";
		boolean check = false;
		try {
			br = conn.connect_file_for_reading(FILE_NAME);
			while(true) {
				line = br.readLine();
				
				if(line == null) {break;}
				String[] arTemp = line.split(",");
				if(arTemp[0].equals(num + "")) {
					check = true;
					continue;
				}
				temp += line + "\n";
			}
			br.close();
			
			BufferedWriter bw = conn.connect_file_for_writing(FILE_NAME);
			bw.write(temp);
			bw.close();
			
		} catch (IOException e) {;}
		
		return check;
	}
	//검색
	public ArrayList<ProductDTO> select(String keyword) {
		//전달받은 keyword를 DB(메모장)에서 검색한다.
		//한 줄씩 contains()를 사용하여 검색해준다.
		//검색된 줄의 각 데이터를 DTO객체에 setter()를 이용해서 담아준 후
		//ArrayList<ProductDTO> 객체에 add()로 추가해준다.
		//while문이 모두 종료된 후 ArrayList 객체를 리턴해준다.
		ArrayList<ProductDTO> arProduct = new ArrayList<>();
		try {
			BufferedReader br = conn.connect_file_for_reading(FILE_NAME);
			String line = null;
			ProductDTO product_dto = null;
			
			while(true) {
				line = br.readLine();
				
				if(line == null) {break;}
				
				if(line.contains(keyword)) {
					product_dto = new ProductDTO();
					
					String[] arTemp = line.split(",");

					product_dto.setNum(Integer.parseInt(arTemp[0]));
					product_dto.setName(arTemp[1]);
					product_dto.setPrice(Integer.parseInt(arTemp[2]));
					product_dto.setDescription(arTemp[3]);
					
					arProduct.add(product_dto);
					
				}
			}
			br.close();
		} catch (IOException e) {;}
		return arProduct;
	}
	//목록
	public ArrayList<ProductDTO> selectAll() {
		ArrayList<ProductDTO> arProduct = new ArrayList<>();
		try {
			BufferedReader br = conn.connect_file_for_reading(FILE_NAME);
			String line = null;
			ProductDTO product_dto = null;
			
			while(true) {
				line = br.readLine();
				
				if(line == null) {break;}
				
				product_dto = new ProductDTO();
				
				String[] arTemp = line.split(",");

				product_dto.setNum(Integer.parseInt(arTemp[0]));
				product_dto.setName(arTemp[1]);
				product_dto.setPrice(Integer.parseInt(arTemp[2]));
				product_dto.setDescription(arTemp[3]);
				
				arProduct.add(product_dto);
			}
			br.close();
		} catch (IOException e) {;}
		return arProduct;
	}
}
















