package TestsUnit;

import model.Coffee;
import model.Room;
import model.Student;
import model.Book;
import controler.Controler;

public class Tests_Item_N1 {
	
	public static void main(String[] args) {
		
		Controler c= new Controler();
		
		Student st = new Student();
		c.setStudent(st);
		Room r = new Room("An empty room");
		
		st.getItem(c.getItem(0));
		
		System.out.println(st.toString());
		st.printOwnItem();
		
		st.printLectureFollowed();
		
		((Book)st.getListItem().get(0)).read();

		st.printLectureFollowed();

		
		
	}

}
