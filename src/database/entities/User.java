package database.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userID")
	private int userID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "opinionID")
    private List<Opinion> opinions = new ArrayList<Opinion>();
	
	@OneToMany(mappedBy = "completedtestID")
    private List<CompletedTest> completedtests = new ArrayList<CompletedTest>();
	
	@OneToMany(mappedBy = "questionID")
    private List<Question> questions = new ArrayList<Question>();
	
	public User() {}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public List<Opinion> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}
	public int getuserID(){
		return userID;
	}
	public void setuserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", password=" + password + ", opinions=" + opinions
				+ ", completedtests=" + completedtests + ", questions=" + questions + "]";
	}

}
