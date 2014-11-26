package TestsUnit;

import controler.Controler;
import model.time.Time;

public class Tests_Time_N1 {

	public static void main(String[] args) {
		Controler c = new Controler();
		Time t1 = new Time(c);
		t1.run();
	}
}
