package controler;

import java.util.HashMap;

import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant hash that holds all valid command words for each rooms

    private static HashMap<String,String[]> listCommRooms;
    private static final String[] CLASSROOM = {
            "go", "quit","searchobject", "help"
    };
    private static final String[] LAB = {
            "go", "quit","searchobject", "help"
    };
    private static final String[] EXAM = {
            "go", "quit","searchobject", "help", "cheat"
    };
    private static final String[] CORRIDOOR = {
            "go", "quit","searchobject","getobject","usebook","lighton","lightoff", "help"
    };
    private static final String[] LUNCHROOM = {
            "go", "quit","searchobject", "help", "drink"
    };
    private static final String[] LIBRARY = {
            "go", "quit","searchobject", "help", "read"
    };
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        listCommRooms = new HashMap<>();
        listCommRooms.put("Classroom",CLASSROOM);
        listCommRooms.put("Lab",LAB);
        listCommRooms.put("Exam",EXAM);
        listCommRooms.put("Corridor",CORRIDOOR);
        listCommRooms.put("LunchRoom",LUNCHROOM);
        listCommRooms.put("Library",LIBRARY);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString, String room)
    {
        for(int i = 0; i < listCommRooms.get(room).length; i++) {
            if(listCommRooms.get(room)[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    public static void printCommand(String room){
    	for(int i = 0 ; i <  listCommRooms.get(room).length;i++){
    		if(i!=0){
    			System.out.print(", ");
    		}
    		System.out.print( listCommRooms.get(room)[i]+ "");
    	}
    	System.out.println("");
    }
}
