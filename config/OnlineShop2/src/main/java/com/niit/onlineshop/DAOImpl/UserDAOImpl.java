package com.niit.onlineshop.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.DAO.UserDAO;
import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.User;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

@Autowired
SessionFactory sessionFactory;
public UserDAOImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}


//===============SAVE FUNTION=====================================================//
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


//========================FOR UPDATE=====================================================//
/*@Transactional
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
*/


//==========================DELETE FUNCTION=======================================//
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



//===========================GET FUNCTION=========================================//
@Transactional
	public User get(int id) {

	String hql="from User where id="+id;
	List<User> uli=sessionFactory.getCurrentSession().createQuery(hql).list();
	if(uli==null||uli.isEmpty())
		return null;
	else
		return uli.get(0);
	}

	
//============================LIST FUNTION========================================//	
@Transactional
	public List<User> list() {
	String hql="from User";
	List<User> uli=sessionFactory.getCurrentSession().createQuery(hql).list();
	return uli;
	
	}


//=============================GETNAME FUNTION===============================//
@Transactional
public User getName(String name){
	String hql = "from User where user_name=" + "'"+ name +"'";
	
	@SuppressWarnings("rawtype")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	
	@SuppressWarnings("unchecked")
	List<User> list = query.list();
	
	if (list == null || list.isEmpty()){
		return null;
	}
	else
	{
		return list.get(0);
	}
	
}
}

