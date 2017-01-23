package com.niit.onlineshop.DAOImpl;

import com.niit.onlineshop.DAO.CategoryDAO;

import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

	@EnableTransactionManagement
	@Transactional
	@Repository("categoryDAO")
	public class CategoryDAOImpl implements CategoryDAO {
		
		@Autowired
		Category category;
		
		@Autowired
		SessionFactory sessionFactory;
		
		public CategoryDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public boolean save(Category category) {
			try {
				
	
				sessionFactory.getCurrentSession().saveOrUpdate(category);
				System.out.println("Data is added......");
				return true;
			} catch (HibernateException e) {
			
				e.printStackTrace();
			return false;
			}
		}
       @Transactional
		public void delete(String id) {
		 Category category=new Category();
		category.setCategory_id(id);
				sessionFactory.getCurrentSession().delete(category);
				
		}
	/*	@Transactional
			public boolean update(Category category) {
				try {
					sessionFactory.getCurrentSession().update(category);
					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				return false;
			}
		}*/
		@Transactional
		public Category get(String id) 
		{
		String hql="from Category where category_id="+"'"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> li=(List<Category>)query.list();
		if(li==null||li.isEmpty())
			return null;
		else
			return li.get(0);
		}
		
		@Transactional
		public List<Category> list() {
			String hql="from Category";
			List<Category> li=sessionFactory.getCurrentSession().createQuery(hql).list();
			if(li!=null||!li.isEmpty())
			return li;
			else
				return null;
		}
		
		
		
		
		@Transactional
		public Category getName(String name){
			String hql = "from Category where name=" + "'"+ name +"'";
			@SuppressWarnings("rawtype")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			
			@SuppressWarnings("unchecked")
			List<Category> liCategory = (List<Category>) query.list();
			if (liCategory != null && !liCategory.isEmpty())
				return liCategory.get(0);
			else
			return null;
			
			
			
					
	}
	
	}		
		


//		public boolean update(Category category) {
//			
//			try {
//				sessionFactory.getCurrentSession().update(category);
//				System.out.println("data updated");
//				return true;
//			} catch (HibernateException e) {
//					e.printStackTrace();
//			}
//			return false;
		
	
		
//		@Transactional
//		public boolean update(Category category) {
////			try {
//				if(get(category.getId())==null)
//				{
//					return false;
//				}
//				sessionFactory1.getCurrentSession().update(category);
//				return true;
//			} catch (HibernateException e) {
//			
//				e.printStackTrace();
			
//			return false;
//		}
//		
//		@Transactional
//		public boolean delete(Category category) {
////			try {
//				if(get(category.getId())==null)
//				{
//					return false;
//				}
//				sessionFactory1.getCurrentSession().delete(category);
//				return true;
//			} catch (HibernateException e) {
//				e.printStackTrace();
//		return false;
//		}
//		
//		@Transactional
//		public Category get(String id) {
////			return (Category)sessionFactory1.getCurrentSession().get(Category.class,id);			
//		return null;
//		}
//		//@Transactional
//	public Category list(String list) {
//		return null;
////		String hql="from category";
////		Query query=sessionFactory1.getCurrentSession().createQuery(hql);
////		
////			return query.list();
//	
//		
//	}
//}
