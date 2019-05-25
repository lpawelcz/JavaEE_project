package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Manage.ManageUser;
import Manage.ManageTest;
import Manage.ManageResult;
import Manage.ManageQuestion;
import Manage.ManageOpinion;
import Manage.ManageDescription;
import Manage.ManageAnswer;

import database.entities.User;
import database.entities.Test;
import database.entities.Answer;



public class ConnectionTest {

	public static void main(String[] args) {
		
//		ManageUser userManager = new ManageUser();
//		ManageTest testManager = new ManageTest();
//		ManageResult resultManager = new ManageResult();
//		ManageQuestion questionManager = new ManageQuestion();
//		ManageOpinion opinionManager = new ManageOpinion();		
//		ManageDescription descriptionManager = new ManageDescription();
		ManageAnswer answerManager = new ManageAnswer();
		
//		answerManager.InsertAnswer("odp1");
//		answerManager.InsertAnswer("odp2");
//		answerManager.InsertAnswer("odp9");
//		answerManager.InsertAnswer("odp4");
//		answerManager.InsertAnswer("odp5");
		
		answerManager.UpdateAnswer(3, "odp3");
		answerManager.DeleteAnswer(5);
		answerManager.ListAnswers();
		
//		descriptionManager.InsertDescription("q","a");
//		descriptionManager.InsertDescription("w","s");
//		descriptionManager.InsertDescription("e","d");
//		descriptionManager.InsertDescription("r","f");
//		descriptionManager.InsertDescription("t","g");
//		descriptionManager.InsertDescription("y","h");
//		descriptionManager.InsertDescription("u","j");
//		descriptionManager.InsertDescription("i","k");
//		descriptionManager.InsertDescription("o","l");
//		descriptionManager.InsertDescription("p",";");
		
//		descriptionManager.UpdateDescription(5, "Topic", "opis");
//		descriptionManager.DeleteDescription(9);
//		descriptionManager.ListDescription();
		
//		User User1 = userManager.GetUser("TestAuthor");
//		User User2 = userManager.GetUser(49);
//		User User3 = userManager.GetUser("eee");
//		User User4 = userManager.GetUser(53);
		
//		testManager.InsertTest(User1, true);
//		testManager.InsertTest(User1, false);
//		testManager.InsertTest(User2, true);
//		testManager.InsertTest(User2, true);
//		testManager.InsertTest(User2, false);		
//		testManager.InsertTest(User3, false);
//		testManager.InsertTest(User3, false);
//		testManager.InsertTest(User3, false);
//		testManager.InsertTest(User4, true);
//		testManager.InsertTest(User4, true);
		
//		Test Test1 = testManager.GetTest(1);
//		Test Test2 = testManager.GetTest(3);
//		Test Test3 = testManager.GetTest(6);
//		Test Test4 = testManager.GetTest(9);
		
//		opinionManager.InsertOpinion(User1, Test4, "q" , 0);
//		opinionManager.InsertOpinion(User2, Test3, "qw", 10);
//		opinionManager.InsertOpinion(User3, Test2, "qwe", 25.5f);
//		opinionManager.InsertOpinion(User4, Test1, "qwer", 48.01f);
//		opinionManager.InsertOpinion(User1, Test1, "qwert", 50);
//		opinionManager.InsertOpinion(User2, Test2, "qwerty", 65.99f);
//		opinionManager.InsertOpinion(User3, Test3, "qwertyu", 35.4f);
//		opinionManager.InsertOpinion(User4, Test4, "qwertyui", 100);
//		opinionManager.InsertOpinion(User1, Test1, "qwertyuio", 63);
		
//		opinionManager.UpdateOpinion(6, "dupa", 66.66f);
//		opinionManager.DeleteOpinion(8);
		
//		System.out.println("wszystkie");
//		opinionManager.ListOpinions();
//		System.out.println("opinie TestID = 1");
//		opinionManager.ListTestOpinions(1);
//		System.out.println("opinie UserID = 55");
//		opinionManager.ListUserOpinions(55);
//		System.out.println("opinie UserName = eee");
//		opinionManager.ListUserOpinions("eee");
		
		
//		userManager.InsertUser("pierwszy", "12234123");
//		userManager.InsertUser("John", "12234123");
//		userManager.InsertUser("asdf", "12234123");
//		userManager.InsertUser("eee", "12234123");
//		userManager.InsertUser("tyty", "12234123");
//		userManager.InsertUser("tytyt", "12234123");
//		userManager.InsertUser("qwerty", "12234123");
//		userManager.InsertUser("asdfgh", "12234123");
//		userManager.InsertUser("TestAuthor", "TestAuthor_pass");
		
		
//		List<Answer> answers = new ArrayList<Answer>();
	
//		questionManager.InsertQuestion(1,User1, "???", answers, 2);
//		questionManager.InsertQuestion(1,User2, "???", answers, 2);
//		questionManager.InsertQuestion(2,User3, "???", answers, 2);
//		questionManager.InsertQuestion(1,User4, "???", answers, 2);
//		questionManager.InsertQuestion(2,User1, "???", answers, 2);
//		questionManager.InsertQuestion(2,User2, "???", answers, 2);
//		questionManager.InsertQuestion(1,User3, "???", answers, 2);
//		questionManager.InsertQuestion(1,User4, "???", answers, 2);
//		questionManager.InsertQuestion(2,User1, "???", answers, 2);
		
//		questionManager.UpdateQuestion(4, "!!!", null, -1);
//		questionManager.DeleteQuestion(7);
//		questionManager.ListQuestions();
//		questionManager.ListUserQuestions("TestAuthor");
			
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
//		resultManager.ListResult();
				
//		userManager.ListUser();
			
		
//		testManager.ListTest();
		
//		System.out.println("testy TestAuthora, po ID");
//		testManager.ListUserTests(55);
		
//		System.out.println("testy eee, po loginie");
//		testManager.ListUserTests("eee");

	}

}
