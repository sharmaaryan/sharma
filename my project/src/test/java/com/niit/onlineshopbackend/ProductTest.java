package com.niit.onlineshopbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.model.Product;

public class ProductTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO"); 
		Product product = (Product)context.getBean("product");
		
		product.setProduct_id("PRO_001");
		product.setProduct_name("Camera");
		product.setProduct_description("new product");
		product.setProduct_price(2500);
		product.setProduct_stock("50");
		product.setSize("20");
		product.setCategory_id("dat11");
		product.setSupplier_id("jda22");
		
		
		productDAO.save(product);
	} 
}
		