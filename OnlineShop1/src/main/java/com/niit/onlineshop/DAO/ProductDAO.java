/*package com.niit.onlineshop.



import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;
@Repository("productDAO")
public interface ProductDAO {
	public   void save(Product product);
//	public boolean update(Category category);
	public void delete(String id);
	public Product get(String product);
	public List<Product> list();
	public Product getName(String product);
	
	//access_specifier  return_type  function_name(parameter)

}
*/


//======================================================================================//
package com.niit.onlineshop.DAO;

import java.util.List;

import com.niit.onlineshop.model.Product;

public interface ProductDAO 
{
	public void save(Product product);
	  //public Product getProduct(String id); 	   
	   public void delete(String id);
	   public Product get(String product);
	   public List<Product> list(); 	   
	   public Product getName(String product);
	   
}
