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
@Table(name = "QuestionInTest")
public class QuestionInTest {
	
	public QuestionInTest(Test test, Question question) {
		this.test = test;
		this.question = question;
	}
	public QuestionInTest() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "questionintestID")
	private int questionintestID;
	
	@ManyToOne
	@JoinColumn(name = "testID")
	private Test test;
	
	@ManyToOne
	@JoinColumn(name = "questionID")
	private Question question;
	
	public int getQuestionintestID() {
		return questionintestID;
	}
	public void setQuestionintestID(int questionintestID) {
		this.questionintestID = questionintestID;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "QuestionInTest [questionintestID=" + questionintestID + ", testID=" + test.getTestID() + ", questionID="+ question.getQuestionID() + "]";
	}
	
	
	

}
