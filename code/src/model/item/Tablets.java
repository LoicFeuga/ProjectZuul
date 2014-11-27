package model.item;
/**
 * @author loic
 */

import model.rooms.Lecture;
import controler.Controller;

public class Tablets extends Item {
	private Controller createur;
	
	public Tablets(Controller createur){
		this.createur = createur;
	}
	
	private void read() {
		System.out.println("Lire");
		//Lecture l  = createur.getRandomLectureThanStudentDontKnow();
		//createur.getStudent().followLecture(l);
	}

	private void play() {
		System.out.println("Jeux");
		//Lecture l  = createur.getRandomLectureThanStudentKnow();
		//createur.getStudent().forgetLecture(l);
	}

	/**
	 * Utilisation de la tablet al�atoirement entre read et play
	 *   pour l'instant 50%
	 */
	public void use() {
		int max  =1; int min = 0;
		//min et max inclu
		int rand = min + (int)(Math.random() * ((max - min) + 1));

		System.out.println("##==[DEBUG]==## ----- "+rand);
		
		if(rand == 1){
			play();
		}else{
			read();
		}
	}
}