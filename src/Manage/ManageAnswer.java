package Manage;

import java.util.List;
import org.hibernate.Transaction;

import database.entities.Answer;
import database.entities.Test;

public class ManageAnswer extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertAnswer(String answer) {

			Answer tempAnswer = new Answer(answer);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempAnswer);
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
			public int UpdateAnswer(int answerID, String answer) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					Answer tempAnswer = session.get(Answer.class, answerID);
					tempAnswer.setAnswer(answer);
					
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
			public int DeleteAnswer(int answerID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from Answer s where s.answerID="+Integer.toString(answerID)).executeUpdate();
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
		public List<Answer> ListAnswers() {
			List<Answer> allAnswers = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allAnswers = session.createQuery("from Answer").getResultList();

				for (Answer tempAnswer : allAnswers) {
					System.out.println(tempAnswer);
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
			return allAnswers;
		}
		
		public Answer GetAnswer(int asnwerID) {
			Answer tempAnswer = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				tempAnswer = (Answer) session.createQuery("from Answer s where s.answerID=" + Integer.toString(asnwerID)).uniqueResult();

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
			return tempAnswer;
		}
	//----READING DATA-----------------------------------//	

}
