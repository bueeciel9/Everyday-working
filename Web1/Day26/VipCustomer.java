package withArrayList;

public class VipCustomer extends Customer {
	
	private int agentID;
	double saleRatio;
	
	public VipCustomer (int CustomerID, String CustomerName,int agentID) {
		
		super(CustomerID, CustomerName);
		CustomerGrade = "VIP";
		bonusRatio  = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
		
	}
	
	public int calcPrice (int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price*saleRatio);
	}
	public String showCustomerInfo() {
		return super.showCustomerInfo() + " 담당 상담원 번호는 " + agentID + " 입니다. ";
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	
	
	

}
