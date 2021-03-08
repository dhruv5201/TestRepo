package collectionTest;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set <String> set = new HashSet <String> ();
		
		set.add("Apple");
		set.add("Banana");
		set.add(null);
		set.add(null);
		set.add("Apple");
		displayeSet(set);
		

	}
	
	public static void displayeSet(Set <String> st ) {
		if (!st.isEmpty()) {
			for (String str : st) {
				System.out.println(str);
			}
			
		}
		else
		System.out.println("List is empty..!");
	}

}
