package model;
/**
 * @author loic
 */
import java.util.ArrayList;
import java.util.HashMap;

import model.item.LabItem;
import model.item.LectureItem;
import model.rooms.Lecture;
import model.item.Book;
import model.item.Item;
import model.rooms.Lecture;

public class Student {

	private int energyLevel;
	private ArrayList<Item> listItem;
	private ArrayList<LectureItem> listLecture;
	private ArrayList<LabItem> listLab;

	public int getEnergyLevel() {
		return energyLevel;
	}

	public ArrayList<Item> getListItem() {
		return listItem;
	}

	public ArrayList<LectureItem> getListLecture(){
		return listLecture;
	}

	public ArrayList<LabItem> getListLab(){
		return listLab;
	}

	public Student(){
		energyLevel = 100;
		listItem = new ArrayList<Item>();
		listLecture = new ArrayList<>();
		listLab = new ArrayList<>();
	}

	public void getItem(Item item){
		listItem.add(item);
	}
	public void deleteItem(Item delete){
		listItem.remove(delete);
	}

	public void addLectureItem(Lecture lecture){
		listLecture.add(new LectureItem(lecture.getDescription()));
	}
	public boolean hasLectureItem(String key){
		for(int i = 0; i< listLecture.size();i++){
			if(listLecture.get(i).getLectureKey().equals(key)){
				return true;
			}
		}
		return false;
	}
	public void removeLectureItem(Lecture lecture){
		listLecture.remove(lecture.getDescription());
	}

	public void addLabItem(Lecture lect){
		listLab.add(new LabItem(lect.getKey()));
	}
	public void removeLabItem(Lecture lect){
		listLab.remove(lect.getDescription());
	}

	public void increaseEnergy(int number) {
		energyLevel+=number;
	}
	public void DecreaseEnergy(int number) {
		energyLevel-=number;
	}

	public boolean hasAllLectureLab(HashMap<String,Lecture> listLect){
		boolean check = false;

		for (HashMap.Entry<String, Lecture> entry : listLect.entrySet()) {
			if(entry.getValue().isPOO()) {
				for (int i = 0; i < listLecture.size(); i++) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					if (listLecture.get(i).getLectureKey().equals(entry.getKey()) && listLab.get(i).getLectureKey().equals(entry.getKey())) {
						check = true;
					}
				}
				if (!check) return false;
			}
		}
		return true;
	}

	public boolean hasEnoughEnergy(int energNeeded) {
		if(this.energyLevel >= energNeeded){
			return  true;
		}else{
			return false;
		}
	}

	public void printOwnItem(){
		if(listItem.size() == 0 ) System.out.println("Aucun item possédé");

		for(int i = 0 ; i < listItem.size(); i++){
			System.out.println("Item "+(i+1)+" : "+listItem.get(i).toString());
		}
	}

	public void printLectureFollowed(){
		if(listLecture.size() == 0 ) System.out.println("Aucune leçon suivie à ce jour");

		for(int i = 0 ; i < listLecture.size(); i++){
			System.out.println("Lecture"+(i+1)+" : "+listLecture.get(i).toString());
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

	public void useBook(Student stud, HashMap<String, Lecture> listLecture){
		for(int i = 0; i < listItem.size();i++){
			if(listItem.get(i) instanceof Book){
				((Book)listItem.get(i)).read(stud,listLecture);
			}
		}
	}


	public void followAllLectures(Student stud, HashMap<String, Lecture> listLect) {

		for (HashMap.Entry<String, Lecture> entry : listLect.entrySet()) {
			if (entry.getValue().isPOO()) {
				for (int i = 0; i < listLecture.size(); i++) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					//if the student doesn't have this POO lecture
					if (!listLecture.get(i).getLectureKey().equals(entry.getKey())) {
						//we add it
						listLecture.add(new LectureItem(entry.getKey()));
					}
				}
			}
		}
	}

	public void followLectureOrLab(Student stud, HashMap<String, Lecture> listLect) {

		boolean added= false;

		loop: for (HashMap.Entry<String, Lecture> entry : listLect.entrySet()) {
			if (entry.getValue().isPOO()) {
				for (int i = 0; i < listLecture.size(); i++) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					//if the student doesn't have this POO lecture
					if (!listLecture.get(i).getLectureKey().equals(entry.getKey())) {
						//we add it
						listLecture.add(new LectureItem(entry.getKey()));
						break loop;
					}
				}
				System.out.println("Lecture added");
			}
		}
	}
}