package com.niit.onlineshop.DAOImpl;


import com.niit.onlineshop.DAO.ProductDAO;

import com.niit.onlineshop.model.Product;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

	@Repository("productDAO")
	public class ProductDAOImpl implements ProductDAO {
		
		@Autowired
		Product product;
		
		@Autowired
		SessionFactory sessionFactory;
		
		public ProductDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
@Transactional
public boolean update(Product product) {
	// TODO Auto-generated method stub
	try {
		sessionFactory.getCurrentSession().update(product);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return false;
	}
}
@Transactional
public void delete(String id) {
	Product product=new Product();
	product.setId(id);
	
		sessionFactory.getCurrentSession().delete(product);
		
}
@Transactional
public Product get(String id) {
	String hql="from Product where id="+"'"+id+"'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Product> pli=(List<Product>)query.list();
	
	
	if(pli==null||pli.isEmpty())
		return null;
	else
		return pli.get(0);
	}

@Transactional
public boolean save(Product product) {
	try {
		sessionFactory.getCurrentSession().save(product);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	return false;
}
}
@Transactional
public List<Product> list() {
	String hql="from Product";
	List<Product> pli=sessionFactory.getCurrentSession().createQuery(hql).list();
	return pli;

}
	}
		
		