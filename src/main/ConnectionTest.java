package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Database.User;



public class ConnectionTest {

	public static void main(String[] args) {

		
//----INSERTING DATA---------------------------------//
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating new user object");
			User tempUser = new User("user","user");

			session.beginTransaction();
			System.out.println("saving user object");
			session.save(tempUser);	
			session.getTransaction().commit();
			
			System.out.println("done");
		} finally {
			factory.close();
		}
//----INSERTING DATA---------------------------------//	
		
		
		
//		String jdbcUrl = "jdbc:mysql://localhost:3306?serverTimezone=UTC";
//		String user= "root";
//		String pass= "admin";
//		
//		try {
//			System.out.println("Connecting to database: " + jdbcUrl);
//			
//			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
//			
//			System.out.println("Connection succesful");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
	}

}
