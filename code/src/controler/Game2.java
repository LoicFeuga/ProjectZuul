package controler;

import java.util.ArrayList;
import java.util.HashMap;

import model.item.Item;
import model.item.LectureItem;
import model.item.Tablets;
import model.rooms.Lab;
import model.rooms.Lecture;
import model.rooms.Room;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * To play this game, create an instance of this class and call the "play"
 * method.
 *
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game2 {
	private Parser parser;
	private Room currentRoom;

	private HashMap<String,Lecture> listLecture;
	private ArrayList<Item> listItem;
	private Controler createur;

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game2(Controler createur) {
		createRooms();
		parser = new Parser();
		this.createur = createur;
		listLecture = new HashMap<String,Lecture>();
		listItem = new ArrayList<>();
		initLecture();
		initItem();
	}
	
	public void initItem(){

		model.item.Book b = new model.item.Book("Objects first", createur);

		LectureItem li = new LectureItem(createur, listLecture.get("T"));
		Tablets t = new Tablets(createur);
		listItem.add(b);
		listItem.add(li);
		listItem.add(t);
	}


	public void initLecture(){
		Lecture l = new Lecture("A fake description","Cours de POO2");
		Lecture l2 = new Lecture("A fake description2","TD de POO2");
		Lecture l3 = new Lecture("A fake description3","TD de AA");
		Lecture lec = new Lecture("Description","Current lesson");
		Lecture lec2 = new Lecture("Description2","Current lesson");

		listLecture.put("POO0",l);
		listLecture.put("POO1",l2);
		listLecture.put("AA",l3);
		listLecture.put("T",lec);
		listLecture.put("T2",lec2);

	}
	

	/**
	 * Create all the rooms and link their exits together.
	 */
	private void createRooms() {

		Room lab1,lab2,corridoor1,corridoor2,classroom1,classroom2,library,exam1,lunchRoom1;

		lab1 = new Lab("Lab1");
		lab2 = new Lab("Lab2");
		corridoor1 = new Lab("Corridor 1");
		corridoor2 = new Lab("Corridor 2");
		classroom1 = new Lab("ClassRoom 1");
		classroom2 = new Lab("ClassRoom 2");
		library = new Lab("Library");
		exam1 = new Lab("Exam 1");
		lunchRoom1 = new Lab("LunchRoom 1");

		//set exits
		lab1.setExit("west",lab2);
		lab2.setExit("east",lab1);
		corridoor1.setExit("north",lab1);
		corridoor1.setExit("south",exam1);
		corridoor2.setExit("west",classroom1);
		classroom1.setExit("west",corridoor2);
		classroom1.setExit("east",corridoor1);
		classroom2.setExit("west",corridoor1);
		classroom2.setExit("east",lunchRoom1);
		library.setExit("east",corridoor2);
		exam1.setExit("north",corridoor1);
		lunchRoom1.setExit("west",classroom2);

		currentRoom = corridoor1; // start game corridoor 1*/

		/*Room outside, hall1, hall2, salle100,salle101,salle102,salle103,annexeSalle102,toilette,couloir1,couloir2,couloir3,cagibi,
		lab,annexeLab,sortie;

		// create the rooms
		outside = new Room("outside the main entrance of the university");	
		hall1 = new Corridor("first part of big hall");
		hall2 = new Corridor("second part of big hall");
		salle100 = new Classroom("the 100 room in university");
		salle101 = new Classroom("the 101 room in university");
		salle102 = new Classroom("the 102 room in university");
		salle103 = new Classroom("the 103 room in university");
		annexeSalle102 = new Room("the annexe of room 102");
		toilette = new Room("toilette of university");
		couloir1 = new Corridor("first part of big corridor");
		couloir2 = new Corridor("second part of big corridor");
		couloir3 = new Corridor("third part of big corridor");
		cagibi = new Room("a room for brooms and other things");
		lab = new Lab("the lab for strange professor");
		annexeLab = new Lab("the lab annexe contains a lot of strange things");
		sortie = new Room("outside by annexe");



		// initialise room exits
		outside.setExit("north",hall1);
		
		hall1.setExit("north",hall2);
		hall1.setExit("west", salle100); 
		hall1.setExit("south", outside);
		hall1.setExit("east", salle101);
		
		hall2.setExit("north",couloir1); 
		hall2.setExit("south", hall1);
		hall2.setExit("east", salle103);
		hall2.setExit("west", salle102);
		
		salle100.setExit("east", hall1);
		
		salle101.setExit("west",hall1);
		
		salle102.setExit("east", hall2);
		salle102.setExit("west",annexeSalle102);
		
		salle103.setExit("west",hall2);
		
		annexeSalle102.setExit("east", salle102);
		
		couloir1.setExit(cagibi, couloir2, hall2, couloir3);
		couloir3.setExit(null, couloir1, null, toilette);
		couloir2.setExit(null, lab, null, couloir1);
		toilette.setExit(null, couloir3, null, null);
		lab.setExit(null, null, annexeLab, couloir2);
		annexeLab.setExit(lab, sortie, null, null);
		sortie.setExit(null, null, null, annexeLab);
		cagibi.setExit(null,null, couloir1, null);

		currentRoom = outside; // start game outside*/
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		Command command;
		do{
			command = parser.getCommand();
		}while(!processCommand(command));
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to the World of Zuul!");
		System.out.println("World of Zuul is a new, incredibly boring adventure game.");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
		printLocationInfo();
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 *
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");

			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			return quit(command);
		}

		return wantToQuit;
	}

	private void printLocationInfo() {
		System.out.println("You are " + currentRoom.getDescription());
		System.out.println(currentRoom.getExitString());
		System.out.println();
	}

	// implementations of user commands:

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println("around at the university.");
		System.out.println();
		System.out.println("Your command words are:");
		System.out.println("   go quit help");
	}

	/**
	 * Try to go in one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = null;
		if (direction.equals("north")) {
			nextRoom = currentRoom.getExit("north");
		}
		else if (direction.equals("east")) {
			nextRoom = currentRoom.getExit("east");
		}
		else if (direction.equals("south")) {
			nextRoom = currentRoom.getExit("south");
		}
		else if (direction.equals("west")) {
			nextRoom = currentRoom.getExit("west");
		}

		if (nextRoom == null) {
			System.out.println("There is no door!");
		} else {
			currentRoom = nextRoom;
			printLocationInfo();
		}
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 *
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		} else {
			return true; // signal that we want to quit
		}
	}
	
	public ArrayList getListItem(){
		return listItem;
	}
	
	public HashMap<String, Lecture> getListLecture(){
		return listLecture;
	}
}
