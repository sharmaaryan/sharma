/*package com.niit.onlineshopbackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.onlineshop.DAO.UserDAO;

import com.niit.onlineshop.model.User;

public class UserTest {

	static AnnotationConfigApplicationContext context;
	@Autowired
	static UserDAO userDAO;
	@Autowired
	static User user;
	@Before
	public  void init()
	{
	 context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	 context.refresh();
	 userDAO = (UserDAO) context.getBean("UserDAO");
	 user = (User) context.getBean("user");
	}
  @Test
	public void CreateUserTest()
	{
  user.setId("u_03");
		user.setContact("9490571564");
		user.setMail("vineeth@gmail.com");
		user.setName("vineethgv");
		user.setPassword("vineeth123");
		user.setRole("user"); 
	Assert.assertEquals("Create Supplier Test",true,userDAO.save(user));
	}
  @Test
	public void updateUserTest()
	{
 user.setContact("9490571564");
 user.setId("u_02");
 user.setMail("spurthi@gmail.com");
 user.setPassword("85005683");
 user.setRole("user");
		Assert.assertEquals("update Supplier Test",true,userDAO.update(user));
		}
  @Test
 	public void deleteSupplierTest()
 	{
  user.setId("u_03");

	Assert.assertEquals("delete User Test",true,userDAO.delete(user));
	}
  @Test
	public void getUserTest()
	{
		Assert.assertEquals("get user Test",null,userDAO.get("id"));
		
		
	}
	@Test
	public void getAlluserTest()
	{
		Assert.assertEquals("get all Supplier Test",true,userDAO.get("id"));

	}

}

*/