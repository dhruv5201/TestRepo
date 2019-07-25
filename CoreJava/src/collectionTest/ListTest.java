package collectionTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List < String > li = new ArrayList<String>();
		li.add("Apple");
		li.add("Banana");
		li.add(null);
		li.add(null);
		li.add("Appale");
		displayList (li);
		checkIfExist(li, "Banana");
		

	}
	
	public static void displayList(List <String>li) {
		
		// Listing with Lamda Expression
//		li.forEach((i) ->  {
//			System.out.println(i);
//		});
		
		// Listing with For Each loop
				
		for (String i : li) {
			System.out.println(i);
			
		}
	}
	
	public static void checkIfExist(List <String> li , String a) {
		
		if (li.contains(a)) {
			System.out.println(a + " is Exist in the List..");
		}
		else System.out.println(a + " does not exist in the list");
	}

}
