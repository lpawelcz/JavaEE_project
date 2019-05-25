package Manage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.entities.User;

public class Manage 
{
	public static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public Session session;
	
}


