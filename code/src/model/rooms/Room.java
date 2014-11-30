package model.rooms;

import model.item.Item;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. The exits are labelled north, east, south, west.
 * For each direction, the room stores a reference to the neighboring room, or
 * null if there is no exit in that direction.
 *
 * A "Room" can now contains some items and can be open or close
 *
 * @author Michael Kölling and David J. Barnes and loic
 * @version 2011.07.31
 */

public class Room {

	private boolean isOpen;
	private ArrayList<Item> items;
	public String description;
	private HashMap<String, Room> exits; // stores exits of this room.

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 *
	 * @param description
	 *            The room's description.
	 */
	public Room(String description) {
		this.description = description;
		items = new ArrayList<>();
		exits = new HashMap<>();
	}

	public Room(String description, ArrayList<Item> listItems){
		this.description = description;
		items = listItems;
	}
	/**
	 * Define an exit from this room.
	 *
	 * @param direction
	 *            The direction of the exit.
	 * @param neighbor
	 *            The room to which the exit leads.
	 */
	public void setExit(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	public void setExit(Room north, Room east, Room south, Room west){
		if(north != null) exits.put("north", north);
		if(east != null) exits.put("east", east);
		if(south != null) exits.put("south", south);
		if(west != null) exits.put("west",west);
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Return a description of the room's exits,
	 * for example, "Exits: north west".
	 * @return A description of the available exits.
	 */
	public String getExitString(){
		String str ="";
		str+="Exits: ";
		if (getExit("north") != null) {
			str+="north ";
		}
		if (getExit("east") != null) {
			str+="east ";
		}
		if (getExit("south") != null) {
			str+="south ";
		}
		if (getExit("west") != null) {
			str+="west ";
		}
		return str;
	}

	/**
	 * M�thode getExit, elle retourne la room � la direction sp�cifi�e
	 *   en op�rande
	 *
	 * @param direction north, east, ...
	 * @return La room point� par la direction
	 */
	public Room getExit(String direction){
		return exits.get(direction);
	}

	/**
	 * Accesseur de l'ouverture de la room
	 *
	 * @return true, si la room est ouverte,
	 * 		   false sinon
	 */
	public boolean isOpen(){
		return isOpen;
	}

	public void addItem(Item item){
		items.add(item);
	}


	public void deleteItem(Item item){
		items.remove(item);
	}

	public ArrayList getListItem(){
		return items;
	}


	public HashMap<String,Room> getExits() {
		return exits;
	}
}