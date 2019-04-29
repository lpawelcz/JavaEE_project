package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Opinion")
public class Opinion {
	
	public Opinion(User author, Test test, String opinion, float rate) {
		this.author = author;
		this.test = test;
		this.opinion = opinion;
		this.rate = rate;
	}
	
	public Opinion() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "opinionID")
	private int opinionID;
	
	@ManyToOne
	@Column(name = "userID")
	private User author;
	
	@ManyToOne
	@Column(name = "testID")
	private Test test;
	
	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "rate")
	private float rate;
	
	public int getOpinionID() {
		return opinionID;
	}
	public void setOpinionID(int opinionID) {
		this.opinionID = opinionID;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "Opinion [opinionID=" + opinionID + ", author=" + author + ", test=" + test + ", opinion=" + opinion
				+ ", rate=" + rate + "]";
	}


}
