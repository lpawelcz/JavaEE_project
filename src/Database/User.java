package Database;

public class User {
	
	private int userID;
	private String name;
	private String password;

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
