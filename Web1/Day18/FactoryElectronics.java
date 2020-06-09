package day18;

public class FactoryElectronics {
	public Electronics getElectronics(String type) {
		if(type.equalsIgnoreCase("TV")) {
			return new TV();
			
		}else if(type.equalsIgnoreCase("REFRIGERATOR")) {
			return new Refrigerator();
			
		}else if(type.equalsIgnoreCase("VACUUM")) {
			return new Vacuum();
			
		}
		return null;
	}
}
