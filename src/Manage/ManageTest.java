package Manage;

import java.util.Formatter;
import java.util.List;

import org.hibernate.Transaction;


import database.entities.Test;
import database.entities.User;

public class ManageTest extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertTest(User author, boolean isPublic) {

			Test tempTest = new Test(author, isPublic);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempTest);
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
			public int UpdateTest(int testID, boolean isPublic) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					Test tempTest = session.get(Test.class, testID);
					tempTest.setPublic(isPublic);
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
			public int DeleteTest(int testID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from Test s where s.testID="+Integer.toString(testID)).executeUpdate();
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
		public List<Test> ListTest() {
			List<Test> allTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allTests = session.createQuery("from Test").getResultList();

				for (Test tempTest : allTests) {
					System.out.println(String.format("TestID: %s authorID: %d author_name: %s\n", tempTest.getTestID(), tempTest.getAuthor().getUserID(), tempTest.getAuthor().getName()));
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
			return allTests;
		}
	//----READING DATA-----------------------------------//	

}