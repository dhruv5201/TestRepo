package collectionTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> mp = new HashMap<Integer, String>();
		mp.put(01, "Dhrubajit");
		mp.put(02, "Vishnu");
		displayMap(mp);
		mp.remove(01);
		displayMap(mp);
		
		

	}
	public static void displayMap(Map<Integer, String> a) {
		
		if (a.isEmpty()) {
			System.out.println("Map is Empty.");

		} else {
			for (Map.Entry<Integer, String> entry : a.entrySet()) {
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
			}

		}
	}

}
