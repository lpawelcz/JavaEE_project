package Database;
import javax.persistence.*;

//@Entity
//@Table(name = "User")
public class User {
	
	private int userID;
	private String name;
	private String password;

//	public User(String name, String password) {
//		super();
//		this.name = name;
//		this.password = password;
//	}

//	@Id
//	@Column(name = "userID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
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
}
