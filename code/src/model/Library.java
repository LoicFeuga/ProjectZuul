package model;

import java.util.Date;

public class Library extends Room {

	private Date timeOpen;
	private Date timeClose;

	

	public Library(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void readBook() {
		throw new UnsupportedOperationException();
	}

	public void setOpenCloseTime() {
		throw new UnsupportedOperationException();
	}
}