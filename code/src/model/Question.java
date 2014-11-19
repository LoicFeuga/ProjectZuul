package model;
/**
 * Class Question,
 * 
 * Elle contient tous les élèments du question qui sera contenu 
 *  dans un QCM
 *  
 * @author loic
 *
 */
public class Question {
	/**
	 * Réponse à la question posée, vaut true ou false
	 */
	private boolean answer;
	/**
	 * Question qui sera posé au Student
	 */
	private String question;
	/**
	 * Hameçonage sur le QCM contenant cette question
	 */
	private QCM createur;
	/**
	 * Réponse du Student à cette question
	 */
	private boolean answerGave;
	
	/**
	 * Constructeur par defaut,
	 * Il initialise une question simple afin de tester la classe
	 */
	public Question(){
		question = "La réponse est-elle true ? ";
		createur = null;
		answer = true;
	}

	/**
	 * Contructeur par défaut,
	 * Il intialise une question simple afin de tester son appartenance à un QCM
	 * @param createur
	 */
	public Question(QCM createur){
		question = "La réponse est-elle true ? ";
		this.createur = createur;
		answer = true;
	}

	/**
	 * Constructeur normal
	 * 
	 * @param answer contient true ou false, qui est la réponse à la question
	 * @param question contient la question à poser 
	 * @param createur hameçon
	 */
	public Question(boolean answer, String question, QCM createur){
		this.question = question;
		this.createur = createur;
		this.answer = answer;
	}


	/**
	 * Méthode clone, renvoyant une Question identique à elle même
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Question q1 = new Question(this.answer,this.question,this.createur);
		return q1;
	}

	/**
	 * Méthode equals, retourne 
	 * true si :
	 * 		- les string des questions sont identiques
	 * 		- les réponses sont identiques
	 * false sinon
	 */
	@Override
	public boolean equals(Object q1) {
		if (!(q1 instanceof Question)) return false;
		
		Question q = (Question) q1;
		
		if(  this.question.equals(q.getQuestion())  && this.answer == q.answer)
			return true;
		else
			return false;
	}
	
	
	/**
	 * Méthode answer,
	 * Elle permet de répondre à la question posée
	 * @param answer réponse à la question
	 */
	public void answer(boolean myanswer){
		this.answerGave = myanswer;
	}

	/**
	 * Méthode isCorrect,
	 * Elle vérifie si la réponse donnée correspond bien à la réponse de la question
	 * @return true si correct 
	 * 			else sinon
	 */
	public boolean isCorrect(){
		if(answerGave == answer){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * 
	 * 
	 * Getter & Setter
	 * 
	 * 
	 */



	/**
	 * Getter du contenu de la question
	 * @return la question
	 */
	public String getQuestion() {return this.question;}

	/**
	 * Getter de la réponse correspondante à la question
	 * @return la réponse
	 */
	public boolean getAnswer() {return this.answer;	}


}