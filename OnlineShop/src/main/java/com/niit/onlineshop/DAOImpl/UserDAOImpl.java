package com.niit.onlineshop.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.DAO.UserDAO;

import com.niit.onlineshop.model.User;
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
@Autowired
User user;
@Autowired
SessionFactory sessionFactory;
public UserDAOImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}

@Transactional
	public boolean save(User user) {
	try {
		sessionFactory.getCurrentSession().save(user);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		return false;
	}
	}
@Transactional
	public boolean update(User user) {
	try {
		sessionFactory.getCurrentSession().update(user);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
		return false;
	}
	}
@Transactional
	public boolean delete(User user) {
	try {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	return false;
	}
	}
@Transactional
	public User get(String id) {

	String hql="from User where id='"+id+"'";
	List<User> uli=sessionFactory.getCurrentSession().createQuery(hql).list();
	if(uli==null||uli.isEmpty())
		return null;
	else
		return uli.get(0);
	}

	
	
@Transactional
	public List<User> list() {
	String hql="from User";
	List<User> uli=sessionFactory.getCurrentSession().createQuery(hql).list();
	return uli;
	
	}

}
