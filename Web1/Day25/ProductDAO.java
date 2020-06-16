package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import vo.ProductDTO;

public class ProductDAO {
	Connection conn = new Connection();
	public final String FILE_NAME = "products.txt";

	
	//��ǰ��ȣ �ߺ��˻�
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
	//�߰�
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
	//����
	//			��ȣ, �̸�, ����, ����
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
				
				//�� �ٸ��� ,�� ������ �и����ش�(4ĭ �迭)
				arTemp = line.split(",");
				
				//Integer.parseInt(arTemp[0]) : �޸��忡 �ִ� �� ���� ��ǰ��ȣ
				//num : ������ ��ǰ�� ��ȣ
				if(Integer.parseInt(arTemp[0]) == num) {
					//������ ��ǰ�� �ִٸ� ����
					result = 1;
					if(idx == 0) {
						//����ڰ� ��ǰ���� ������ ��
						//�ܺο��� ���ο� ��ǰ��ȣ, ���ο� ��ǰ���� ���޵ȴ�.
						//���� ,�� ������ �ش�.
						String[] new_datas = new_data.split(",");
						//���ο� ��ǰ��ȣ �ߺ��˻�
						if(!check_duplicating_num(Integer.parseInt(new_datas[0]))) {
							//�ߺ��� ���� �� ����
							arTemp[0] = new_datas[0];
							arTemp[1] = new_datas[1];
						}else {
							//���ο� ��ǰ��ȣ�� �ߺ��� ���� ��
							result = 0;
							break;
						}
					}else {
						//����ڰ� ���� �Ǵ� ������ ������ ��
						
						//�ܺο��� �̸�(0)�� �����Ѵٸ� arTemp�� 0,1��° �濡 ���� ����.
						//���� ����(1),����(2)�� �����Ѵٸ� +1�� ���־��
						//�´� �ε���(����(2), ����(3))�� ���� �� �ִ�.
						idx++;
						
						arTemp[idx] = new_data;
					}
					for(int i = 0; i < arTemp.length; i++) {
						//arTemp�� �̹� ������ ������ ������ �ִ�.
						
						//������ ������ ,�� \n���� �����Ͽ� temp�� �������ش�.
						temp += arTemp[i];
						temp += i == arTemp.length - 1 ? "\n" : ","; 
					}
					continue;
				}
				//���� ������ �����Ͱ� �ƴ϶�� �״�� temp�� �������ش�.
				temp += line + "\n";
			}
			if(result == 1) {
				//���� ������ ������ �����͸� ������ temp�� ���� �޸��忡 ������ش�.
				BufferedWriter bw = conn.connect_file_for_writing(FILE_NAME);
				bw.write(temp);
				bw.close();
			}
		} catch (IOException e) {;}
		//[result]
		//0 : ���ο� ��ǰ ��ȣ �ߺ�
		//1 : ���� ����
		//-1 : ������ ��ǰ ����
		return result;
	}
	//����
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
	//�˻�
	public ArrayList<ProductDTO> select(String keyword) {
		//���޹��� keyword�� DB(�޸���)���� �˻��Ѵ�.
		//�� �پ� contains()�� ����Ͽ� �˻����ش�.
		//�˻��� ���� �� �����͸� DTO��ü�� setter()�� �̿��ؼ� ����� ��
		//ArrayList<ProductDTO> ��ü�� add()�� �߰����ش�.
		//while���� ��� ����� �� ArrayList ��ü�� �������ش�.
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
	//���
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
















