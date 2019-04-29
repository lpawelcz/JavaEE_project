package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {
	
	public Question(User author, String question) {
		this.author = author;
		this.question = question;
	}
	public Question() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "questionID")
	private int questionID;
	
	@ManyToOne
	@Column(name = "userID")
	private User author;
	
	
	@Column(name = "question")
	private String question;
	
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", author=" + author + ", question=" + question
				+ "]";
	}
}
