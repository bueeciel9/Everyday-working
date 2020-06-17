package withArrayList;

public class GoldCustomer extends Customer{
	
	double saleRatio;
	public GoldCustomer(int CustomerID, String CustomerName) {
		super(CustomerID, CustomerName);
		
		CustomerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
		
	}
	
	public int clacPrice(int price) {
		bonusPoint += price*bonusRatio;
		return price - (int)(price*saleRatio);
	}

}
