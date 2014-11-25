package model;

import model.rooms.Exam;

import java.util.ArrayList;

public class QCM {
	private int mark;
	private ArrayList<Question> questions;
	//Chargement d'ancienne questions afin de remplir questions al�atoirement ? � voir !
	private ArrayList<Question> old_questions;
	private Exam createur;
	private static int MARK_BY_GOOD_ANSWER = 1;


	/**
	 * Constructeur par d�faut,
	 * Il initialise un QCM de 20 questions par d�faut et d'une mark de 0
	 *   afin de tester une class QCM
	 * 
	 */
	public QCM(){
		mark = 0;
		questions = new ArrayList<Question>();


		for(int i = 0 ; i < 20 ; i++){ 
			Question q = new Question();
			questions.add(q);
		}
		createur = null;
	}

	/**
	 * Contructeur normal,
	 * Il instancie un QCM avec les op�randes 
	 * 
	 * @param questions liste des questions du QCM
	 * @param createur hame�on
	 */
	public QCM(ArrayList<Question> questions, Exam createur){
		this.questions = questions;
		this.createur = createur;
	}
	/**
	 * M�thode calculateMark,
	 * Elle compte la note du QCM en v�rifiant la validit� de chaque question r�pondue
	 */
	public void calculateMark(){
		resetMark();
		for(int i = 0 ; i < questions.size() ; i++){
			if(questions.get(i).isCorrect()) {
				mark+= MARK_BY_GOOD_ANSWER;
			}
		}
	}


	/**
	 * M�thode resetMark,
	 * Elle remet � 0 la note du QCM, afin de recalculer les points
	 */
	public void resetMark(){mark = 0;}
	/*
	 * 
	 * 
	 * Getter & Setter
	 * 
	 * 
	 */

	/**
	 * Getter de la note du QCM
	 * @return la note
	 */
	public int getMark() {return this.mark;}

	/**
	 * Getter du nombre de question total dans le qcm
	 * @return le nombre de question
	 */
	public int getNumberQuestions(){return questions.size();}

	/**
	 * Getter des questions du QCM
	 * @return toutes les questions
	 */
	public ArrayList<Question> getQuestions(){return questions;}

	public void goodAnwser() {
		throw new UnsupportedOperationException();
	}

	public void badAnwser() {
		throw new UnsupportedOperationException();
	}
}