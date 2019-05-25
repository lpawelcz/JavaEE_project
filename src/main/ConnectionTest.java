package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Manage.ManageUser;
import Manage.ManageTest;
import Manage.ManageResult;
import database.entities.User;



public class ConnectionTest {

	public static void main(String[] args) {
		
		ManageUser userManager = new ManageUser();
		ManageTest testManager = new ManageTest();
		ManageResult resultManager = new ManageResult();
		
//		resultManager.InsertResult(50,100);
//		resultManager.InsertResult(0,0);
//		resultManager.InsertResult(15,33.33f);
//		resultManager.InsertResult(16,42.1f);
//		resultManager.InsertResult(200,35.01f);
//		resultManager.InsertResult(45,44);
//		resultManager.InsertResult(63,34.4f);
//		resultManager.InsertResult(12,8.5f);
//		resultManager.InsertResult(65,76);
//		resultManager.InsertResult(34,29.9f);
		
//		resultManager.UpdateResult(5, 666, 66.66f);
//		resultManager.DeleteResult(9);
		resultManager.ListResult();
		
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
		
//		testManager.ListTest();
		
//		System.out.println("testy TestAuthora, po ID");
//		testManager.ListUserTests(55);
		
//		System.out.println("testy eee, po loginie");
//		testManager.ListUserTests("eee");

	}

}
