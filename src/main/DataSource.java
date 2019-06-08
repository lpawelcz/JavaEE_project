package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.entities.*;	//import wszystkich klas z bazy danych

public class DataSource 
{
	//sekcja na dane 
	private List<User> usersData;
	private List<User> usersDataFromDB;
	private List<Test> testsDataFromDB;
	private List<Answer> answerDatatFromDB;
	private List<CompletedTest> completedTestDatatFromDB;
	private List<Description> descriptionDatatFromDB;
	private List<Opinion> opinionDatatFromDB;
	private List<Question> questionDatatFromDB;
	private List<QuestionInTest> questionInTestDatatFromDB;
	private List<Result> resultDatatFromDB;
	
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
		
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = factory.getCurrentSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		usersData = new ArrayList<User>();
		usersDataFromDB = new ArrayList<User>();
		
		try {
			session.beginTransaction();
			usersDataFromDB = session.createCriteria(User.class).list();
			session.getTransaction().commit();
			System.out.println("pobrano userow");
		} catch (HibernateException e) {
			e.printStackTrace();
		}	
		
		testsDataFromDB = new ArrayList<Test>();
		try {
			session.beginTransaction();
			testsDataFromDB = session.createCriteria(Test.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano testy z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		answerDatatFromDB = new ArrayList<Answer>();
		try {
			session.beginTransaction();
			answerDatatFromDB = session.createCriteria(Answer.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano odpowiedzi z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		completedTestDatatFromDB = new ArrayList<CompletedTest>();
		try {
			session.beginTransaction();
			completedTestDatatFromDB = session.createCriteria(CompletedTest.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano ukoñczone testy z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		descriptionDatatFromDB = new ArrayList<Description>();
		try {
			session.beginTransaction();
			descriptionDatatFromDB = session.createCriteria(Description.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano opisy z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		opinionDatatFromDB = new ArrayList<Opinion>();
		try {
			session.beginTransaction();
			opinionDatatFromDB = session.createCriteria(Opinion.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano opinie z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		questionDatatFromDB = new ArrayList<Question>();
		try {
			session.beginTransaction();
			questionDatatFromDB = session.createCriteria(Question.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano pytania z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		questionInTestDatatFromDB = new ArrayList<QuestionInTest>();
		try {
			session.beginTransaction();
			questionInTestDatatFromDB = session.createCriteria(QuestionInTest.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano pytania w tescie z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		resultDatatFromDB = new ArrayList<Result>();
		try {
			session.beginTransaction();
			resultDatatFromDB = session.createCriteria(Result.class).list();
			session.getTransaction().commit();
			System.out.println("Pobrano wyniki z bazy danych.");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public boolean userInData(User user)
	{
		for(User tempUser : usersDataFromDB)
		{
//			System.out.println(tempUser);
			if(user.getName().equals(tempUser.getName()) && user.getPassword().equals(tempUser.getPassword()))
			{
				return true;
			}
		}
		return false;
	}

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
	

	public void generateTestData() 
	{
		System.out.println("Start create users");
		usersData.add(new User("Pitok", "123"));
		usersData.add(new User("Mirek", "123"));
	}
	
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
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
}