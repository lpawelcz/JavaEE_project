package Database;

public class OpenQuestion extends Question {

	public OpenQuestion() {
		super();
	}
	private Answer answer;
	
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
