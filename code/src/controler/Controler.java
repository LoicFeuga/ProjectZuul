package controler;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import model.Item;
import model.Lecture;
import model.Student;

public class Controler {
	private HashMap<String,Lecture> listLecture;
	private ArrayList<Item> listItem;
	private Student student;

	public Controler(){
		listLecture = new HashMap<String,Lecture>();
		listItem = new ArrayList<>();
		initLecture();
		model.Book b = new model.Book("Objects first", this);
		listItem.add(b);
	}



	public void initLecture(){
		Lecture l = new Lecture("A fake description","Cours de POO2");
		Lecture l2 = new Lecture("A fake description2","TD de POO2");
		Lecture l3 = new Lecture("A fake description3","TD de AA");
		listLecture.put("POO0",l);
		listLecture.put("POO1",l2);

	}

	public void setStudent(Student student){
		this.student = student;
	}

	public Student getStudent(){
		return this.student;
	}

	public Item getItem(int i){
		return listItem.get(i);
	}

	public void followAllPOOLecture(){

		Iterator<String> i = listLecture.keySet().iterator();
		String chaine;

		while(i.hasNext()){
			chaine = i.next();
			if(chaine.contains("POO")){
				student.followLecture(listLecture.get(chaine));
			}
		}

	}
}
