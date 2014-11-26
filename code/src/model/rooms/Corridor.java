package model.rooms;

import model.item.Item;

import java.util.ArrayList;

public class Corridor extends Room {

	private boolean ligthState;

	public Corridor(String description) {
		super(description);
		ligthState = false;
	}

	public void switchOnLight() {
<<<<<<< HEAD
		if(ligthState != true){
			ligthState = true;
			System.out.println("Light switch on");
		}else{
			System.out.println("Light already switch on");
		}
	}

	public void switchOffLight() {
		if(ligthState != false){
			ligthState = false;
			System.out.println("Light switch off");
		}else
			System.out.println("Light already switch off");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The light is "+ligthState;
=======
		ligthState= true;
	}

	public void switchOffLight() {
		ligthState= false;
>>>>>>> 430f56113da3c995154581bb0d6da69d5bc28924
	}

}