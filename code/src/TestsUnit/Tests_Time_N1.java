package TestsUnit;

import controler.Controller;
import model.time.Time;

public class Tests_Time_N1 {

	public static void main(String[] args) {
		Controller c = new Controller();
		Time t1 = new Time(c);
		t1.run();
	}
}
