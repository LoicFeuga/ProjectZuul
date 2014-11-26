package model.item;
/**
 * @author loic
 */
import model.Student;
import model.rooms.Room;

public abstract class Item {
	public Student owner;
	public Room position;
	
	public Student getOwner() {
		return owner;
	}
	public void setOwner(Student owner) {
		this.owner = owner;
	}
	public Room getPosition() {
		return position;
	}
	public void setPosition(Room position) {
		this.position = position;
	}

}