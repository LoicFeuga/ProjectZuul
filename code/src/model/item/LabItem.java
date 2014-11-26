package model.item;
/**
 * @author loic
 */
import controler.Controller;
import model.rooms.Lecture;

public class LabItem extends Item {
	private Controller createur;
	private Lecture lecture;
	
	public LabItem(Controller createur, Lecture lecture){
		this.createur = createur;
		this.lecture = lecture;
	}
	
	public Lecture getLecture(){return this.lecture;}
	
	public void use(){
		createur.getStudent().followLecture(lecture);
	}
	
	@Override
	public String toString() {
		String str ="LabItem, if you read me, you will obtain the lecture "+lecture+"\n";
	
		
		return str;
	}
}