package model.item;
/**
 * @author loic
 */
import controler.Controller;
import model.rooms.Lecture;

public class LabItem extends Item {

	private String lectureKey;

	public LabItem(String lectureKey){
		this.lectureKey= lectureKey;
	}

	public String getLectureKey() {
		return lectureKey;
	}

	@Override
	public String toString() {
		//String str ="LabItem, if you read me, you will obtain the lecture "+lecture+"\n";
		return"" /*str*/;
	}
}