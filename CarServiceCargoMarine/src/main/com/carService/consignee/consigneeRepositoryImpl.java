/**
 * 
 */
package main.com.carService.consignee;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.carService.loginNeeds.user;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class consigneeRepositoryImpl implements consigneeRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public consignee addconsignee(consignee data) {
		try{
			user addedUser=data.getUserId();
			addedUser.setLastUpdate(Calendar.getInstance());
			data.setUserId(addedUser);
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
	public List<consignee> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("consignee.getAll");

				 @SuppressWarnings("unchecked")
				List<consignee> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(consignee data)throws Exception {
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
	public consignee getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("consignee.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<consignee> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public List<consignee> getAllByParentId(int idParent) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("consignee.getAllByParentId").setInteger("id",idParent);

		 @SuppressWarnings("unchecked")
		List<consignee> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<consignee> getAllByUserId(int id) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("consignee.getAllByUserId").setInteger("id",id);

				 @SuppressWarnings("unchecked")
				List<consignee> results=query.list();
					 return results;
	}

	@Override
	public List<consignee> getAllByMainAccountIdOfParentShipper(int idUserParent) {
		Query query 	=sessionFactory.getCurrentSession().getNamedQuery("consignee.getAllByParentOfParentId").setInteger("id",idUserParent);

		 @SuppressWarnings("unchecked")
		List<consignee> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public consignee getAllByParentIdAndUserId(int id, int idUser) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("consignee.getAllByParentIdAndUserId").setInteger("id",id).setInteger("idUser",idUser);

				 @SuppressWarnings("unchecked")
				List<consignee> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}
	


}
