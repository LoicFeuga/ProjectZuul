package model.rooms;

import model.Student;






import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Library extends Room  implements Observer{


	private boolean closed;

	public Library(String description) {
		super(description);
		closed=false;
	}

	public void readBook(Student stud, HashMap<String, Lecture> listLect) {
		//add all Lectures the student don't have yet.
		stud.followAllLectures(listLect);
	}

	public boolean isClosed() {
		int rand = 0 + (int)(Math.random() * ((1 - 0) + 1));
		closed = (rand!=0);
		return closed;
	}

	@Override
	public void update(Observable o, Object arg) {
		closed = (boolean) ((HashMap) arg).get("library");
	}
}