package com.niit.onlineshop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.User;

@Repository("userDAO")
public interface UserDAO {
	public boolean save(User user);
	//public boolean update(User user);
	public boolean delete(User user);
	public User get(int id);
	public User getName(String name);
	public List<User> list();



	
}
