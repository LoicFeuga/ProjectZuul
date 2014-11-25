package model.rooms;

public class Lecture extends Room {

	private String currentLecture;
	private boolean catchStudent;


	public Lecture(String description) {
		super(description);
		// TODO Auto-generated constructor stub
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
}