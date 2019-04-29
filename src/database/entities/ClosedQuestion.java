package database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class ClosedQuestion extends Question {

	public ClosedQuestion(User author, String question, List<Answer> answers, int correctID) {
		super(author, question);
		this.answers = answers;
		this.correctID = correctID;
	}
	public ClosedQuestion() {}
	
	@OneToMany
	@JoinColumn(name = "answerID")
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
	
	@Override
	public String toString() {
		return "ClosedQuestion [answers=" + answers + ", correctID=" + correctID + "]";
	}

}
