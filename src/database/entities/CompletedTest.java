package database.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CompletedTest")
public class CompletedTest {
	
	public CompletedTest(User user, Test test, Result result) {
		this.user = user;
		this.test = test;
		this.result = result;
	}
	public CompletedTest() {}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "completedtestID")
	private int completedtestID;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "testID")
	private Test test;
	
	@OneToOne
	@JoinColumn(name = "resultID")
	private Result result;
	
	
	public int getCompletedtestID() {
		return completedtestID;
	}
	public void setCompletedtestID(int completedtestID) {
		this.completedtestID = completedtestID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "CompletedTest [completedtestID=" + completedtestID + ", user=" + user + ", test=" + test + ", result="
				+ result + "]";
	}
	
}
