package dao;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import sqlParser.*;
import Database.*;

public class DAO_User implements DAO<User> {
		private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/blog";
		private final static String DBUSER = "root";
		private final static String DBPASS = "****";
		private final static String DBDRIVER = "com.mysql.jdbc.Driver";
	
		private Connection connection;
		private Statement statement;
		private String query;
		private SQLUserParser sqlUserParser;
		
		public DAO_User() {
			super();
			sqlUserParser = new SQLUserParser();
		}
		
	    private List<User> users = new ArrayList<>();
	     
	//    public void UserDao() {
	//        users.add(new User("admin", "admin"));
	//        users.add(new User("user", "user"));
	//    }
	     
	    @Override
	    public Optional<User> get(long id) {
	        return Optional.ofNullable(users.get((int) id));
	    }
	     
	    @Override
	    public List<User> getAll() {
	        return users;
	    }
	     
	    @Override
	    public void save(User user) {
	        users.add(user);
	    }
	     
	    @Override
	    public void update(User user, String[] params) {
	        user.setName(Objects.requireNonNull( params[0], "Name cannot be null"));
	        user.setPassword(Objects.requireNonNull(params[1], "Password cannot be null"));
	        user.setuserID(users.size()+1);
	         
	        users.add(user);
	    }
	     
	    @Override
	    public void delete(User user) {
	        users.remove(user);
	    }
	}