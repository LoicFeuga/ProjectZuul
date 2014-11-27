package model.item;
import model.rooms.Lecture;
import controler.*;
/**
 *
 * @author loic
 *
 */
public class LectureItem extends Item {

	private String lectureKey;

	public LectureItem(String lectureKey){
		this.lectureKey= lectureKey;
	}

	public String getLectureKey() {
		return lectureKey;
	}

	@Override
	public String toString() {
		//String str ="LectureItem, if you read me, you will obtain the lecture "+lecture+"\n";
		return "" /*str*/;
	}
}