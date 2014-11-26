package TestsUnit;

import model.item.Book;
import model.item.Coffee;
import model.item.LectureItem;
import model.item.Tablets;
import model.rooms.Lecture;
import model.rooms.Room;
import model.Student;
import controler.Controler;

public class Tests_Item_N1 {
	
	public static void main(String[] args) {
		
		
		Controler c= new Controler();
		System.out.println("+Controler créé");
		Student st = new Student();
		System.out.println("+Student créé");
		
		c.setStudent(st);
		Room r = new Room("An empty room");
		
		st.getItem(c.getItem(0));
		System.out.println("++Récupération de l'item par le Student");
		System.out.print("\t");
		System.out.println(st.toString());
		System.out.println("++Affichage des items du Student");System.out.print("\t");
		st.printOwnItem();
		System.out.println("++Affichage des Lecture suivi");System.out.print("\t");
		st.printLectureFollowed();
		
		((Book)st.getListItem().get(0)).read();
		
		System.out.println("++Affichage des Lecture suivi");System.out.print("\t");
		st.printLectureFollowed();
		
		
		st.getItem(c.getItem(1));
		
		st.printOwnItem();
		


		
		st.printLectureFollowed();
		c.printListLecture();
		System.out.println("+Méthode getRandomThanStudentKnow");
		System.out.println(c.getRandomLectureThanStudentKnow());
		System.out.println("+Méthode getRandomThanStudentDontKnow");
		System.out.println(c.getRandomLectureThanStudentDontKnow());
		System.out.println("+Tablet créé");
		st.getItem(c.getItem(2));
		((Tablets)st.getListItem().get(2)).use();
		System.out.println("++Utilisation de la tablet");
		st.printLectureFollowed();
	}	

}
