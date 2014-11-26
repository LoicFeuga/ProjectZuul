package controler;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import model.item.Item;
import model.item.LectureItem;
import model.item.Tablets;
import model.rooms.Lecture;
import model.Student;
/**
 *
 * @author loic
 *
 */

public class Controler {
	private Student student;
	private Game game;

	public Controler(){
		game = new Game(this);
		game.play();
	}




	public void setStudent(Student student){
		this.student = student;
	}

	public Student getStudent(){
		return this.student;
	}

	public Item getItem(int i){
		return (Item) game.getListItem().get(i);
	}

	public void followAllPOOLecture(){

		Iterator<String> i = game.getListLecture().keySet().iterator();
		String chaine;

		while(i.hasNext()){
			chaine = i.next();
			if(chaine.contains("POO")){
				student.followLecture(game.getListLecture().get(chaine));
			}
		}

	}

	public Lecture getRandomLecture(){

		int max  =game.getListLecture().size(); int min = 0;
		//min et max inclu
		int rand = min + (int)(Math.random() * ((max - min) + 1));


		return game.getListLecture().get(rand);
	}

	//Test ok
	public Lecture getRandomLectureThanStudentDontKnow(){
		int rand = 0;
		String chaine = null;
		do{
			int max  =game.getListLecture().size() -1; int min = 0;
			//min et max inclu
			rand = min + (int)(Math.random() * ((max - min) + 1));



			Iterator<String> i = game.getListLecture().keySet().iterator();
			if(i.hasNext())
			{
				chaine =i.next();


			}


			if(chaine != null)
				while(i.hasNext() && student.know(game.getListLecture().get(chaine)) && rand >= 0){
					rand--;
					chaine = i.next();
				}

		}while(student.know(game.getListLecture().get(chaine)));


		return game.getListLecture().get(chaine);
	}

	//Test OK
	public Lecture getRandomLectureThanStudentKnow(){
		int rand = 0;
		String chaine = null;
		do{
			int max  =game.getListLecture().size() -1; int min = 0;
			//min et max inclu
			rand = min + (int)(Math.random() * ((max - min) + 1));

			Iterator<String> i = game.getListLecture().keySet().iterator();


			while(i.hasNext() && rand >= 0){
				rand--;
				chaine = i.next();

			}


		}while(!student.know(game.getListLecture().get(chaine)));


		return game.getListLecture().get(chaine);
	}

	public Game getGame(){
		return game;
	}

	public void printListLecture(){

		Iterator<String> i = game.getListLecture().keySet().iterator();

		while(i.hasNext()){
			System.out.println(game.getListLecture().get(i.next()));
		}
	}


	public static void main(String[] args) {
		Controler c1 = new Controler();
	}

}
