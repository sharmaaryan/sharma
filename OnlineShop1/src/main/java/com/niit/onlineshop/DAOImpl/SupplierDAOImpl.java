package com.niit.onlineshop.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Cart;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO{


		@Autowired
		Supplier supplier;
		
		@Autowired
		SessionFactory sessionFactory;
		
		public SupplierDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}

	
@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return false;
	}
	}
/*@Transactional
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return false;
	}
	}*/
@Transactional
	public void delete(String id) {
	Supplier supplier=new Supplier();
	supplier.setSupplier_id(id);
	
			sessionFactory.getCurrentSession().delete(supplier);
			
	}




@SuppressWarnings("null")
@Transactional
	public Supplier get(String id) {
		
			
	String hql="from Supplier where supplier_id="+"'"+id+"'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Supplier> sli=(List<Supplier>)query.list();
	
			if(sli==null||sli.isEmpty())
				return null;
			else
				return sli.get(0);
			}
	
	




@Transactional
	public List<Supplier> list() {
		
	String hql="from Supplier";
		List<Supplier> sli=sessionFactory.getCurrentSession().createQuery(hql).list();
		return sli;
	}


@SuppressWarnings("null")
@Transactional
public Supplier getName(String name)
{
	String hql ="from Supplier where name = " + "'" + name +"'";
	
	
	@SuppressWarnings("rawtype")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Supplier> listSupplier = query.list();
	
	if(listSupplier!=null || !listSupplier.isEmpty())
	{
		return listSupplier.get(0);
	}
	return null;
}
}






	
		


