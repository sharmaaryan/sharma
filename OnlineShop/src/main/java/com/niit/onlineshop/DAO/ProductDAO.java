package com.niit.onlineshop.DAO;

import java.util.List;

import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;

public interface ProductDAO {
	public   boolean save(Product product);
	public boolean update(Product product);
	public void delete(String id);
	public Product get(String id);
	public List<Product> list();
	

}
