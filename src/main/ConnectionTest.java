package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Database.User;



public class ConnectionTest {

	public static void main(String[] args) {

		
//----INSERTING DATA---------------------------------//
//		SessionFactory factory = new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(User.class)
//				.buildSessionFactory();
//		
//		Session session = factory.getCurrentSession();
//		
//		try {
//			System.out.println("creating new user object");
//			User tempUser = new User("asdf","asdf");
//
//			session.beginTransaction();
//			System.out.println("saving user object");
//			session.save(tempUser);	
//			session.getTransaction().commit();
//			
//			System.out.println("done");
//		} finally {
//			factory.close();
//		}
//----INSERTING DATA---------------------------------//	
		
		
		
		
		
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating new user object");
			User tempUser1 = new User("us1","us1");
			User tempUser2 = new User("us2","us2");
			User tempUser3 = new User("us3","us3");

			session.beginTransaction();
			
			System.out.println("saving user object");
			session.save(tempUser1);	
			session.save(tempUser2);	
			session.save(tempUser3);	
			
			session.getTransaction().commit();
			
			System.out.println("done");
		} finally {
			factory.close();
		}
		
		
		
		
		
	}

}
