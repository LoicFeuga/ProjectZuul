package model.rooms;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Classroom extends Room implements Observer{
	private Lecture lect;

	public Classroom(String description, Lecture lect) {
		super(description);
		this.lect = lect;
	}

	public Lecture getLect() {
		return lect;
	}

	public void setLect(Lecture lect) {
		this.lect = lect;
	}

	@Override
	public void update(Observable observable, Object o) {
		String tmp = (String) ((HashMap)o).get("lecture");
		if(tmp.equals("dring")){
			//switch lecture
		}
	}


}