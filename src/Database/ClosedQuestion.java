package Database;

public class ClosedQuestion extends Question {

	public ClosedQuestion() {
		super();
		answers = new Answer[4];
	}
	
	private Answer[] answers;
	private int correctID;
	
	public Answer[] getAnswers() {
		return answers;
	}
	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}
	public int getCorrectID() {
		return correctID;
	}
	public void setCorrectID(int correctID) {
		this.correctID = correctID;
	}

}
