package model.item;
/**
 * @author loic
 */
import controler.Controller;
import model.Student;
import model.rooms.Lecture;

import java.util.HashMap;

public class Book extends Item {
	private String title;

	public Book(String title){
		this.title = title;
	}

	public void read(Student student, HashMap<String, Lecture> listLecture) {
		if("Objects first".equals(title)){
			student.followAllLectures(listLecture);
		}
		else{
			System.out.println("You didn't learn anything ,this book wasn't about OOP...");
		}
	}

	@Override
	public String toString() {
		String str ="Book, if you read me, you will obtain all OOP lecture";
		return str;
	}
}