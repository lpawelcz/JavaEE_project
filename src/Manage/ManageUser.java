package Manage;

import java.util.List;

import org.hibernate.Transaction;


import database.entities.User;

public class ManageUser extends Manage
{
//----INSERTING DATA---------------------------------//
	public int InsertUser(String name, String pass) {

		User tempUser = new User(name,pass);
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(tempUser);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			session.close();
		}

		System.out.println("done Inserting");
		return 0;
}
//----INSERTING DATA---------------------------------//	
	
//----UPDATE DATA------------------------------------//
		public int UpdateUser(int userID, String name) {

			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				User tempUser = session.get(User.class, userID);
				tempUser.setName(name);
// update smth on object
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
					throw e;
				}
			} finally {
				session.close();
			}

			System.out.println("done Updating");
			return 0;
	}
//----UPDATE DATA------------------------------------//	
		
		
//----DELETE DATA------------------------------------//
		public int DeleteUser(int userID) {

			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.createQuery("delete from User s where s.userID="+Integer.toString(userID)).executeUpdate();
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
					throw e;
				}
			} finally {
				session.close();
			}

			System.out.println("done Deleting");
			return 0;
	}
//----DELETE DATA------------------------------------//
	
//----READING DATA-----------------------------------//
	public List<User> ListUser() {
		
		System.out.println("manage user: list user");
		
		List<User> allUsers = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			allUsers = session.createQuery("from User").getResultList();

			for (User tempUser : allUsers) {
				System.out.println(tempUser);
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			session.close();
		}

		System.out.println("done Listing");
		return allUsers;
	}
	
	
	public User GetUser(int userID) {
		User tempUser = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			tempUser = (User) session.createQuery("from User s where s.userID ="+Integer.toString(userID)).getSingleResult();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			session.close();
		}

		System.out.println("done Read");
		return tempUser;
	}
	
	public User GetUser(String name) {
		User tempUser = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			tempUser = (User) session.createQuery("from User s where s.name='"+name+"'").uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			session.close();
		}

		System.out.println("done Read");
		return tempUser;
	}
//----READING DATA-----------------------------------//	

}
