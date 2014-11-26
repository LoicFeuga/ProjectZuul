package TestsUnit;
/**
 * @author loic
 */
import controler.Controller;
import model.item.Book;
import model.item.Tablets;
import model.rooms.Room;
import model.Student;

public class Tests_Item_N1 {
	
	public static void main(String[] args) {
		
		
		Controller c= new Controller();
		System.out.println("+Controller cr��");
		Student st = new Student();
		System.out.println("+Student cr��");
		
		c.setStudent(st);
		Room r = new Room("An empty room");
		
		st.getItem(c.getItem(0));
		System.out.println("++R�cup�ration de l'item par le Student");
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
		System.out.println("+M�thode getRandomThanStudentKnow");
		System.out.println(c.getRandomLectureThanStudentKnow());
		System.out.println("+M�thode getRandomThanStudentDontKnow");
		System.out.println(c.getRandomLectureThanStudentDontKnow());
		System.out.println("+Tablet cr��");
		st.getItem(c.getItem(2));
		((Tablets)st.getListItem().get(2)).use();
		System.out.println("++Utilisation de la tablet");
		st.printLectureFollowed();
	}	

}
