package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class OpenQuestion extends Question {

	public OpenQuestion(User author, String question, Answer answer) {
		super(author, question);
		this.answer = answer;
	}
	public OpenQuestion() {
	}
	
	@OneToOne
	@Column(name = "answerID")
	private Answer answer;
	
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "OpenQuestion [answer=" + answer + "]";
	}
}
