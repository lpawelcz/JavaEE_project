package Database;
import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@Column(name = "userID")
	private int userID;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;

//	public User(String name, String password) {
//		super();
//		this.name = name;
//		this.password = password;
//	}

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
