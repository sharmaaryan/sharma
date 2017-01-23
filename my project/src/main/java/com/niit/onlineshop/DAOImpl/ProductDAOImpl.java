/*package com.niit.onlineshop.DAOImpl;


import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.Supplier;

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
		public boolean save(Product product) {

			try {
				sessionFactory.getCurrentSession().saveOrUpdate(product);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			return false;
			}
		}
		
		
		
		
		
@Transactional
public boolean update(Product product) {

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





@Transactional
public Product getName(String name)
{
	String hql ="from product where product_name = " + "'" + name +"'";
	
	
	@SuppressWarnings("rawtype")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Product> listProduct = query.list();
	
	if(listProduct!=null || !listProduct.isEmpty())
	{
		return listProduct.get(0);
	  }
	 return null;
   }

	
	@Transactional
	public Product getProduct(String id) {
		String hql = "from Product where id=" + "'"+ id +"'";
		@SuppressWarnings("rawtypes")
		Query query= sessionFactory.getCurrentSession().createQuery(hql); 
		@SuppressWarnings("unchecked")
		List<Product> listProduct = query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	}
*/


package com.niit.onlineshop.DAOImpl;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.model.Product;


@SuppressWarnings({ "deprecation", "unused" })
@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public void save(Product product)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	
	}
	
	@Transactional
	public void delete(String id)
	{
		Product producttodelete=new Product();
		producttodelete.setProduct_id(id);
		sessionFactory.getCurrentSession().delete(producttodelete);
		
	}
	
	
	@Transactional
	public Product get(String id) {
		String hql = "from Product where product_id=" + "'"+ id +"'";
		@SuppressWarnings("rawtypes")
		Query query= sessionFactory.getCurrentSession().createQuery(hql); 
		@SuppressWarnings("unchecked")
		List<Product> listProduct = query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	
	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}
	
	@Transactional
	public List<Product> somelist()
	{
		String hql = "from Product";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0).setMaxResults(5);
		 
		List<Product> someprolist = query.list();
		if(someprolist != null || !someprolist.isEmpty())
		{
			return someprolist;
		}
		return null;
	}
	
	
	@Transactional
	public Product getName(String name) {
		String hql = "from Product where product_name=" + "'"+ name +"'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
		return null;
	}

	@Transactional
	public List<Product> getByCatPro(String name)
	{
		String hql = "from Product where category_id =" + "'" + name + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Product> catlistpro = query.list();
		
		if(catlistpro != null || !catlistpro.isEmpty())
		{
			return catlistpro;
		}
		return null;
	}





	}



//====================================================================//

/*package com.niit.onlineshop.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.model.Product;

//import antlr.collections.List;

//connects the database by taking from pojo class 
@EnableTransactionManagement
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{	
	@Autowired
	private SessionFactory sessionFactory; 
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public void addProduct(Product product)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	
	@Transactional
	public void delete(String Id)
	{
		Product product=new Product();
		product.setProduct_id(Id);
		sessionFactory.getCurrentSession().delete(product);
	}
	
	@Transactional
	public Product getProduct(String Id)
	{
		String hql="from Product where p_id=" +"'"+Id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct=(List<Product>)query.list();
		if(listProduct!=null && !listProduct.isEmpty())
		{
			return listProduct.get(0);
		}
		
		return null;
	}
	
	
	
	@Transactional
	public Product getByName(String name)
	{
		String hql="from Product where p_name=" +"'"+name+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct=(List<Product>)query.list();
		if(listProduct!=null && !listProduct.isEmpty())
		{
			return listProduct.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public List<Product> list()
	{
		List<Product> listProduct=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listProduct;
	}
	
}
*/