 package model.item;

import controler.Controler;

public class Book extends Item {
	private String title;
	private Controler createur;

	public Book(String title, Controler createur){
		this.title = title;
		this.createur = createur;
	}
	
	public void read() {
		if(!"Objects first".equals(title)){
			owner.followLecture(null);
		}
		else{
			createur.followAllPOOLecture();
		}
	}
	
	@Override
	public String toString() {
		String str ="Book, if you read me, you will obtain all POO2 lecture";
		
		return str;
	}
}