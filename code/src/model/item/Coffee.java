package model;

import model.rooms.Room;

/**
 * Class Coffee, 
 * 
 * @author loic
 *
 */
public class Coffee extends Item {
	private int energy;
	
	public Coffee(Student student, Room where){
		super.owner = student;
		super.position = where;
		energy = 50;
	}
	
	/**
	 * Méthode drink, elle octroie le nombre d'energy du coffee 
	 *   au possesseur du coffee
	 */
	public void drink() {
		if(owner != null){
			System.out.println("Drinkin");
			owner.increaseEnergy(energy);
			owner.deleteItem(this);
			owner = null;
			position = null;
			energy = 0;
			System.out.println("Coffee drank");
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Coffee coffee = new Coffee(owner, position);
		return coffee;
	}
	
	@Override
	public String toString() {
		String str = "Coffee, if you drink me you will obtain "+energy+" energy\n";
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		Coffee item = null;
		if(obj instanceof Coffee){
			item = (Coffee) obj;
		}else{
			return false;
		}
		if(owner.equals(item.owner) && position.equals(item.position) && energy == item.energy){
			return true;
		}else{
			return false;
		}

	}
	

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

}