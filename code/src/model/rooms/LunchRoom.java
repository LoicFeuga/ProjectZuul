package model.rooms;

import model.Student;
import model.item.Item;
import model.item.LectureItem;

import java.util.ArrayList;

public class LunchRoom extends Room {

	public LunchRoom(String description) {
		super(description);
	}

	public void drinkCoffee(Student stud) {
		stud.increaseEnergy(50);
	}

	public void playingTableFootball(Student stud) {
		int rand = 0 + (int)(Math.random() * ((1 - 0) + 1));

		if(rand == 0){
			System.out.println("You are playing babyfoot !");
			rand = 0 + (int)(Math.random() * ((1 - stud.getListLecture().size()) + 1));
			LectureItem it = stud.getListLecture().remove(rand);
			System.out.println("You forgot the Lecture: "+it.getLectureKey());
		}
	}

}