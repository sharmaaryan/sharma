package com.niit.onlineshop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Supplier;


@Repository("supplierDAO")
public interface SupplierDAO {
	public   boolean save(Supplier supplier);
	//public boolean update(Supplier supplier);
	public void delete(String id);
	public Supplier get(String id);
	public Supplier getName(String name);
	public List<Supplier> list();

}
