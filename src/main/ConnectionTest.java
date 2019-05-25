package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Manage.ManageUser;
import Manage.ManageTest;
import database.entities.User;



public class ConnectionTest {

	public static void main(String[] args) {
		
		ManageUser userManager = new ManageUser();
//		userManager.InsertUser("pierwszy", "12234123");
//		userManager.InsertUser("John", "12234123");
//		userManager.InsertUser("asdf", "12234123");
//		userManager.InsertUser("eee", "12234123");
//		userManager.InsertUser("tyty", "12234123");
//		userManager.InsertUser("tytyt", "12234123");
//		userManager.InsertUser("qwerty", "12234123");
//		userManager.InsertUser("asdfgh", "12234123");
//		userManager.InsertUser("TestAuthor", "TestAuthor_pass");
//		userManager.ListUser();
//		User TestAuthor1 = userManager.GetUser("TestAuthor");
//		User TestAuthor2 = userManager.GetUser(47);
//		User TestAuthor3 = userManager.GetUser("eee");
//		User TestAuthor4 = userManager.GetUser(50);
		
		ManageTest testManager = new ManageTest();
		
//		testManager.InsertTest(TestAuthor1, true);
//		testManager.InsertTest(TestAuthor1, false);
//		testManager.InsertTest(TestAuthor2, true);
//		testManager.InsertTest(TestAuthor2, true);
//		testManager.InsertTest(TestAuthor2, false);		
//		testManager.InsertTest(TestAuthor3, false);
//		testManager.InsertTest(TestAuthor3, false);
//		testManager.InsertTest(TestAuthor3, false);
//		testManager.InsertTest(TestAuthor4, true);
//		testManager.InsertTest(TestAuthor4, true);
		
		testManager.ListTest();
		
		System.out.println("testy TestAuthora, po ID");
		testManager.ListUserTests(55);
		
		System.out.println("testy eee, po loginie");
		testManager.ListUserTests("eee");
		
		
		
		
		
//		userManager.InsertUser("eee", "12234123");
//		userManager.ListUser();
//		userManager.DeleteUser(8);	// asdf asdf
//		userManager.UpdateUser(1, "dupa");
//		userManager.ListUser();
		

		
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
	
		
//----INSERTING MULTIPLE DATA------------------------//			
//		SessionFactory factory = new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(User.class)
//				.buildSessionFactory();
//		
//		Session session = factory.getCurrentSession();
//		
//		try {
//			System.out.println("creating new user object");
//			User tempUser1 = new User("us1","us1");
//			User tempUser2 = new User("us2","us2");
//			User tempUser3 = new User("us3","us3");
//
//			session.beginTransaction();
//			
//			System.out.println("saving user object");
//			session.save(tempUser1);	
//			session.save(tempUser2);	
//			session.save(tempUser3);	
//			
//			session.getTransaction().commit();
//			
//			System.out.println("done");
//		} finally {
//			factory.close();
//		}
//----INSERTING MULTIPLE DATA------------------------//	
		
////----READING DATA-----------------------------------//
//		
//		SessionFactory factory = new Configuration()
//		.configure("hibernate.cfg.xml")
//		.addAnnotatedClass(User.class)
//		.buildSessionFactory();
//
//Session session = factory.getCurrentSession();
//
//try {
//	System.out.println("creating new user object");
//	User tempUser = new User("tytyty4","tytyty");
//
//	session.beginTransaction();
//	
//	System.out.println("saving user object");
//	session.save(tempUser);	
//	
//	session.getTransaction().commit();
//	
//	System.out.println("Saved user, id: " + tempUser.getuserID());
//	
//	session = factory.getCurrentSession();
//	session.beginTransaction();
//	
//	System.out.println("\nGetting student witch id: " + tempUser.getuserID());
//	
//	User readUser = session.get(User.class, tempUser.getuserID());
//	
//	System.out.println("get complete: " + readUser);
//	
//	session.getTransaction().commit();
//	
//	System.out.println("done");
//} finally {
//	factory.close();
//}		
//		
////----READING DATA-----------------------------------//
		
		
		
		
	}

}
