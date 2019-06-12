package Manage;

import java.util.List;

import org.hibernate.Transaction;

import database.entities.QuestionInTest;
import database.entities.Test;
import database.entities.Question;

public class ManageQuestionInTest extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertQuestionInTest(Test test, Question question) {

			QuestionInTest tempQuestionInTest = new QuestionInTest(test, question);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempQuestionInTest);
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
			public int DeleteQuestionInTest(int questionintestID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from QuestionInTest s where s.questionintestID="+Integer.toString(questionintestID)).executeUpdate();
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
		public List<QuestionInTest> ListQuestionInTest() {
			List<QuestionInTest> allQuestionsInTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestionsInTests = session.createQuery("from QuestionInTest").getResultList();

				for (QuestionInTest tempQuestionInTest : allQuestionsInTests) {
					System.out.println(tempQuestionInTest);
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
			return allQuestionsInTests;
		}
		
		
		public List<QuestionInTest> ListQuestionQuestionInTest(int questionID) {
			List<QuestionInTest> allQuestionsInTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestionsInTests = session.createQuery("from QuestionInTest s where s.question.questionID ="+Integer.toString(questionID)).getResultList();

				for (QuestionInTest tempQuestionInTest : allQuestionsInTests) {
					System.out.println(tempQuestionInTest);
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
			return allQuestionsInTests;
		}
		
		public List<QuestionInTest> ListTestQuestionInTest(int testID) {
			List<QuestionInTest> allQuestionsInTests = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestionsInTests = session.createQuery("from QuestionInTest s where s.test.testID ="+Integer.toString(testID)).getResultList();

				for (QuestionInTest tempQuestionInTest : allQuestionsInTests) {
					System.out.println(tempQuestionInTest);
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
			return allQuestionsInTests;
		}
		
	//----READING DATA-----------------------------------//	

}