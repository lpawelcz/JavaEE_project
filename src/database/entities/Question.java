package database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	public Question(int DTYPE, User author, String question, List<Answer> answers, int correctID) {
		this.DTYPE = DTYPE;
		this.author = author;
		this.question = question;
		this.answers = answers;
		this.correctID = correctID;
	}
	public Question() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "questionID")
	private int questionID;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	private User author;
	
	@Column(name = "DTYPE")
	private int DTYPE;
	
	@Column(name = "question")
	private String question;
	
	@OneToMany(mappedBy = "answerID")
	private List<Answer> answers = new ArrayList<Answer>();
	
	private int correctID;
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public int getCorrectID() {
		return correctID;
	}
	public void setCorrectID(int correctID) {
		this.correctID = correctID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public int getDTYPE() {
		return DTYPE;
	}
	public void setDTYPE(int DTYPE) {
		this.DTYPE = DTYPE;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", author=" + author.getName() + ", question=" + question + ", answers="
				+ answers + ", correctID=" + correctID+ ", DTYPE=" + DTYPE + "]";
	}
	
}
