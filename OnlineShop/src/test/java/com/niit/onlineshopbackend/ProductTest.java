/*package com.niit.onlineshopbackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.model.Product;

public class ProductTest {
	static AnnotationConfigApplicationContext context;
	@Autowired
	static Product product;
	@Autowired
	static ProductDAO productDAO;
	@Before
	public  void init()
	{
	 context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	 context.refresh();
	 productDAO = (ProductDAO) context.getBean("productDAO");
	 product = (Product) context.getBean("product");
}
	 @Test
		public void CreateProductTest()
		{
		product.setCategory_id("c_02");
		product.setId("p_03");
		product.setName("bags");
		product.setPrice(3000);
		product.setSupplier_id("sup_01");
		Assert.assertEquals("Create Product Test",true,productDAO.save(product));
		}
	 @Test
		public void updateProductTest()
		{
product.setId("p_03");
product.setName("bags");
product.setPrice(2500);
product.setCategory_id("c_02");
product.setSupplier_id("sup_01");
Assert.assertEquals("Create Product Test",true,productDAO.update(product));

       }
	 @Test
		public void deleteProductTest()
		{
		product.setId("p_04");
	 		
		
		Assert.assertEquals("Create Product Test",true,productDAO.delete(product));
		}
		
	 @Test
		public void getProductTest()
		{
			Assert.assertEquals("get Product Test Case",null,productDAO.get("id"));
			
			
		}
		@Test
		public void getAllProductTestCase()
		{
			Assert.assertEquals("get all Product Test Case",true,productDAO.get("id"));

		}

}
		*/