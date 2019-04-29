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
	
	public Answer(String answer) {
		this.answer = answer;
	}
	public Answer() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "asnwerID")
	private int asnwerID;
	
	@Column(name = "answer")
	private String answer;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [asnwerID=" + asnwerID + ", answer=" + answer + "]";
	}
}
