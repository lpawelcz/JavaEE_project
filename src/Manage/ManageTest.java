package Manage;

import java.util.List;

import org.hibernate.Transaction;

import database.entities.Description;
import database.entities.Test;
import database.entities.User;

public class ManageTest extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertTest(User author, Description description, boolean isPublic) {

			Test tempTest = new Test(author,description, isPublic);
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
//					System.out.println(String.format("TestID: %s authorID: %d author_name: %s", tempTest.getTestID(), tempTest.getAuthor().getUserID(), tempTest.getAuthor().getName()));
					System.out.println(tempTest);
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
		
		
		public List<Test> ListUserTests(int userID) {
			List<Test> allTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allTests = session.createQuery("from Test s where s.author.userID ="+Integer.toString(userID)).getResultList();

				for (Test tempTest : allTests) {
					System.out.println(tempTest);
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

			System.out.println("done Read");
			return allTests;
		}
		
		public List<Test> ListUserTests(String name) {
			List<Test> allTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allTests = session.createQuery("FROM Test t where t.author.name ='"+name+"'").getResultList();

				for (Test tempTest : allTests) {
					System.out.println(tempTest);
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

			System.out.println("done Read");
			return allTests;
		}
		
		public List<Test> ListTopicTests(String topic) {
			List<Test> allTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allTests = session.createQuery("FROM Test t where t.description.topic ='"+topic+"'").getResultList();

				for (Test tempTest : allTests) {
					System.out.println(tempTest);
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

			System.out.println("done Read");
			return allTests;
		}
		
	public Test GetTest(int testID) {
		Test tempTest = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			tempTest = (Test) session.createQuery("from Test s where s.testID=" + Integer.toString(testID)).uniqueResult();

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
		return tempTest;
	}
	
	
	public Test GetTest(User author, Description description) {
		Test tempTest = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			tempTest = (Test) session.createQuery("from Test s where s.userID=" + Integer.toString(author.getUserID()) + " AND s.descriptionID=" + description.getDescID()).uniqueResult();

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
		return tempTest;
	}
	
	//----READING DATA-----------------------------------//	

}
