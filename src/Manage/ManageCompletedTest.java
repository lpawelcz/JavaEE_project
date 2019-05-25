package Manage;

import java.util.List;

import org.hibernate.Transaction;

import database.entities.CompletedTest;
import database.entities.Result;
import database.entities.Test;
import database.entities.User;

public class ManageCompletedTest extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertCompletedTest(User user, Test test, Result result) {

			CompletedTest tempCompletedTest = new CompletedTest(user, test, result);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempCompletedTest);
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
		
	//----DELETE DATA------------------------------------//
			public int DeleteCompletedTest(int completedtestID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from CompletedTest s where s.completedtestID="+Integer.toString(completedtestID)).executeUpdate();
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
		public List<CompletedTest> ListCompletedTest() {
			List<CompletedTest> allCompletedTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allCompletedTests = session.createQuery("from CompletedTest").getResultList();

				for (CompletedTest tempCompletedTest : allCompletedTests) {
					System.out.println(String.format("TestID: %s user_name: %s "+tempCompletedTest.getResult(), tempCompletedTest.getTest().getTestID(), tempCompletedTest.getUser().getName()));
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
			return allCompletedTests;
		}
		
		
		public List<CompletedTest> ListUserCompletedTest(int userID) {
			List<CompletedTest> allCompletedTest = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allCompletedTest = session.createQuery("from CompletedTest s where s.user.userID ="+Integer.toString(userID)).getResultList();

				for (CompletedTest tempCompletedTest : allCompletedTest) {
					System.out.println(String.format("TestID: %s user_name: %s "+tempCompletedTest.getResult(), tempCompletedTest.getTest().getTestID(), tempCompletedTest.getUser().getName()));
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
			return allCompletedTest;
		}
		
		public List<CompletedTest> ListUserCompletedTest(String name) {
			List<CompletedTest> allCompletedTest = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allCompletedTest = session.createQuery("FROM CompletedTest t where t.user.name ='"+name+"'").getResultList();

				for (CompletedTest tempCompletedTest : allCompletedTest) {
					System.out.println(String.format("TestID: %s user_name: %s "+tempCompletedTest.getResult(), tempCompletedTest.getTest().getTestID(), tempCompletedTest.getUser().getName()));
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
			return allCompletedTest;
		}
		
		public List<CompletedTest> ListTestCompletedTest(int testID) {
			List<CompletedTest> allCompletedTest = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allCompletedTest = session.createQuery("from CompletedTest s where s.test.testID ="+Integer.toString(testID)).getResultList();

				for (CompletedTest tempCompletedTest : allCompletedTest) {
					System.out.println(String.format("TestID: %s user_name: %s "+tempCompletedTest.getResult(), tempCompletedTest.getTest().getTestID(), tempCompletedTest.getUser().getName()));
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
			return allCompletedTest;
		}
		
	//----READING DATA-----------------------------------//	

}
