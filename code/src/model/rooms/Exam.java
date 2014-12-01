package model.rooms;

import model.QCM;
import model.Question;
import model.rooms.Lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam extends Room  {

	private Lecture lect;
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
	public Exam(String nom, Lecture lect){
		super(nom);
		energyNeeded = 0;
		//qcm = new QCM();
		ArrayList questions = new ArrayList<Question>();
		
		questions.add(new Question(false, "A class can be transient ? ", qcm));
		questions.add(new Question(true, "Methods that are marked protected can be called in any subclass of that class ? ", qcm));
		questions.add(new Question(true, " An abstract class can have non-abstract methods ? ", qcm));
		questions.add(new Question(false, "Java keywords are written in lowercase as well as uppercase ? ", qcm));
		questions.add(new Question(true, "Primitive datatypes are allocated on a stack ? ", qcm));
		questions.add(new Question(false, "Can you compare a boolean to an integer ? ", qcm));
		questions.add(new Question(true, "The methods wait(), notify() and notifyAll() in Object need to be called from synchronized pieces of code ? ", qcm));
		questions.add(new Question(true, "Inner classes can be defined within methods ? ", qcm));
		questions.add(new Question(false, "The modulus operator (%) in Java can be used only with variables of integer type ? ", qcm));
		questions.add(new Question(false, "Declarations must appear at the start of the body of a Java method ? ", qcm));
		
		
		qcm = new QCM(questions, this);
		this.lect= lect;
	}
	
	/**
	 * Constructeur normal,
	 * Il instancie un Exam
	 * @param energyNeeded Energie minimum pour passer l'examene
	 * @param qcm qcm de l'examen
	 */
	public Exam(int energyNeeded, QCM qcm,String nom, Lecture lect){
		super(nom);
		this.energyNeeded = energyNeeded;
		this.qcm = qcm;
		this.lect= lect;
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
			System.out.print("Your answer (true or false) : ");
			String reponse = sc.nextLine();
			answerTo(i,answerStringToBoolean(reponse));
		}
		
		qcm.calculateMark();
		System.out.println("Your mark calculating ...");
		System.out.print("You have: "+qcm.getMark());
		
		if(qcm.getMark() >= 10){
			System.out.println("#########################");
			System.out.println("#########################");
			System.out.println("#########################");
			System.out.println("#########################");
			System.out.println("Congratulation !!");
			System.out.println("#########################");
			System.out.println("#########################");
			System.out.println("#########################");
			System.out.println("#########################");
		}
		
	}
	
	public void answerTo(int number, boolean answer){
		qcm.getQuestions().get(number).answer(answer);
	}
	
	public boolean answerStringToBoolean(String answer){
		if(answer.contains("true")){
			return true;
		}
		else {
			return false;
		}
	}

	public Lecture getLect() {
		return lect;
	}

	public void setLect(Lecture lect) {
		this.lect = lect;
	}

	public int getEnergyNeeded() {
		return energyNeeded;
	}
}