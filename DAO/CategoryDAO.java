package com.niit.onlineshop.DAO;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.onlineshop.model.Category;
@Repository("categoryDAO")
public interface CategoryDAO {
	public   boolean save(Category category);
//	public boolean update(Category category);
	public void delete(String id);
	public Category get(String id);
	public List<Category> list();
	public Category getName(String name);
	
	

}
