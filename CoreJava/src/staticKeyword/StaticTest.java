package staticKeyword;


public class StaticTest {
	static{
		System.out.println("First Block to execute..! Even before main..! ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student (101,"Nishka Das");
		Student student2 = new Student (102,"Dhrubajit Das");
		student1.displayStudent();
		student2.displayStudent();
	}

}
class Student{
	int roll;
	String name;
	static String College ="National PG College";
	static int counter;
	Student(int roll , String name){
		if ( roll != 0 && name != null) {
			this.roll = roll;
			this.name = name;
			counter ++;
			System.out.println(" Student Object Creation Number : " + counter);
		}
		else 
			throw new NumberFormatException("Student Data not Correct..!!");
		
	}
	public void displayStudent() {
		System.out.println("Name: " + name + " | Roll No: "+ roll + " | College Name: "+ College );
	}
}
