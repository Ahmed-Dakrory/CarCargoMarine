/**
 * 
 */
package main.com.carService.customssettings;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class customssettingsRepositoryImpl implements customssettingsRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public customssettings addcustomssettings(customssettings data) {
		try{
			
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.saveOrUpdate(data);
			tx1.commit();
			session.close(); 
			return data; 
			}
			catch(Exception ex)
			{
				System.out.println(">>>>>>>>>>");
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<customssettings> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customssettings.getAll");

				 @SuppressWarnings("unchecked")
				List<customssettings> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(customssettings data)throws Exception {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(data);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public customssettings getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customssettings.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<customssettings> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}


	@Override
	public List<customssettings> getAllByUserId(int userId) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("customssettings.getAllByUserId").setInteger("id",userId);

		 @SuppressWarnings("unchecked")
		 List<customssettings> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	


}
