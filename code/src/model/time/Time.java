package model.time;



import java.util.Date;
import java.util.HashMap;
import java.util.Observable;

import controler.Controller;

public class Time extends Observable implements Runnable{

	private long all;
	private int hour;
	private int minutes;
	private int secondes;
	private int day;
	
	/**
	 * Créer un objet gerant le temps
	 */
	public Time(){
		Date d = new Date();
		all = d.getTime();
		hour = 8;
		minutes = 0;
		secondes = 0;
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
			//if(i%60 == 0) printTime();
			try {Thread.sleep(10);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void warnEachHour(){
		String send = "dring";
		HashMap h = new HashMap();
		h.put("lecture",send);
		h.put("library",openLibrary());
		setChanged();
		notifyObservers(h);
	}
	
	public boolean openLibrary(){
		if(hour > 9 && hour < 12 ){

			return true;
		}else return false;
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
	public void lets(){
		new Thread(this).start();
	}

}
