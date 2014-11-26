package model.rooms;
import model.item.Item;

import java.util.ArrayList;

public class Lecture extends Room {

	private String currentLecture;
	private boolean catchStudent;

	public Lecture(String description) {
		super(description);
	}

	public Lecture(String description,String current) {
		super(description);
		this.currentLecture = current;
		this.catchStudent = false;
	}

	public Lecture(String description,String current,boolean canCatch) {
		super(description);
		this.currentLecture = current;
		this.catchStudent = canCatch;
	}

	public boolean getCatchStudent() {
		return this.catchStudent;
	}

	public void setCatchStudent(boolean catchStudent) {
		this.catchStudent = catchStudent;
	}

	public String getCurrentLecture() {
		return this.currentLecture;
	}

	public void setCurrentLecture(String currentLecture) {
		this.currentLecture = currentLecture;
	}

	@Override
	public String toString() {
		String str = "Lecture : "+currentLecture;
		return str;
	}

}