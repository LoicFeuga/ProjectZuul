package model.time;



import java.util.Date;

import controler.Controler;

public class Time implements Runnable{
	private Controler createur;
	private long hour;
	/**
	 * Créer un objet gerant le temps
	 */
	public Time(Controler createur){
		this.createur = createur;

		Date d = new Date();
		hour = d.getTime();
	}



	@Override
	public void run() {
		for(int i = 0 ; i < 100; i++){
			System.out.println("heure : "+hour);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
