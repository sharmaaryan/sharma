package com.niit.onlineshop.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.DAO.CartDAO;
import com.niit.onlineshop.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	Cart cart;
	@Autowired
	SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}



@Transactional
	public boolean save(Cart cart) {
		// TODO Auto-generated method stub
	try {
		sessionFactory.getCurrentSession().save(cart);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
@Transactional
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
	try {
		sessionFactory.getCurrentSession().update(cart);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
		return false;
	}
}
@Transactional
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
	try {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	return false;
	}
}
@Transactional
	public Cart get(String id) {
	String hql="from Cart where id='"+id+"'";
	List<Cart> cali=sessionFactory.getCurrentSession().createQuery(hql).list();
	if(cali==null||cali.isEmpty())
		return null;
	else
		return cali.get(0);
	}


@Transactional
	public List<Cart> list() {
	String hql="from Cart";
	List<Cart> cali=sessionFactory.getCurrentSession().createQuery(hql).list();
	return cali;
	

}
}
