package model.rooms;

import model.item.Item;

import java.util.ArrayList;

public class Corridor extends Room {

	private boolean ligthState;

	public Corridor(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void switchOnLight() {
		ligthState= true;
	}

	public void switchOffLight() {
		ligthState= false;
	}

}