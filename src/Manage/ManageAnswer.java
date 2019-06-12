package Manage;

import java.util.List;
import org.hibernate.Transaction;

import database.entities.Answer;
import database.entities.Question;
import database.entities.QuestionInTest;
import database.entities.Test;

public class ManageAnswer extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertAnswer(String answer, Question question) {

			Answer tempAnswer = new Answer(answer, question);
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
			public int UpdateAnswer(int answerID, String answer, Question question) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					Answer tempAnswer = session.get(Answer.class, answerID);
					if(answer.equals(null))
						tempAnswer.setAnswer(answer);
					if(question != null)
						tempAnswer.setQuestion(question);
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
		
		public List<Answer> ListQuestionAnswers(int questionID) {
			List<Answer> allQuestionAnswers = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestionAnswers = session.createQuery("from Answer s where s.question.questionID ="+Integer.toString(questionID)).getResultList();

				for (Answer tempQuestionAnswers : allQuestionAnswers) {
					System.out.println(tempQuestionAnswers);
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
			return allQuestionAnswers;
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
		
		public Answer GetAnswer(int questionID, String answer) {
			Answer tempAnswer = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				tempAnswer = (Answer) session.createQuery("from Answer s where s.questionID=" + Integer.toString(questionID) + " and s.answer=\'" + answer + "\'").uniqueResult();

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
