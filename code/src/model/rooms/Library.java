package model.rooms;

import model.item.Item;
import model.Student;

import java.util.ArrayList;
import java.util.Date;

public class Library extends Room {

	private Date timeOpen;
	private Date timeClose;
	private ArrayList<Item> items;


	public Library(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void readBook(Student stud) {
		//add a Lecture the student don't have yet.
		stud.followLecture();
	}

	public void setOpenCloseTime(Date open, Date close) {
		this.timeClose=close;
		this.timeOpen=open;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item it){
		this.items.add(it);
	}
}