package model.rooms;

public class Corridor extends Room {

	private boolean ligthState;


	public Corridor(String description) {
		super(description);
		ligthState = false;
	}

	public void switchOnLight() {
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
	}
}