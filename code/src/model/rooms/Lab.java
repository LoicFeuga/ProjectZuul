package model.rooms;


import java.util.Observable;
import java.util.Observer;

public class Lab extends Room implements Observer{
	private Lecture lect;

	public Lab(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable observable, Object o) {
		String tmp = (String) o;
		if(o.equals("dring")){
			//switch lecture
		}
	}

	public Lecture getLect() {
		return lect;
	}

	public void setLect(Lecture lect) {
		this.lect = lect;
	}
}