package model;

import model.rooms.Lecture;
import controler.Controler;

public class LabItem extends Item {
	private Controler createur;
	private Lecture lecture;
	
	public LabItem(Controler createur, Lecture lecture){
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