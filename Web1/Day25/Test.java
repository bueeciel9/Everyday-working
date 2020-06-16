package view;

import dao.ProductDAO;
import vo.ProductDTO;

public class Test {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		dao.insert(9999, "����", 500, "�� �����ϴ�.");
		dao.insert(8888, "���찳", 500, "�� �������ϴ�.");
		
		for(ProductDTO product : dao.selectAll()) {
			System.out.println(product);
		}
		System.out.println("=====================");
		
		for(ProductDTO product : dao.select("����")) {
			System.out.println(product);
		}
		
//		dao.delete(9999);
//		
//		for(ProductDTO product : dao.selectAll()) {
//			System.out.println(product);
//		}
	}
}





