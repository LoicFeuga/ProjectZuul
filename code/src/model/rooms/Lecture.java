package model.rooms;

import model.item.LectureItem;

public class Lecture extends Room {

	private String currentLecture;
	private String key;
	private boolean isPOO;
	private boolean catchStudent;

	public Lecture(String description) {
		super(description);
	}

	public Lecture(String description,String current,String key) {
		super(description);
		this.key = key;
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

	public String getKey() {
		return key;
	}

	public void setPOO(boolean isPOO) {
		this.isPOO = isPOO;
	}

	public boolean isPOO() {
		return isPOO;
	}

	@Override
	public String toString() {
		String str = "Lecture : "+currentLecture;
		return str;
	}

}