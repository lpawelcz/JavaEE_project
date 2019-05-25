package Manage;

import java.util.List;

import org.hibernate.Transaction;


import database.entities.Result;

public class ManageResult extends Manage {
	//----INSERTING DATA---------------------------------//
		public int InsertResult(float points, float prcntgOfUnderstanding) {

			Result tempResult = new Result(points,prcntgOfUnderstanding);
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				session.save(tempResult);
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
			public int UpdateResult(int resultID, float points, float prcntgOfUnderstanding) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					Result tempResult = session.get(Result.class, resultID);
					tempResult.setPoints(points);
					tempResult.setPrcntgOfUnderstanding(prcntgOfUnderstanding);
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
			public int DeleteResult(int resultID) {

				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.createQuery("delete from Result s where s.resultID="+Integer.toString(resultID)).executeUpdate();
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
		public List<Result> ListResult() {
			List<Result> allResults = null;
			session = factory.getCurrentSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				allResults = session.createQuery("from Result").getResultList();

				for (Result tempResult : allResults) {
					System.out.println(String.format("ResultID: %s points: %f prcntgOfUnderstanding: %f", tempResult.getResultID(), tempResult.getPoints(), tempResult.getPrcntgOfUnderstanding()));
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
			return allResults;
		}
	//----READING DATA-----------------------------------//	

}
