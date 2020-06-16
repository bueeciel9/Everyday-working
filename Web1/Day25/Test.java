package view;

import dao.ProductDAO;
import vo.ProductDTO;

public class Test {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		dao.insert(9999, "연필", 500, "잘 써집니다.");
		dao.insert(8888, "지우개", 500, "잘 지워집니다.");
		
		for(ProductDTO product : dao.selectAll()) {
			System.out.println(product);
		}
		System.out.println("=====================");
		
		for(ProductDTO product : dao.select("연필")) {
			System.out.println(product);
		}
		
//		dao.delete(9999);
//		
//		for(ProductDTO product : dao.selectAll()) {
//			System.out.println(product);
//		}
	}
}





