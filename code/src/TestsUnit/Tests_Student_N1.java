package TestsUnit;
/**
 * @author loic
 */
import model.item.Coffee;
import model.rooms.Lecture;
import model.rooms.Room;
import model.Student;

import java.util.HashMap;

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

		HashMap<String,Lecture> listLecture;
		listLecture = new HashMap<>();
		//LEcture's description is the future key of the HashMap
		Lecture l = new Lecture("POO0","Cours de POO2","POO0");
		l.setCatchStudent(true);
		l.setPOO(true);
		Lecture l2 = new Lecture("POO1","TD de POO2","POO1");
		l2.setCatchStudent(true);
		l2.setPOO(true);
		Lecture lex = new Lecture("POOEx", "POO exam","POOEx");
		lex.setCatchStudent(true);
		lex.setPOO(true);
		Lecture l3 = new Lecture("AA","TD de AA","AA");
		Lecture lec = new Lecture("T","Current lesson","T");
		Lecture lec2 = new Lecture("T2","Current lesson","T2");

		listLecture.put("POO0",l);
		listLecture.put("POO1",l2);
		listLecture.put("AA",l3);
		listLecture.put("T",lec);
		listLecture.put("T2",lec2);
		listLecture.put("POOEx",lex);

		System.out.println(st.hasAllLectureLab(listLecture));
	}

}
