package map;

import java.util.HashMap;

public class MapTest2 {
	public static void main(String[] args) {
		HashMap<User, String> userMap = new HashMap<>();
		userMap.put(new User(1), "ÇÑµ¿¼®");
		System.out.println(userMap.get(new User(1)));
	}
}
