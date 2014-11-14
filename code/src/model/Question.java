package model;
/**
 * Class Question,
 * 
 * Elle contient tous les �l�ments du question qui sera contenu 
 *  dans un QCM
 *  
 * @author loic
 *
 */
public class Question {
	/**
	 * R�ponse � la question pos�e, vaut true ou false
	 */
	private boolean answer;
	/**
	 * Question qui sera pos� au Student
	 */
	private String question;
	/**
	 * Hame�onage sur le QCM contenant cette question
	 */
	private QCM createur;

	/**
	 * Constructeur par defaut,
	 * Il initialise une question simple afin de tester la classe
	 */
	public Question(){
		question = "La r�ponse est-elle true ? ";
		createur = null;
		answer = true;
	}

	/**
	 * Contructeur par d�faut,
	 * Il intialise une question simple afin de tester son appartenance � un QCM
	 * @param createur
	 */
	public Question(QCM createur){
		question = "La r�ponse est-elle true ? ";
		this.createur = createur;
		answer = true;
	}

	/**
	 * Constructeur normal
	 * 
	 * @param answer contient true ou false, qui est la r�ponse � la question
	 * @param question contient la question � poser 
	 * @param createur hame�on
	 */
	public Question(boolean answer, String question, QCM createur){
		this.question = question;
		this.createur = createur;
		this.answer = answer;
	}


	/**
	 * M�thode clone, renvoyant une Question identique � elle m�me
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Question q1 = new Question(this.answer,this.question,this.createur);
		return q1;
	}

	/**
	 * M�thode equals, retourne 
	 * true si :
	 * 		- les string des questions sont identiques
	 * 		- les r�ponses sont identiques
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
	 * Getter de la r�ponse correspondante � la question
	 * @return la r�ponse
	 */
	public boolean getAnswer() {return this.answer;	}


}