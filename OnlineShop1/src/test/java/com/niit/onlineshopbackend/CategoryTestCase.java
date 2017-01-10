package com.niit.onlineshopbackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.model.Category;





public class CategoryTestCase 
{

	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		
		
		//category.setCategory_id("cat06");
		//category.setName("footwear");
		//category.setDescription("kids shoe");
		//category.setId("cat05");
	//category.setName("electronics");
		//category.setDescription("tvs,refrigirators");
		//category.setId("cat06");
		//category.setName("grosseries");
		//category.setDescription("home needed");
		
		
		//category.setId("cat03");
		
		



		//categoryDAO.save(category);
		//categoryDAO.update(category);
		//categoryDAO.delete(category);
		//System.out.println("data deleted in db..");
		//System.out.println("data inserted into DB");
		
		List<Category> clist=categoryDAO.list();
		for(Category c:clist)
		{
			System.out.println("category name:"+c.getName());
			System.out.println("category ID:"+c.getCategory_id());
		}
		
	}

}
