package model;

import java.util.ArrayList;

public class Student {
	private int energyLevel;
	private ArrayList<Item> listItem;

	public int getEnergyLevel() {
		return energyLevel;
	}

	public ArrayList<Item> getListItem() {
		return listItem;
	}

	public Student(){
		energyLevel = 100;
		listItem = new ArrayList<Item>();
	}
	
	public void getItem(Item item){
		listItem.add(item);
	}
	public void deleteItem(Item delete){
		listItem.remove(delete);
	}
	
	public void increaseEnergy(int number) {
		energyLevel+=number;
	}
	
	public void printOwnItem(){
		if(listItem.size() == 0 ) System.out.println("Aucun item poss�d�");
		
		for(int i = 0 ; i < listItem.size(); i++){
			System.out.println("Item "+(i+1)+" : "+listItem.get(i).toString());
		}
	}
	
	@Override
	public String toString() {
		String str ="";
		str+="I'm a student, i've "+listItem.size()+" with me, i have "+energyLevel+" left\n";
		return str;
	}
	
	@Override
	public boolean equals(Object st) {
		Student student;
		
		if(st instanceof Student){
			student = (Student) st;
		}else{
			return false;
		}
		
		
		if(energyLevel == student.energyLevel && listItem.equals(student.listItem)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student st = new Student();
		st.listItem = listItem;
		return st;
	}
	
	
	public void decreasedEnergy(int number) {	
		energyLevel-=number;
	}
}