package TestsUnit;

import model.Coffee;
import model.Room;
import model.Student;

public class Tests_Student_N1 {
	
	
	
	public static void main(String[] args) {
		Student st = new Student();

		Room r = new Room("An empty room");
		Coffee c = new Coffee(st, r);
		System.out.println(st.toString());
		st.getItem(c);
		System.out.println(st.toString());
		st.printOwnItem();
		((Coffee)st.getListItem().get(0)).drink();
		System.out.println(st.toString());
		
	}

}
