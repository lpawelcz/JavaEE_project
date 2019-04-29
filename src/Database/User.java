package Database;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public User() {}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
		return "User [userID=" + userID + ", name=" + name + ", password=" + password + "]";
	}
	
}
