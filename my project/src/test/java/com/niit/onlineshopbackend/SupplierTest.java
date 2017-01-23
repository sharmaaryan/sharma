/*package com.niit.onlineshopbackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.onlineshop.DAO.SupplierDAO;

import com.niit.onlineshop.model.Supplier;

public class SupplierTest {
	static AnnotationConfigApplicationContext context;
	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;
	@Before
	public  void init()
	{
	 context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	 context.refresh();
  supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
  supplier = (Supplier) context.getBean("supplier");
	}
  @Test
	public void CreateSupplierTest()
	{
supplier.setId("sup_06");
	supplier.setAddress("chennai");
	supplier.setName("rnss");
	Assert.assertEquals("Create Supplier Test",true,supplierDAO.save(supplier));
	}
  @Test
	public void updateSupplierTest()
	{
	  supplier.setId("sup_06");
		supplier.setAddress("tiruttani");
		supplier.setName("rnss");
		Assert.assertEquals("Create Supplier Test",true,supplierDAO.update(supplier));
		}
  @Test
 	public void deleteSupplierTest()
 	{
  supplier.setId("sup_06");

	Assert.assertEquals("Create Supplier Test",true,supplierDAO.delete(supplier));
	}
  @Test
	public void getSupplierTest()
	{
		Assert.assertEquals("get Supplier Test",null,supplierDAO.get("id"));
		
		
	}
	@Test
	public void getAllSupplierTest()
	{
		Assert.assertEquals("get all Supplier Test",true,supplierDAO.get("id"));

	}


}*/