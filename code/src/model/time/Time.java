package model.time;



import java.util.Date;
import java.util.Observable;

import controler.Controler;

public class Time extends Observable implements Runnable{
	private Controler createur;
	private long all;
	private int hour;
	private int minutes;
	private int secondes;
	private int day;
	
	/**
	 * Créer un objet gerant le temps
	 */
	public Time(Controler createur){
		this.createur = createur;

		Date d = new Date();
		all = d.getTime();
		hour = d.getHours();
		minutes = d.getMinutes();
		secondes = d.getSeconds();
		day = 0;
		
	}

	public void manageTime(){
		secondes++;
		if(secondes == 60){
			secondes=0;
			minutes++;
		}if(minutes == 60){
			minutes = 0;
			hour++;
			warnEachHour();
		}if(hour == 24){
			hour=0;
			day++;
		}
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 10000; i++){
			manageTime();
			if(i%60 == 0) printTime();
			try {Thread.sleep(10);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void warnEachHour(){
		String send = "dring";
		
		setChanged();
		notifyObservers(send);
	}
	
	@Override
	public String toString() {
		String str="";
		str+="Jour : " +day+"\t"+hour+":"+minutes+":"+secondes;
		return str;
	}
	
	public void printTime(){
			System.out.println(this.toString());
	}

}
