 package model.item;
/**
 * @author loic
 */
import controler.Controller;

 public class Book extends Item {
	private String title;
	private Controller createur;

	public Book(String title, Controller createur){
		this.title = title;
		this.createur = createur;
	}
	
	public void read() {
		if(!"Objects first".equals(title)){
			//owner.followLecture(null);
		}
		else{
			//createur.followAllPOOLecture();
		}
	}
	
	@Override
	public String toString() {
		String str ="Book, if you read me, you will obtain all POO2 lecture";
		
		return str;
	}
}