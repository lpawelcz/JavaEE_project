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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
public class Test {
	
	
	public Test(User author, List<Opinion> opinions, List<Question> questions, Description description,
			boolean isPublic) {
		this.author = author;
		this.opinions = opinions;
		this.questions = questions;
		this.description = description;
		this.isPublic = isPublic;
	}
	public Test() {}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "testID")
	private int testID;
	
	@ManyToOne
	@Column(name = "userID")
	private User author;
	
	@OneToMany(mappedBy = "opinionID")
    private List<Opinion> opinions = new ArrayList<Opinion>();
	
	@OneToMany
	@JoinColumn(name = "questionID")
    private List<Question> questions = new ArrayList<Question>();
	
	@OneToOne
	@Column(name = "descriptionID")
	private Description description;
	
	@Column(name = "isPublic")
	private boolean isPublic;
	
	
	
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public List<Opinion> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	@Override
	public String toString() {
		return "Test [testID=" + testID + ", author=" + author + ", opinions=" + opinions + ", questions=" + questions
				+ ", description=" + description + ", isPublic=" + isPublic + "]";
	}
}
