/*package com.niit.onlineshopbackend;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.model.Category;


public class categorytest {
	
static AnnotationConfigApplicationContext context;
	@Autowired
	static Category category;
	@Autowired
	static CategoryDAO categoryDAO;
	@Before
	public  void init()
	{
	 context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	 context.refresh();
 categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
	 category=(Category) context.getBean("category");
	}
	@Test
	public void CreateCategoryTest()
	{
		category.setId("cat_08");
		category.setName("electronics");
		category.setDescription("mobile");
	
	Assert.assertEquals("Create Category Test",true,categoryDAO.save(category));
	}

	@Test
	public void updateCategoryTest()
	{
		category.setId("cat_07");
		category.setName("Footwear");
		category.setDescription("kidsshoes");
		Assert.assertEquals("update Category Test",true,categoryDAO.update(category));
	
	}
	@Test
	public void deleteCategoryTest()
	{
		category.setId("cat_07");
		
		Assert.assertEquals("update Category Test",true,categoryDAO.delete(category));
	
	}
	@Test
	public void getCategoryTest()
	{
		Assert.assertEquals("get Category Test",null,categoryDAO.get("id"));
		
		
	}
	@Test
	public void getAllCategoryTest()
	{
		Assert.assertEquals("get all Category Test",true,categoryDAO.get("id"));

	}
	}
	
*/