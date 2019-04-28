package sqlParser;
import Database.*;

public class SQLUserParser {

	public String createSaveQuery(User user) {
		String query = "";

		query = "INSERT INTO USER VALUES ( '" + user.getuserID() + "' , '" + user.getName() + "', '" + user.getPassword() +"');";

		return query;
	}
	
	public String createLoadQuery(User user) {
		String query = "";

		query = "INSERT INTO USER VALUES ( '" + user.getuserID() + "' , '" + user.getName() + "', '" + user.getPassword() +"');";

		return query;
	}
}
