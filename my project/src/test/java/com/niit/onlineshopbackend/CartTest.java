/*package com.niit.onlineshopbackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshop.DAO.CartDAO;
import com.niit.onlineshop.model.Cart;



public class CartTest {
	
		static AnnotationConfigApplicationContext context;
		@Autowired
		static Cart cart;
		@Autowired
		static CartDAO cartDAO;
		@Before
		public  void init()
		{
		 context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		 context.refresh();
	  cartDAO = (CartDAO) context.getBean("CartDAO");
	 cart = (Cart) context.getBean("cart");
		}
	 @Test
		public void CreateCartTest()
		{
	 
	 cart.setId("ca_04");
		cart.setOrderid("0_04");
		cart.setPaymentmethod("net banking");
		cart.setBillingaddressid("b_02");
		cart.setShippingaddressid("a_02");
		
		Assert.assertEquals("Create Cart Test",true,cartDAO.save(cart));
		
	}
	 @Test
		public void updateCartTest()
		{
	 
	 cart.setId("ca_02");
		cart.setOrderid("0_03");
		cart.setPaymentmethod("net bank");
		cart.setBillingaddressid("b_01");
		cart.setShippingaddressid("a_02");
		Assert.assertEquals("update Cart Test",true,cartDAO.update(cart));
	 }
	 @Test
		public void deleteCartTest()
		{
		 cart.setId("ca_04");
		 Assert.assertEquals("delete Cart Test",true,cartDAO.delete(cart));

		}
	 @Test
		public void getCartTest()
		{
			Assert.assertEquals("get Category Test Case",null,cartDAO.get("id"));
			
			
		}
		@Test
		public void getAllCategoryTestCase()
		{
			Assert.assertEquals("update Category Test Case",true,cartDAO.get("id"));

		}

}*/