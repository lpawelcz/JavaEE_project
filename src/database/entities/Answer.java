package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	//@Column(name = "questionID")
	//private int questionID;

	public Answer(String answer) {
		this.answer = answer;
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
	@Override
	public String toString() {
		return "Answer [asnwerID=" + answerID + ", answer=" + answer + "]";
	}
}
