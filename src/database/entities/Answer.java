package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "answerID")
	private int answerID;
	
	@Column(name = "answer")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "questionID")
	private Question question;

	public Answer(String answer, Question question) {
		this.answer = answer;
		this.question = question;
		//this.answerID = ID;
	}
	public Answer() {}
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [answerID=" + answerID + ", answer=" + answer + "]";
	}
}
