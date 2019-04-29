package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.entities.User;

public class DataSource 
{

	//private HashMap<String, String> userSource;
	private List<User> usersData;
	private List<User> usersDataFromDB;
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
			System.out.println("Wczytani u¿ytkownicy: id: " + tempUser.getuserID() + ", name: " + tempUser.getName() + ", password: " + tempUser.getPassword());
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
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		session = factory.getCurrentSession();
		
		
		//userSource = new HashMap<String, String>();
		usersData = new ArrayList<User>();
		usersDataFromDB = new ArrayList<User>();
		
		
		session.beginTransaction();
		usersDataFromDB = session.createCriteria(User.class).list();
		System.out.println("Zakonczono pobieranie uzytkownikow.");		
		session.getTransaction().commit();
		
	}
	
	public boolean userInData(User user)
	{
		for(User tempUser : usersDataFromDB)
		{
			System.out.println(tempUser);
			if(user.getName().equals(tempUser.getName()) && user.getPassword().equals(tempUser.getPassword()))
			{
				//System.out.println("");
				return true;
			}
		}
		return false;
	}

	public void register(String name, String password) 
	{
		User tempUser = new User(name, password);
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(tempUser);
		session.getTransaction().commit();	
		
		usersDataFromDB.add(tempUser);
	}

	public boolean userExists(User user) 
	{
		if(usersData.contains(user))
			return true;
		else
			return false;
	}

	private void generateTestData() 
	{
		System.out.println("Start create users.");
		usersData.add(new User("Pitok", "123"));
		usersData.add(new User("Mirek", "123"));
	}
	
	public void addUsersToDB()
	{
		session = factory.getCurrentSession();
		System.out.println("Starting connect with DB.");
		session.beginTransaction();
		
		System.out.println("Starting adding.");
		for(User tempUser : usersData)
		{
			session.save(tempUser);
			System.out.println("Saved user, id: " + tempUser.getuserID());
		}
		
		session.getTransaction().commit();
	}
	
	public void closeConnectionWithDB()
	{	
		session = factory.getCurrentSession();
		System.out.println("Starting close connection with DB.");
		session.close();
		factory.close();
	}
}