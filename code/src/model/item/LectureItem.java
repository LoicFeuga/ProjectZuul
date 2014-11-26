package model.item;
import model.rooms.Lecture;
import controler.*;
/**
 * 
 * @author loic
 *
 */
public class LectureItem extends Item {
	private Controler createur;
	private Lecture lecture;
	
	public LectureItem(Controler createur, Lecture lecture){
		this.createur = createur;
		this.lecture = lecture;
	}
	
	public Lecture getLecture(){return this.lecture;}
	
	public void use(){
		createur.getStudent().followLecture(lecture);
	}
	
	@Override
	public String toString() {
		String str ="LectureItem, if you read me, you will obtain the lecture "+lecture+"\n";
	
		
		return str;
	}
	

}