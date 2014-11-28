package controler;

import java.util.ArrayList;
import java.util.HashMap;

import model.item.*;
import model.Student;
import model.item.Item;
import model.item.LectureItem;
import model.item.Tablets;
import model.rooms.*;

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

public class Game {
	private Parser parser;
	private Student student;
	private Room currentRoom;
	private HashMap<String,Lecture> listLecture;
	private ArrayList<Item> listItem;
	private Controller createur;

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game(Controller createur) {

		this.createur = createur;
		listLecture = new HashMap<String,Lecture>();
		listItem = new ArrayList<>();
		initLecture();
		initItem();
		createRooms();
		parser = new Parser();
		student = new Student();
	}

	public void initItem(){

		Book b = new model.item.Book("Objects first", createur);

		Tablets t = new Tablets(createur);

		listItem.add(b);
		listItem.add(t);

		//Item_meaning
		/*
		 * 0 = book
		 * 1 = Tablets
		 */
	}


	public void initLecture(){

		//LEcture's description is the future key of the HashMap
		Lecture l = new Lecture("POO0","Cours de POO2","POO0");
		l.setCatchStudent(true);
		l.setPOO(true);
		Lecture l2 = new Lecture("POO1","TD de POO2","POO1");
		l2.setCatchStudent(true);
		l2.setPOO(true);
		Lecture lex = new Lecture("POOEx", "POO exam","POOEx");
		lex.setCatchStudent(true);
		lex.setPOO(true);
		Lecture l3 = new Lecture("AA","TD de AA","AA");
		Lecture lec = new Lecture("T","Current lesson","T");
		Lecture lec2 = new Lecture("T2","Current lesson","T2");

		listLecture.put("POO0",l);
		listLecture.put("POO1",l2);
		listLecture.put("AA",l3);
		listLecture.put("T",lec);
		listLecture.put("T2",lec2);
		listLecture.put("POOEx",lex);

	}


	/**
	 * Create all the rooms and link their exits together.
	 */
	private void createRooms() {

		Room lab1,lab2,corridoor1,corridoor2,classroom1,classroom2,library,exam1,lunchRoom1;

		lab1 = new Lab("Lab1",listLecture.get("T"));
		lab2 = new Lab("Lab2",listLecture.get("POO0"));
		corridoor1 = new Corridor("Corridor 1");
		corridoor2 = new Corridor("Corridor 2");
		classroom1 = new Classroom("ClassRoom 1",listLecture.get("AA"));
		classroom2 = new Classroom("ClassRoom 2",listLecture.get("POO0"));
		library = new Library("Library");
		exam1 = new Exam("Exam 1",listLecture.get("POOEx"));
		lunchRoom1 = new LunchRoom("LunchRoom 1");


		corridoor1.addItem(listItem.get(0));

		//set exits
		lab1.setExit("west",lab2);
		lab2.setExit("east",lab1);
		corridoor1.setExit("north",lab1);
		corridoor1.setExit("east",classroom2);
		corridoor1.setExit("west",classroom1);
		corridoor1.setExit("south",exam1);
		corridoor2.setExit("west",library);
		corridoor2.setExit("east",classroom1);
		classroom1.setExit("west",corridoor2);
		classroom1.setExit("east",corridoor1);
		classroom2.setExit("west",corridoor1);
		classroom2.setExit("east",lunchRoom1);
		library.setExit("west",corridoor2);
		exam1.setExit("north",corridoor1);
		lunchRoom1.setExit("west",classroom2);

		//ajout d'un item
		System.out.println((Item)listItem.get(0));
		corridoor1.addItem(listItem.get(0));

		//put lectures in classrooms


		currentRoom = corridoor1; // start game corridoor 1*/
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
			checkRoom();
			command = parser.getCommand(currentRoom.getClass().getSimpleName());

		}while(!processCommand(command));
		System.out.println("Thank you for playing.  Good bye.");
	}

	private void checkRoom() {
		//Look at where we are, process to specific controls depending on which type of room we
		if(currentRoom instanceof Lab) {
			Lab room = (Lab) currentRoom;
			//if the Lab is for POO
			if (room.getLect().getCatchStudent()) {
				//if the student has the lecture for this Lab session
				if (student.hasLectureItem(room.getLect().getKey())) {
					System.out.println("You are currently in a POO Lab,\nyou must stay until the sesssion in finished");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("You are free to leave Lab is over !");
					room.getLect().setCatchStudent(false);
					student.addLabItem(listLecture.get(room.getLect().getKey()));
				}
				//don't have the required Lecture
				System.out.println("You do not have the required Lecture to do this Lab, come back when you have it !");
				room.getLect().setCatchStudent(false);
			}
			//This Lab is not for POO
			System.out.println("You can leave this Lab whenever you want !");
		}else if(currentRoom instanceof Classroom) {
			Classroom room = (Classroom)currentRoom;
			if(room.getLect().getCatchStudent()){
				System.out.println("You are currently in a POO lecture,\nyou must stay until the sesssion in finished");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("You are free to leave Lecture is over !");
				//unblock the student and add the Lecture to his LectureItem inventory !
				room.getLect().setCatchStudent(false);
				student.addLectureItem(listLecture.get(room.getLect().getKey()));
			}
			//This Lecture is not for POO
			System.out.println("You can leave this Lecture whenever you want !");
		}else if(currentRoom instanceof Exam){
			Exam room = (Exam)currentRoom;
			//if it's a POO exam
			if(room.getLect().getCatchStudent()){
				//if the student has all the POO Lab and Lectures.
				if(student.hasAllLectureLab(listLecture)){
					//if the student has enough energy
					if(student.hasEnoughEnergy(room.getEnergyNeeded())){
						//start exam
						room.showQCM();
						room.takeExam();
					}else{
						System.out.println("Sorry, you don't have enough energy to do this exam !");
					}

				}else {
					System.out.println("You don't have all the required Lab and Lectures");
				}
			}

		}
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

		//if the room is a lab, a classroom, or an exam room, it may block the player from executing commands,
		//depending on which lecture he is in. (POO lecture, or exams)
		if(currentRoom instanceof Lab) {
			Lab room = (Lab)currentRoom;
			if(room.getLect().getCatchStudent()){
				System.out.println("You can't do anything until the Lab session is not over !");
				return false;
			}
		}else if(currentRoom instanceof Classroom) {
			Classroom room = (Classroom)currentRoom;
			if(room.getLect().getCatchStudent()){
				System.out.println("You can't do anything until the Lecture session is not over !");
				return false;
			}
		}else if(currentRoom instanceof Exam){
			Exam room = (Exam)currentRoom;
			if(room.getLect().getCatchStudent()){
				System.out.println("You can't do anything until the exam session is not over !");
				return false;
			}
		}
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");

			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			CommandWords.printCommand(currentRoom.getClass().getSimpleName());
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			return quit(command);
		}else if(commandWord.equals("searchobject")){
			seeAllObjectInRoom();
		}else if(commandWord.equals("lighton")){
			((Corridor) currentRoom).switchOnLight();
		}else if(commandWord.equals("lightoff")){
			((Corridor) currentRoom).switchOffLight();
		}else if(commandWord.equals("getobject")){
			student.getItem((Item) currentRoom.getListItem().get(0));
			System.out.println("Item "+currentRoom.getListItem().get(0)+" took ");
			currentRoom.getListItem().remove(0);
		}else if(commandWord.equals("usebook")){
			student.useBook();
		}

		return wantToQuit;
	}

	private void printLocationInfo() {
		System.out.println("You are " + currentRoom.getDescription());
		System.out.println(currentRoom.toString());
		System.out.println(currentRoom.getExitString());
		System.out.println();
	}

	public void seeAllObjectInRoom(){
		ArrayList l = currentRoom.getListItem();


		for(int i = 0; i < l.size();i++){
			System.out.println("Object : "+ l.get(i)+" is here");
		}
		if(l.size() == 0){
			System.out.println("No item in this room");
		}
	}

	// implementations of user commands:

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("Your command words are:");
		System.out.println("   go quit help ");
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

	public Student getStudent(){
		return student;
	}
}