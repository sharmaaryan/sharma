package com.niit.onlineshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
@Id
	private String id;
private String orderid;
private String billingaddressid;
private String shippingaddressid;
private String paymentmethod;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public String getBillingaddressid() {
	return billingaddressid;
}
public void setBillingaddressid(String billingaddressid) {
	this.billingaddressid = billingaddressid;
}
public String getShippingaddressid() {
	return shippingaddressid;
}
public void setShippingaddressid(String shippingaddressid) {
	this.shippingaddressid = shippingaddressid;
}
public String getPaymentmethod() {
	return paymentmethod;
}
public void setPaymentmethod(String paymentmethod) {
	this.paymentmethod = paymentmethod;
}

}
