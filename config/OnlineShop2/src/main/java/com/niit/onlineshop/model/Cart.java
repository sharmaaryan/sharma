package com.niit.onlineshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@Transient
private int total;

private String cartproduct_id;
private int price;
private String Quantity;
private String productName;
private String product_id;
private String user_id;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String getCartproduct_id() {
	return cartproduct_id;
}
public void setCartproduct_id(String cartproduct_id) {
	this.cartproduct_id = cartproduct_id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getQuantity() {
	return Quantity;
}
public void setQuantity(String quantity) {
	Quantity = quantity;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProduct_id() {
	return product_id;
}
public void setProduct_id(String product_id) {
	this.product_id = product_id;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}


}
