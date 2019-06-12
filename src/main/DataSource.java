package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.entities.*;	//import wszystkich klas z bazy danych
import Manage.*;

public class DataSource 
{
	//sekcja na dane 
	//dane które bêd¹ wprowadzane do programu, a potem do bazy danych, po dodaniu danych trzeba odœwie¿yæ dane w listach danych z bazy danych
	private List<User> usersData;
	private List<Test> testsData;
	private List<Answer> answerDatat;
	private List<CompletedTest> completedTestDatat;
	private List<Description> descriptionDatat;
	private List<Opinion> opinionDatat;
	private List<Question> questionDatat;
	private List<QuestionInTest> questionInTestDatat;
	private List<Result> resultDatat;
	//dane z bazy danych
	private List<User> usersDataFromDB;
	private List<Test> testsDataFromDB;
	private List<Answer> answerDatatFromDB;
	private List<CompletedTest> completedTestDatatFromDB;
	private List<Description> descriptionDatatFromDB;
	private List<Opinion> opinionDatatFromDB;
	private List<Question> questionDatatFromDB;
	private List<QuestionInTest> questionInTestDatatFromDB;
	private List<Result> resultDatatFromDB;
	//managerowie danych z bazy
	private ManageUser manageUsers;
	private ManageAnswer manageAnswers;
	private ManageCompletedTest manageCompletedTests;
	private ManageDescription manageDescriptions;
	private ManageOpinion manageOpinions;
	private ManageResult manageResults;
	private ManageTest manageTests;
	private ManageQuestion manageQuestions;
	private ManageQuestionInTest manageQuestionInTests;
	
	
	SessionFactory factory;
	Session session;
	
	public static void main(String[] args)
	{
		DataSource d = new DataSource();
		User u = new User("root","admin");

//		System.out.println("creating new user object");
//		User tempUser1 = new User("us4","us4");
//		User tempUser2 = new User("root","admin");
//		User tempUser3 = new User("us5","us5");
//		
//		d.session = d.factory.getCurrentSession();
//		d.session.beginTransaction();
//		
//		System.out.println("saving user objects");
//		d.session.save(tempUser1);	
//		d.session.save(tempUser2);	
//		d.session.save(tempUser3);	
//		
//		d.session.getTransaction().commit();
//		System.out.println("done");
//		
		
		
		
		System.out.println("Rozpoczêto pobieranie uzytkownikow.");
		/*for(int i=1; i<=2; i++)
		{
			User readUser = d.session.get(User.class, i);

			System.out.println("get complete: " + readUser);
			d.usersDataFromDB.add(readUser);
		}*/
		d.session = d.factory.getCurrentSession();
		d.session.beginTransaction();
		d.usersDataFromDB = d.session.createCriteria(User.class).list();
		System.out.println("Zakonczono pobieranie uzytkownikow.");		
		d.session.getTransaction().commit();
		System.out.println("Pobrano u¿ytkowników z bazy danych");
		
		for(User tempUser : d.usersDataFromDB)
		{
			System.out.println("Wczytani u¿ytkownicy: id: " + tempUser.getUserID() + ", name: " + tempUser.getName() + ", password: " + tempUser.getPassword());
			//System.out.println(tempUser);
		}
		
		if(d.userInData(u))//napisaæ sprawdzanie userów
		//if(true)
		{
			System.out.println("Mo¿na zalogowaæ siê do bazy.");
			d.generateTestData();
			d.addUsersToDB();
			
			d.closeConnectionWithDB();
		}
		else
		{
			System.out.println("B³êdna nazwa uzytkownika, badz haslo.");
		}
		
		d.closeConnectionWithDB();
	}

	public DataSource() 
	{
		manageUsers = new ManageUser();
		manageAnswers = new ManageAnswer();
		manageCompletedTests = new ManageCompletedTest();
		manageDescriptions = new ManageDescription();
		manageOpinions = new ManageOpinion();
		manageResults = new ManageResult();
		manageTests = new ManageTest();
		manageQuestions = new ManageQuestion();
		manageQuestionInTests = new ManageQuestionInTest();
		
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = factory.getCurrentSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		usersData = new ArrayList<User>();
		testsData = new ArrayList<Test>();
		answerDatat = new ArrayList<Answer>();
		completedTestDatat = new ArrayList<CompletedTest>();
		descriptionDatat = new ArrayList<Description>();
		opinionDatat = new ArrayList<Opinion>();
		questionDatat = new ArrayList<Question>();
		questionInTestDatat = new ArrayList<QuestionInTest>();
		resultDatat = new ArrayList<Result>();
		
		usersDataFromDB = new ArrayList<User>();
		
		//pobranie danych z bazy danych
		usersDataFromDB = manageUsers.ListUser();
		testsDataFromDB = manageTests.ListTest();
		answerDatatFromDB = manageAnswers.ListAnswers();
		completedTestDatatFromDB = manageCompletedTests.ListCompletedTest();
		descriptionDatatFromDB = manageDescriptions.ListDescription();
		opinionDatatFromDB = manageOpinions.ListOpinions();
		questionDatatFromDB = manageQuestions.ListQuestions();
		questionInTestDatatFromDB = manageQuestionInTests.ListQuestionInTest();
		resultDatatFromDB = manageResults.ListResult();
	}
	
	public boolean userInData(User user)
	{
		//System.out.println("user in data ####################################################");
		for(User tempUser : usersDataFromDB)
		{
//			System.out.println(tempUser);
			if(user.getName().equals(tempUser.getName()) && user.getPassword().equals(tempUser.getPassword()))
			{
				//System.out.println("ID: " + user.getUserID() + ", name: " + user.getName());
				return true;
			}
		}
		return false;
	}

	/**
	 * Funkcja rejestruj¹ca u¿ytkownika.
	 * @param name - nazwa u¿ytkownika
	 * @param password - has³o u¿ytkownika
	 */
	public void register(String name, String password) 
	{
		User tempUser = new User(name, password);
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(tempUser);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		usersDataFromDB.add(tempUser);
	}

	/**
	 * Funkcja sprawdzaj¹ca istnienie u¿ytkownika w bazie danych.
	 * @param user 
	 * @return true jeœli istnieje, w p.p. false.
	 */
	public boolean userExists(User user) 
	{
		for(User tempUser : usersDataFromDB)
		{
			if(user.getName().equals(tempUser.getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Funkcja generuj¹ca przyk³adowe dane.
	 */
	public void generateTestData() 
	{
		System.out.println("Start create users");
		usersData.add(new User("Pitok", "123"));
		usersData.add(new User("Mirek", "123fd"));
		usersData.add(new User("Tester", "test"));
		
		System.out.println("Start create descriptions.");
		descriptionDatatFromDB.add(new Description("Wypisywanie informacji.", "Funkcje wypisuj¹ce o plikach, katalogach itp w systemie Linux."));
		descriptionDatatFromDB.add(new Description("Modyfikowanie informacji.", "Funkcje modyfikuj¹ce informacje o plikach, katalogach itp w systemie Linux."));
		descriptionDatatFromDB.add(new Description("Przemieszczanie.", "Funkcje pozwalaj¹ce na przemieszczenie pomiêdzy katalogami w systemie Linux."));
		
		System.out.println("Start create opinions.");
		//User author, Test test, String opinion, float rate
		opinionDatatFromDB.add(new Opinion(usersDataFromDB.get(0), testsDataFromDB.get(0), "Wszystko spoko ;)", 5));
		opinionDatatFromDB.add(new Opinion(usersDataFromDB.get(1), testsDataFromDB.get(0), "Nawet nawet", (float) 3.5));
		opinionDatatFromDB.add(new Opinion(usersDataFromDB.get(2), testsDataFromDB.get(1), "Beznadzieja", 1));
		
		System.out.println("Start create questions.");
		//int DTYPE, User author, String question, List<Answer> answers, int correctID
		questionDatatFromDB.add(new Question(1, usersDataFromDB.get(0), "Jak przejœæ do katalogu wy¿ej?", null, 2));
		questionDatatFromDB.add(new Question(2, usersDataFromDB.get(2), "Jak wyœwietliæ info o wszystkich plikach?", null, 1));
		questionDatatFromDB.add(new Question(3, usersDataFromDB.get(0), "Jak zmodyfikowaæ prawa dostêpu pliku?", null, 3));
		
		
		System.out.println("Start create tests.");
		testsDataFromDB.add(new Test(usersDataFromDB.get(0), descriptionDatatFromDB.get(0), true));
		testsDataFromDB.add(new Test(usersDataFromDB.get(1), descriptionDatatFromDB.get(1), false));
		testsDataFromDB.add(new Test(usersDataFromDB.get(2), descriptionDatatFromDB.get(2), true));
		
		System.out.println("Start create questions in tests.");
		//Test test, Question question
		questionInTestDatatFromDB.add(new QuestionInTest(testsDataFromDB.get(0), questionDatatFromDB.get(0)));
		questionInTestDatatFromDB.add(new QuestionInTest(testsDataFromDB.get(0), questionDatatFromDB.get(1)));
		questionInTestDatatFromDB.add(new QuestionInTest(testsDataFromDB.get(1), questionDatatFromDB.get(2)));
		
		System.out.println("Start create answers.");
		/*answerDatatFromDB.add(new Answer("ls -a", questionDatatFromDB.get(0).getQuestionID()));
		answerDatatFromDB.add(new Answer("ls -l", questionDatatFromDB.get(1).getQuestionID()));
		answerDatatFromDB.add(new Answer("ls", questionDatatFromDB.get(2).getQuestionID()));
		answerDatatFromDB.add(new Answer("cd ..", questionDatatFromDB.get(3).getQuestionID()));
		answerDatatFromDB.add(new Answer("cd ../..", questionDatatFromDB.get(4).getQuestionID()));
		answerDatatFromDB.add(new Answer("cd .", questionDatatFromDB.get(5).getQuestionID()));//*/
		
		System.out.println("Start create results.");
		resultDatatFromDB.add(new Result(50, 100));
		resultDatatFromDB.add(new Result(25, 50));
		resultDatatFromDB.add(new Result((float)12.5, 25));
		
		System.out.println("Start create completedTests.");
		//User user, Test test, Result result
		completedTestDatatFromDB.add(new CompletedTest(usersDataFromDB.get(0), testsDataFromDB.get(0), resultDatatFromDB.get(0)));
		completedTestDatatFromDB.add(new CompletedTest(usersDataFromDB.get(1), testsDataFromDB.get(1), resultDatatFromDB.get(1)));
		completedTestDatatFromDB.add(new CompletedTest(usersDataFromDB.get(1), testsDataFromDB.get(1), resultDatatFromDB.get(2)));
	}
	
	/**
	 * Funkcja dodaj¹ca u¿ytkowników zawartych w usersData do bazy danych.
	 * Po dodaniu danych usersData jest czyszczone, a usersDataFromDB jest aktualizowane.
	 */
	public void addUsersToDB()
	{
		try {
			System.out.println("Starting connect with DB.");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Starting adding.");
			for(User tempUser : usersData)
			{
				session.save(tempUser);
				System.out.println("Saved user, id: " + tempUser.getUserID());
			}

			session.getTransaction().commit();
			
			usersData.clear();
			usersDataFromDB.clear();

			try {
				session.beginTransaction();
				usersDataFromDB = session.createCriteria(User.class).list();
				session.getTransaction().commit();
				System.out.println("pobrano userow");
			} catch (HibernateException e) {
				e.printStackTrace();
			}	
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Funkcja tworz¹ca po³¹czenie z baz¹ danych.
	 */
	public void closeConnectionWithDB()
	{	
		try {
			session = factory.getCurrentSession();
			System.out.println("Starting close connection with DB.");
			session.close();
			factory.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean testowaFunkcja()
	{
		return true;
	}

	public List<User> getUsersDataFromDB()
	{
		return usersDataFromDB;
	}
	public List<Test> getTestsDataFromDB()
	{
		System.out.println("#### no to wypisujemy ###");
		for(int i=0; i<testsDataFromDB.size(); i++)
		{
			System.out.println(testsDataFromDB.get(i).toString());
		}
		return testsDataFromDB;
	}
	public List<Answer> answerDatatFromDB()
	{
		return answerDatatFromDB;
	}
	public List<CompletedTest> completedTestDatatFromDB()
	{
		return completedTestDatatFromDB;
	}
	public List<Description> descriptionDatatFromDB()
	{
		return descriptionDatatFromDB;
	}
	public List<Opinion> opinionDatatFromDB()
	{
		return opinionDatatFromDB;
	}
	public List<Question> questionDatatFromDB()
	{
		return questionDatatFromDB;
	}
	public List<QuestionInTest> questionInTestDatatFromDB()
	{
		return questionInTestDatatFromDB;
	}
	public List<Result> resultDatatFromDB()
	{
		return resultDatatFromDB;
	}
}