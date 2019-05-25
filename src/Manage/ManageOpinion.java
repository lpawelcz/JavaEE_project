package Manage;

import java.util.List;
import org.hibernate.Transaction;

import database.entities.Test;
import database.entities.User;
import database.entities.Opinion;

public class ManageOpinion extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertOpinion(User author, Test test, String opinion, float rate) {

			Opinion tempOpinion = new Opinion(author, test, opinion, rate);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempOpinion);
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
			public int UpdateOpinion(int opinionID, String opinion, float rate) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					Opinion tempOpinion = session.get(Opinion.class, opinionID);
					if(opinion != null)
						tempOpinion.setOpinion(opinion);
					if(rate != -1)
						tempOpinion.setRate(rate);
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
			public int DeleteOpinion(int opinionID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from Opinion s where s.opinionID="+Integer.toString(opinionID)).executeUpdate();
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
		public List<Opinion> ListOpinions() {
			List<Opinion> allOpinions = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allOpinions = session.createQuery("from Opinion").getResultList();

				for (Opinion tempOpinion : allOpinions) {
					System.out.println(tempOpinion);
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
			return allOpinions;
		}
		
		
		public List<Opinion> ListUserOpinions(int userID) {
			List<Opinion> allOpinions = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allOpinions = session.createQuery("from Opinion s where s.author.userID ="+Integer.toString(userID)).getResultList();

				for (Opinion tempOpinion : allOpinions) {
					System.out.println(tempOpinion);
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
			return allOpinions;
		}
		

	public List<Opinion> ListUserOpinions(String name) {
		List<Opinion> allOpinions = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			allOpinions = session.createQuery("FROM Opinion t where t.author.name ='" + name + "'").getResultList();

			for (Opinion tempOpinion : allOpinions) {
				System.out.println(tempOpinion);
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
		return allOpinions;
	}
		
	public List<Opinion> ListTestOpinions(int testID) {
		List<Opinion> allOpinions = null;
		session = factory.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			allOpinions = session.createQuery("from Opinion s where s.test.testID ="+Integer.toString(testID)).getResultList();

			for (Opinion tempOpinion : allOpinions) {
				System.out.println(tempOpinion);
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
		return allOpinions;
	}
	//----READING DATA-----------------------------------//	

}

