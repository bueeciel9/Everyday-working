package vo;

public class ProductDTO {
	private int num;
	private String name;
	private int price;
	private String description;
	
	public ProductDTO() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		String msg = "상품번호 : " + this.num + "\n상품명 : " + this.name
				+ "\n상품가격 : " + this.price + "원\n상품설명 : " + this.description;
		return msg;
	}
	
}





