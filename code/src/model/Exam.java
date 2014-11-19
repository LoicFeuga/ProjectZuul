package model;

import java.util.Scanner;

public class Exam extends Lecture {
	private int energyNeeded;
	private QCM qcm;
	private Scanner sc;
	
	/**
	 * Constructeur par défaut,
	 * Il instancie un Exam d'une série de 20 questions simple
	 *   ainsi qu'une energyNeeded à 0
	 * Il permet de tester la class Exam et les liaisons qu'il y a avec 
	 *   QCM et question
	 */
	public Exam(){
		energyNeeded = 0;
		qcm = new QCM();
	}
	
	/**
	 * Constructeur normal,
	 * Il instancie un Exam
	 * @param energyNeeded Energie minimum pour passer l'examene
	 * @param qcm qcm de l'examen
	 */
	public Exam(int energyNeeded, QCM qcm){
		this.energyNeeded = energyNeeded;
		this.qcm = qcm;
	}
	
	/**
	 * Méthode showQCM,
	 * Montre le qcm dans son intégralité sans les réponses aux questions
	 */
	public void showQCM(){
		System.out.println("QCM :");
		for(int i = 0 ; i < qcm.getNumberQuestions() ; i++){
			System.out.println("Question ("+(i+1)+") : "+qcm.getQuestions().get(i).getQuestion());
		}
	}
	
	public void printQuestion(int number){
		System.out.println(qcm.getQuestions().get(number).getQuestion());
	}
	
	public void takeExam() {
		sc = new Scanner(System.in);
		
		for(int i = 0 ; i < qcm.getNumberQuestions() ; i++){
			printQuestion(i);
			System.out.print("Votre réponse : ");
			String reponse = sc.nextLine();
			answerTo(i,answerStringToBoolean(reponse));
		}
		
		qcm.calculateMark();
		System.out.println("Calcule de votre note ...");
		System.out.print("Vous avez : "+qcm.getMark());
		
	}
	
	public void answerTo(int number, boolean answer){
		qcm.getQuestions().get(number).answer(answer);
	}
	
	public boolean answerStringToBoolean(String answer){
		if(answer.contains("u")){
			return true;
		}
		else {
			return false;
		}
	}
}