package com.niit.onlineshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Product {
@Id
	private String Id;
	private String Name;
	private int price;
	private String Category_id;
	private String Supplier_id;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(String category_id) {
		Category_id = category_id;
	}
	public String getSupplier_id() {
		return Supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		Supplier_id = supplier_id;
	}
	
	
}
