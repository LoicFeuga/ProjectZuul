package model.rooms;

import model.item.Item;
import model.rooms.Lecture;

import java.util.ArrayList;

public class Lab extends Lecture {
	private ArrayList<Item> items;

	public Lab(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item it){
		this.items.add(it);
	}
}