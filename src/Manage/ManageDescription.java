package Manage;

	import java.util.List;

	import org.hibernate.Transaction;

import database.entities.Description;
import database.entities.Test;

	public class ManageDescription extends Manage {
		//----INSERTING DATA---------------------------------//
			public int InsertDescription(String topic, String description) {

				Description tempDescription = new Description(topic,description);
				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					session.save(tempDescription);
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
				public int UpdateDescription(int descID, String topic, String description) {

					session = factory.getCurrentSession();
					Transaction transaction = null;

					try {
						transaction = session.beginTransaction();
						Description tempDescription = session.get(Description.class, descID);
						if(topic != null)
							tempDescription.setTopic(topic);
						if(description != null)
							tempDescription.setDescription(description);
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
				public int DeleteDescription(int descID) {

					session = factory.getCurrentSession();
					Transaction transaction = null;

					try {
						transaction = session.beginTransaction();
						session.createQuery("delete from Description s where s.descID="+Integer.toString(descID)).executeUpdate();
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
			public List<Description> ListDescription() {
				List<Description> allDescriptions = null;
				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					allDescriptions = session.createQuery("from Description").getResultList();

					for (Description tempDescription : allDescriptions) {
						System.out.println(tempDescription);
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
				return allDescriptions;
			}
			
			public Description GetDescription(int descID) {
				Description tempDescription = null;
				session = factory.getCurrentSession();
				Transaction transaction = null;

				try {
					transaction = session.beginTransaction();
					tempDescription = (Description) session.createQuery("from Description s where s.descID=" + Integer.toString(descID)).uniqueResult();

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
				return tempDescription;
			}
		//----READING DATA-----------------------------------//	

	}
