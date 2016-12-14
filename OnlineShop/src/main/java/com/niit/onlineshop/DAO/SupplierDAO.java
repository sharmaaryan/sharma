package com.niit.onlineshop.DAO;

import java.util.List;

import com.niit.onlineshop.model.Supplier;



public interface SupplierDAO {
	public   boolean save(Supplier supplier);
	//public boolean update(Supplier supplier);
	public void delete(String id);
	public Supplier get(String id);
	public List<Supplier> list();

}
