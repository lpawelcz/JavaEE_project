package Manage;

import java.util.List;

import org.hibernate.Transaction;

import database.entities.Answer;
import database.entities.User;
import database.entities.Question;
import database.entities.Test;

public class ManageQuestion extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertQuestion(int DTYPE, User author, String question, List<Answer> answers, int correctID) {

			Question tempQuestion = new Question(DTYPE, author, question, answers,correctID);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempQuestion);
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
			public int UpdateQuestion(int questionID, String question, List<Answer> answers, int correctID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					Question tempClosedQuestion = session.get(Question.class, questionID);
					if(question != null)
						tempClosedQuestion.setQuestion(question);
					if(answers != null)
						tempClosedQuestion.setAnswers(answers);
					if(correctID != -1)
						tempClosedQuestion.setCorrectID(correctID);
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
			public int DeleteQuestion(int questionID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from Question s where s.questionID="+Integer.toString(questionID)).executeUpdate();
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
		public List<Question> ListQuestions() {
			List<Question> allQuestions = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestions = session.createQuery("from Question").getResultList();

				for (Question tempQuestion : allQuestions) {
					System.out.println(String.format("QuestionID: %s question: %s author_name: %s", tempQuestion.getQuestionID(),tempQuestion.getQuestion(), tempQuestion.getAuthor().getName()));
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
			return allQuestions;
		}
		
		
		public List<Question> ListUserQuestions(int userID) {
			List<Question> allQuestions = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestions = session.createQuery("from Question s where s.author.userID ="+Integer.toString(userID)).getResultList();

				for (Question tempQuestion : allQuestions) {
					System.out.println(String.format("QuestionID: %s question: %s author_name: %s", tempQuestion.getQuestionID(),tempQuestion.getQuestion(), tempQuestion.getAuthor().getName()));
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
			return allQuestions;
		}
		
		public List<Question> ListUserQuestions(String name) {
			List<Question> allQuestions = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allQuestions = session.createQuery("FROM Question t where t.author.name ='"+name+"'").getResultList();

				for (Question tempQuestion : allQuestions) {
					System.out.println(String.format("ClosedQuestionID: %s question: %s author_name: %s", tempQuestion.getQuestionID(),tempQuestion.getQuestion(), tempQuestion.getAuthor().getName()));
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
			return allQuestions;
		}
		
		public Question GetQuestion(int questionID) {
			Question tempQuestion = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				tempQuestion = (Question) session.createQuery("from Question s where s.questionID=" + Integer.toString(questionID)).uniqueResult();

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
			return tempQuestion;
		}
	//----READING DATA-----------------------------------//	

}