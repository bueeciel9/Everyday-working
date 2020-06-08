package obj;

public class User {
	int num;
	
	public User() {}

	public User(int num) {
		super();
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User user = (User) obj;
			if(user.num == this.num) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
	
}








