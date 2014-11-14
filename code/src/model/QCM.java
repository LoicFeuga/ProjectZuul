package model;

import java.util.ArrayList;

public class QCM {
	private int mark;
	private ArrayList<Question> questions;
	private Exam createur;

	public int getMark() {
		return this.mark;
	}

	public void goodAnwser() {
		throw new UnsupportedOperationException();
	}

	public void badAnwser() {
		throw new UnsupportedOperationException();
	}
}