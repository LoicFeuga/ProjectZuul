package model.rooms;

import model.item.Item;

import java.util.ArrayList;

public class LunchRoom extends Room {
	private ArrayList<Item> items;

	public LunchRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void drinkCoffee() {
		throw new UnsupportedOperationException();
	}

	public void playingTableFootball() {
		throw new UnsupportedOperationException();
	}

	public Lecture forgetLecture(Object arrayList_Lesson) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item it){
		this.items.add(it);
	}
}